package com.qingcheng.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.qingcheng.pojo.goods.Goods;
import com.qingcheng.pojo.goods.Sku;
import com.qingcheng.pojo.goods.Spu;
import com.qingcheng.service.goods.CategoryService;
import com.qingcheng.service.goods.SpuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: MaleHunter
 * @Date: 2021/1/26 10:03
 * @Package: com.qingcheng.controller
 * @CurrentProject: qingcheng_parent
 * @version: 1.0
 */
@RestController
@RequestMapping("/item")
public class ItemController {

  @Reference
  private SpuService spuService;
  @Reference
  private CategoryService categoryService;

  @Autowired
  private TemplateEngine templateEngine;

  @Value("${pagePath}")
  private String pagePath;

  @GetMapping("/createPage")
  public void createPage(String spuId ){
    // 1 查询商品信息
    Goods goodsById = spuService.findGoodsById(spuId);
    Spu spu = goodsById.getSpu();
    // 获取sku列表
    List<Sku> skuList = goodsById.getSkuList();

    // 查询商品分类
    List<String> categoryList = new ArrayList<>();
    // 一级分类
    categoryList.add(categoryService.findById(spu.getCategory1Id()).getName());
    // 二级分类
    categoryList.add(categoryService.findById(spu.getCategory2Id()).getName());
    // 三级分类
    categoryList.add(categoryService.findById(spu.getCategory3Id()).getName());

    //sku地址列表
    Map<String,String> urlMap = new HashMap<String,String>();
    for (Sku sku:skuList){
      if ("1".equals(sku.getStatus())) {
        String specJson = JSON.toJSONString(JSON.parseObject(sku.getSpec()),SerializerFeature.MapSortField);
        urlMap.put(specJson,sku.getId() + ".html");
      }
    }





    // 2 批量生成sku页面
    for (Sku sku:skuList){
      // 1.创建上下文和数据模型
      Context context = new Context();
      Map<String,Object> dataModel = new HashMap<>();
      dataModel.put("spu",spu);
      dataModel.put("sku",sku);
      dataModel.put("categoryList",categoryList);
      // sku图片
      dataModel.put("skuImages",sku.getImages().split(","));
      // spu图片
      dataModel.put("spuImages",spu.getImages().split(","));
      // 参数列表
      Map paraItems = JSON.parseObject(spu.getParaItems());
      dataModel.put("paraItems",paraItems);
      // 规格列表
      Map specItems = JSON.parseObject(sku.getSpec());
      dataModel.put("specItems",specItems);
      // 规格和规格选项
      Map<String,List> specMap =(Map)JSON.parseObject(spu.getSpecItems());
      // 循环规格
      for (String key:specMap.keySet()){
        List<String> list = specMap.get(key);
        List<Map> mapList = new ArrayList<Map>();
        // 循环规格选项
        for (String value:list){
          Map map = new HashMap();
          // 规格选项
          map.put("option",value);
          // 是否选中
          if (specItems.get(key).equals(value)){ // 判断此规格的组合是否是当前sku的标记选中状态
            map.put("checked",true);
          } else {
            map.put("checked",false);
          }
          //当前的sku
          Map<String,String> spec = (Map)JSON.parseObject(sku.getSpec());
          spec.put(key,value);
          String specJson = JSON.toJSONString(spec, SerializerFeature.MapSortField);
          map.put("url",urlMap.get(specJson));
          mapList.add(map);
        }
        // 用新的集合替换原有的集合
        specMap.put(key,mapList);

      }

      dataModel.put("specMap",specMap);



      // 数据装入
      context.setVariables(dataModel);



      // 2.准备文件
      File dir = new File(pagePath);
      if (!dir.exists()){
        dir.mkdirs();
      }
      File dest = new File(dir, sku.getId()+".html");
      // 3.生成页面
      try {
        PrintWriter writer = new PrintWriter(dest,"UTF-8");
        templateEngine.process("item",context, writer);
        System.out.println("生成页面" + sku.getId() + ".html");
      } catch (FileNotFoundException e) {
        e.printStackTrace();
      } catch (UnsupportedEncodingException e) {
        e.printStackTrace();
      }



    }




  }
}
