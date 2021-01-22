package com.qingcheng.service.order;

import com.qingcheng.pojo.order.CategoryReport;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

/**
 * @Auther: MaleHunter
 * @Date: 2021/1/22 21:34
 * @Package: com.qingcheng.service.order
 * @CurrentProject: qingcheng_parent
 * @version: 1.0
 */
public interface CategoryReportService {


  public List<CategoryReport> category_Report(LocalDate localDate);

  public void createDate();

  public List<Map> category1Count(String date1, String date2);
}
