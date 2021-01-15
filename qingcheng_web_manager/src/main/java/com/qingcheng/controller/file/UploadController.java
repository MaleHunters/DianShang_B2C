package com.qingcheng.controller.file;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

/**
 * @Auther: MaleHunter
 * @Date: 2021/1/15 14:39
 * @Package: com.qingcheng.controller.file
 * @CurrentProject: qingcheng_parent
 * @version: 1.0
 */
@RestController
@RequestMapping("/upload")
public class UploadController {
  @Autowired
  private HttpServletRequest request;



  @PostMapping("/native")
  public String nativeUpload(@RequestParam("file") MultipartFile file){
    // 文件上传的目标目录
    String path = request.getSession().getServletContext().getRealPath("image");
    // 目录加文件名
    String filePath = path+"/" + file.getOriginalFilename();

    File desFile = new File(filePath);
    if(!desFile.getParentFile().exists()){
      desFile.mkdir();
    }
    try {
      file.transferTo(desFile);
    } catch (IOException e) {
      e.printStackTrace();
    }


    return "http://localhost:9101/image/" + file.getOriginalFilename();
  }
}
