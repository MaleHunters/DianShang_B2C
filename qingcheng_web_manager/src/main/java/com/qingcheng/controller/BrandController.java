package com.qingcheng.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.qingcheng.entity.PageResult;
import com.qingcheng.entity.Result;
import com.qingcheng.pojo.goods.Brand;
import com.qingcheng.service.goods.BrandService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @Auther: MaleHunter
 * @Date: 2021/1/12 13:21
 * @Package: com.qingcheng.controller
 * @CurrentProject: qingcheng_parent
 * @version: 1.0
 */
@RestController
@RequestMapping("/brand")
public class BrandController {

  //注入远程的接口，如果是本地的可以用autowaire
  @Reference
  private BrandService brandService;
  @RequestMapping("/findAll")
  public List<Brand> findAll(){
    return brandService.findAll();
  }
  @GetMapping("/findPage")
  public PageResult<Brand> findPage(int page,int size){

    return brandService.findPage(page, size);
  }
  @PostMapping("/findList")
  public List<Brand> findList(@RequestBody Map searchMap){
    return brandService.findList(searchMap);
  }
  @PostMapping("/findPage")
  public PageResult<Brand> findPage(@RequestBody Map searchMap ,int page, int size){
    return brandService.findPage(searchMap,page,size);
  }
  @GetMapping("/findById")
  public Brand findById(Integer id){
    return brandService.findById(id);
  }
  @PostMapping("/add")
  public Result add(@RequestBody Brand brand){
    // int x=1/0;
    brandService.add(brand);
    return new Result();
  }
  @PostMapping("/update")
  public Result update(@RequestBody Brand brand){
    brandService.update(brand);
    return new Result();
  }
  @PostMapping("/delete")
  public Result delete(Integer id){
    brandService.delete(id);
    return new Result();
  }
}
