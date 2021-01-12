package com.qingcheng.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.qingcheng.pojo.goods.Brand;
import com.qingcheng.service.goods.BrandService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

}
