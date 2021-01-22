package com.qingcheng.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.qingcheng.dao.CategoryReportMapper;
import com.qingcheng.pojo.order.CategoryReport;
import com.qingcheng.service.order.CategoryReportService;
import org.springframework.beans.factory.NamedBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

/**
 * @Auther: MaleHunter
 * @Date: 2021/1/22 21:36
 * @Package: com.qingcheng.service.impl
 * @CurrentProject: qingcheng_parent
 * @version: 1.0
 */
@Service(interfaceClass = CategoryReportService.class)
public class CategoryReportServiceImpl implements CategoryReportService {

  @Autowired
  private CategoryReportMapper categoryReportMapper;
  @Override
  public List<CategoryReport> category_Report(LocalDate localDate) {

    return categoryReportMapper.category_Report(localDate);
  }

  @Transactional
  @Override
  public void createDate() {
    // 查询昨天的类目统计数据
    LocalDate localDate = LocalDate.now().minusDays(1);
    List<CategoryReport> categoryReports = categoryReportMapper.category_Report(localDate);

    //保存到tb_category_report
    for (CategoryReport categoryReport:categoryReports){
      categoryReportMapper.insert(categoryReport);
    }

  }

  @Override
  public List<Map> category1Count(String date1, String date2) {
    return categoryReportMapper.category1Count(date1, date2);
  }
}
