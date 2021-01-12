package com.qingcheng.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qingcheng.dao.BrandMapper;
import com.qingcheng.entity.PageResult;
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

  @Override
  public PageResult<Brand> findPage(int page, int size) {
    PageHelper.startPage(page, size);
    Page<Brand> pageResult = (Page<Brand>)brandMapper.selectAll();
    return new PageResult<>(pageResult.getTotal(),pageResult.getResult());
  }

}
