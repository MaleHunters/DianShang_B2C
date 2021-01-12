package com.qingcheng.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.qingcheng.dao.BrandMapper;
import com.qingcheng.pojo.goods.Brand;
import com.qingcheng.service.goods.BrandService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Auther: MaleHunter
 * @Date: 2021/1/12 13:17
 * @Package: com.qingcheng.service.impl
 * @CurrentProject: qingcheng_parent
 * @version: 1.0
 */
@Service
public class BrandServiceImpl implements BrandService {
  @Autowired
  private BrandMapper brandMapper;
  @Override
  public List<Brand> findAll() {
    return brandMapper.selectAll();
  }
}
