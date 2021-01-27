package com.qingcheng.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.qingcheng.service.goods.SkuService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: MaleHunter
 * @Date: 2021/1/27 15:54
 * @Package: com.qingcheng.controller
 * @CurrentProject: qingcheng_parent
 * @version: 1.0
 */

@RestController
@RequestMapping("/sku")
@CrossOrigin
public class skuController {

  @Reference
  private SkuService skuService;

  @GetMapping("/price")
  public Integer price(String id){
    System.out.println(id);
    Integer price = skuService.findPrice(id);
    return price;
  }
}
