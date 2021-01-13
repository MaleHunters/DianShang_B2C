package com.qingcheng.entity;

import java.io.Serializable;

/**
 * @Auther: MaleHunter
 * @Date: 2021/1/13 10:36
 * @Package: com.qingcheng.entity
 * @CurrentProject: qingcheng_parent
 * @version: 1.0
 */
public class Result implements Serializable {
  //业务返回码 0:success, 1:false
  private Integer code;
  //消息
  private String message;

  public Result() {
    this.code = 0;
    this.message = "执行成功";
  }

  public Result(Integer code, String message) {
    this.code = code;
    this.message = message;
  }

  public Integer getCode() {
    return code;
  }

  public void setCode(Integer code) {
    this.code = code;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}
