package com.qingcheng.controller.order;

import com.alibaba.dubbo.config.annotation.Reference;
import com.qingcheng.pojo.order.CategoryReport;
import com.qingcheng.service.order.CategoryReportService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

/**
 * @Auther: MaleHunter
 * @Date: 2021/1/22 21:38
 * @Package: com.qingcheng.controller.order
 * @CurrentProject: qingcheng_parent
 * @version: 1.0
 */
@RestController
@RequestMapping("/categoryReport")
public class CategoryReportController {

  @Reference
  private CategoryReportService categoryReportService;
  // 昨天的数据
  @GetMapping("/yesterday")
  public List<CategoryReport> yesterday(){
    LocalDate date = LocalDate.now().minusDays(1); //得到昨天的日期
    return categoryReportService.category_Report(date);

  }


  @GetMapping("/category1Count")
  public List<Map> category1Count(String date1, String date2){
    return categoryReportService.category1Count(date1,date2);
  }
}
