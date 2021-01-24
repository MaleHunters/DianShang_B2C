package com.qingcheng.controller;

import comqingcheng.util.WebUtil;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Auther: MaleHunter
 * @Date: 2021/1/24 20:54
 * @Package: com.qingcheng.controller
 * @CurrentProject: qingcheng_parent
 * @version: 1.0
 */
public class AuthenticationSuccessHandlerImpl implements AuthenticationSuccessHandler {


  @Override
  public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
    //登陆后调用
    System.out.println("登陆成功，记录了日志");
    //当前的登录名
    String authenticationName = authentication.getName();
    System.out.println("当前登录名为：" + authenticationName);
    //ip地址  远程客户端的ip
    String remoteAddr = httpServletRequest.getRemoteAddr();
    System.out.println("远程客户端的ip为：" + remoteAddr);
    // 通过IP获得登陆用户所在的地区
    System.out.println("用户所在的地区为：" + WebUtil.getCityByIP(remoteAddr));
    String header = httpServletRequest.getHeader("user-agent");
    String browserName = WebUtil.getBrowserName(header);
    System.out.println("浏览器名为：" + browserName);
    httpServletRequest.getRequestDispatcher("/main.html").forward(httpServletRequest,httpServletResponse);
  }
}
