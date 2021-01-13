package com.qingcheng.service.goods;

import com.qingcheng.entity.PageResult;
import com.qingcheng.pojo.goods.Brand;

import java.util.List;
import java.util.Map;

/**
 * @Auther: MaleHunter
 * @Date: 2021/1/12 13:15
 * @Package: com.qingcheng.service.goods
 * @CurrentProject: qingcheng_parent
 * @version: 1.0
 */
public interface BrandService {

  // 查找全部
  public List<Brand> findAll();
  // 分页查询
  public PageResult<Brand> findPage(int page, int size);
  // 条件查询
  public List<Brand> findList(Map<String,Object> searchMap);
  // 条件加分页查询
  public PageResult<Brand> findPage(Map<String, Object> searchMap, int page, int size);
  // 根据id查询
  public Brand findById(Integer id);
  // 新增
  public void add(Brand brand);
  // 根据id更新
  public void update(Brand brand);
  // 根据id删除
  public void delete(Integer id);
}
