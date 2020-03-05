package com.hazer.goods.service;

import com.hazer.goods.pojo.Brand;

import java.util.List;

/**
 * @ClassName: BrandService
 * @description: ${description}
 * @author: Hazer
 * @create: 2020-03-05 23:13
 **/
public interface BrandService {
    /**
     * 查询所有品牌
     *
     * @return
     */
    List<Brand> findAll();
}
