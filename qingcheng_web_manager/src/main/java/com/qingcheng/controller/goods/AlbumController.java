package com.qingcheng.controller.goods;

import com.alibaba.dubbo.config.annotation.Reference;
import com.qingcheng.entity.PageResult;
import com.qingcheng.entity.Result;
import com.qingcheng.pojo.goods.Album;
import com.qingcheng.service.goods.AlbumService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

/**
 * @Auther: MaleHunter
 * @Date: 2021/1/17 15:51
 * @Package: com.qingcheng.controller.goods
 * @CurrentProject: qingcheng_parent
 * @version: 1.0
 */
@RestController
@RequestMapping("/album")
public class AlbumController {
  @Reference
  private AlbumService albumService;

  @GetMapping
  public List<Album> findAll(){
    return albumService.findAll();
  }
  @GetMapping("/findPage")
  public PageResult<Album> findPage(int page, int size){
    return albumService.findPage(page,size);
  }
  @PostMapping("/findList")
  public List<Album> findList(@RequestBody Map<String, Object> searchMap){
    return albumService.findList(searchMap);
  }
  @PostMapping("/findPage")
  public PageResult<Album> findPage(@RequestBody Map<String,Object> searchMap,int page,int size){
    return albumService.findPage(searchMap,page,size);
  }
  @GetMapping("/findById")
  public Album findById(Long id){
    return albumService.findById(id);
  }
  @PostMapping("/add")
  public Result add(@RequestBody Album album){
    albumService.add(album);
    return new Result();
  }
  @PostMapping("/update")
  public Result update(Album album){
    albumService.update(album);
    return new Result();
  }
  @GetMapping("/delete")
  public Result delete(Long id){
    albumService.delete(id);
    return new Result();
  }

}
