package com.qingcheng.service.impl;

import com.qingcheng.service.goods.CategoryService;
import com.qingcheng.service.goods.SkuService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Auther: MaleHunter
 * @Date: 2021/1/27 10:28
 * @Package: com.qingcheng.service.impl
 * @CurrentProject: qingcheng_parent
 * @version: 1.0
 */
// 启动自动运行
@Component
public class Init implements InitializingBean {
  @Autowired
  private CategoryService categoryService;
  @Autowired
  private SkuService skuService;
  @Override
  public void afterPropertiesSet() throws Exception {
    System.out.println("categoryTree缓存预热开始");
    categoryService.saveCategoryTreeToRedis();
    System.out.println("categoryTree缓存预热结束");
    skuService.saveAllPriceToRedis();;
    System.out.println("skuPrice的缓存预热结束");


  }
}
