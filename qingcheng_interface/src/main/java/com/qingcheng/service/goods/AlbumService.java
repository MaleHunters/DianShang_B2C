package com.qingcheng.service.goods;

import com.qingcheng.entity.PageResult;
import com.qingcheng.pojo.goods.Album;

import java.util.List;
import java.util.Map;

/**
 * @Auther: MaleHunter
 * @Date: 2021/1/17 15:04
 * @Package: com.qingcheng.service.goods
 * @CurrentProject: qingcheng_parent
 * @version: 1.0
 */
public interface AlbumService {
  // 查找全部
  public List<Album> findAll();
  // 分页查找
  public PageResult<Album> findPage(int page, int size);
  // 条件查询
  public List<Album> findList(Map<String,Object> searchMap);
  // 条件分页查询
  public PageResult<Album> findPage(Map<String, Object> searchMap,int page, int size);
  // 根据id查询
  public Album findById(Long  id);
  // 添加
  public void add(Album album);
  // 更新
  public void update(Album album);
  // 根据id删除
  public void delete(Long id);
}
