package com.qingcheng.service.goods;
import com.qingcheng.entity.PageResult;
import com.qingcheng.pojo.goods.Goods;
import com.qingcheng.pojo.goods.Spu;

import java.util.*;

/**
 * spu业务逻辑层
 */
public interface SpuService {

    public List<Spu> findAll();

    public PageResult<Spu> findPage(int page, int size);

    public List<Spu> findList(Map<String, Object> searchMap);

    public PageResult<Spu> findPage(Map<String, Object> searchMap, int page, int size);

    public Spu findById(String id);

    public void add(Spu spu);

    public void update(Spu spu);

    public void delete(String id);

    public void saveGoods(Goods goods);

    public Goods findGoodsById(String id);

    //商品审核的方法定义
    public void audit(String id, String status, String message);
    //下架
    public void pull(String id);
    //上架
    public void put(String id);
    //批量上架
    public int putMany(String[] ids);

}
