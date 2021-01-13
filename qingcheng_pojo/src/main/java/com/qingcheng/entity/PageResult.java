package com.qingcheng.entity;

import java.io.Serializable;
import java.util.List;

/**
 * @Auther: MaleHunter
 * @Date: 2021/1/12 15:38
 * @Package: com.qingcheng.entity
 * @CurrentProject: qingcheng_parent
 * @version: 1.0
 */
public class PageResult<T> implements Serializable {
  // 记录数
  private Long total;
  //结果集
  private List<T> rows;

  public Long getTotal() {
    return total;
  }

  public void setTotal(Long total) {
    this.total = total;
  }

  public List<T> getRows() {
    return rows;
  }

  public void setRows(List<T> rows) {
    this.rows = rows;
  }

  public PageResult(Long total, List<T> rows) {
    this.total = total;
    this.rows = rows;
  }

  public PageResult() {
  }
}
