package com.qingcheng.controller.order;

import com.alibaba.dubbo.config.annotation.Reference;
import com.qingcheng.service.order.CategoryReportService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Auther: MaleHunter
 * @Date: 2021/1/22 10:34
 * @Package: com.qingcheng.controller.order
 * @CurrentProject: qingcheng_parent
 * @version: 1.0
 */
@Component
public class OrderTask {
  @Scheduled(cron = "* * * * * ?")
  public  void orderTimeOutLogic(){
    System.out.println(new Date());
  }

  @Reference
  private CategoryReportService categoryReportService;

  @Scheduled(cron = "0 0 1 * * ?") // 每天的凌晨1点执行一次
  public void categoryReportDate(){

    System.out.println("生成统计类目");
    categoryReportService.createDate();
  }
}
