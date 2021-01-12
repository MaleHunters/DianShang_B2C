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


  public List<Brand> findAll();
  public PageResult<Brand> findPage(int page, int size);
  public List<Brand> findList(Map<String,Object> searchMap);
  public PageResult<Brand> findPage(Map<String, Object> searchMap, int page, int size);
}
