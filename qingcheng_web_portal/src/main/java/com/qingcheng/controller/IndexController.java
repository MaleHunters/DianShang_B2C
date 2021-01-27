package com.qingcheng.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.qingcheng.pojo.business.Ad;
import com.qingcheng.service.business.AdService;
import com.qingcheng.service.goods.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;

/**
 * @Auther: MaleHunter
 * @Date: 2021/1/25 17:15
 * @Package: com.qingcheng.controller
 * @CurrentProject: qingcheng_parent
 * @version: 1.0
 */
@Controller
public class IndexController {

  @Reference
  private AdService adService;
  @Reference
  private CategoryService categoryService;

  @GetMapping("/index")
  public String index(Model model){

    // 得到首页广告轮播图的列表
    List<Ad> lbtList = adService.findByPosition("web_index_lb");
    model.addAttribute("lbt",lbtList);

    // 分类导航
    List<Map> categortyTree = categoryService.findCategortyTree();
    model.addAttribute("categoryList",categortyTree);

    return "index";
  }









}
