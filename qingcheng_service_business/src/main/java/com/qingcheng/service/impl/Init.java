package com.qingcheng.service.impl;

import com.qingcheng.service.business.AdService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Auther: MaleHunter
 * @Date: 2021/1/27 11:10
 * @Package: com.qingcheng.service.impl
 * @CurrentProject: qingcheng_parent
 * @version: 1.0
 */
@Component
public class Init implements InitializingBean {
  @Autowired
  private AdService adService;
  @Override
  public void afterPropertiesSet() throws Exception {
    System.out.println("缓存预热开始");
    adService.saveAllAdToRedis();
    System.out.println("缓存预热结束");


  }
}
