package com.qingcheng.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: MaleHunter
 * @Date: 2021/1/24 15:42
 * @Package: com.qingcheng.controller
 * @CurrentProject: qingcheng_parent
 * @version: 1.0
 */
@RestController
@RequestMapping("/login")
public class LoginController {

  @GetMapping("/name")
  public Map showName(){
    String name = SecurityContextHolder.getContext().getAuthentication().getName();
    Map map = new HashMap();
    map.put("name",name);
    return map;

  }

}
