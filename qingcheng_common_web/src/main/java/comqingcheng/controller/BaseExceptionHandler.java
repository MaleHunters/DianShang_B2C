package comqingcheng.controller;

import com.qingcheng.entity.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Auther: MaleHunter
 * @Date: 2021/1/13 11:21
 * @Package: comqingcheng.controller
 * @CurrentProject: qingcheng_parent
 * @version: 1.0
 * 公共异常处理
 */
// 控制器通知类
@ControllerAdvice
public class BaseExceptionHandler {
  //用来指定检测的异常类型
  @ExceptionHandler(Exception.class)
  @ResponseBody
  //错误统一处理
  public Result error(Exception e){
    e.printStackTrace();
    System.out.println("调用了异常处理");
    return new Result(1,e.getMessage());

  }



}
