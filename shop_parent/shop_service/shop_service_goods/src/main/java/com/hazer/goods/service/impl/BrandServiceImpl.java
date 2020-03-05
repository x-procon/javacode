package com.hazer.goods.service.impl;

import com.hazer.goods.dao.BrandMapper;
import com.hazer.goods.pojo.Brand;
import com.hazer.goods.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName: BrandServiceImpl
 * @description:
 * @author: Hazer
 * @create: 2020-03-05 23:12
 **/
@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    BrandMapper brandMapper;

    @Override
    public List<Brand> findAll() {
        return brandMapper.selectAll();
    }
}
