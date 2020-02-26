package com.shop.goods.service;

import com.shop.goods.pojo.Brand;

import java.util.List;

public interface BrandService {
    /**
     * 查询所有品牌
     * @return
     */
     List<Brand> findAll();
    /**
     * 根据ID查询
     * @param id
     * @return
     */
    Brand findById(Integer id);

    /***
     * 新增
     * @param brand
     */
    void add(Brand brand);

    /***
     * 修改
     * @param brand
     */
    void update(Brand brand);

    /***
     * 删除
     * @param id
     */
    void delete(Integer id);
}
