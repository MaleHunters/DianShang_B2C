package com.qingcheng.controller.file;

import com.aliyun.oss.OSSClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

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


  // 本地的文件上传
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

  // 阿里云oss 文件上传
  @Autowired
  private OSSClient ossClient;
  @PostMapping("/oss")
  public String ossUpload(@RequestParam("file") MultipartFile file, String folder){
    String buckName="malehunterqingcheng";
//    String filename = file.getOriginalFilename();
    String filename = folder + "/" + UUID.randomUUID() + file.getOriginalFilename();
    try {
      ossClient.putObject(buckName,filename,file.getInputStream());
    } catch (IOException e) {
      e.printStackTrace();
    }


    return "https://" + buckName + ".oss-cn-qingdao.aliyuncs.com/" + filename;
  }
}
