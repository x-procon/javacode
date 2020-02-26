package com.shop.goods.service.impl;

import com.shop.goods.dao.BrandMapper;
import com.shop.goods.pojo.Brand;
import com.shop.goods.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    private BrandMapper brandMapper;
    /**
     * 查询全部列表
     * @return
     */
    @Override
    public List<Brand> findAll() {
        return brandMapper.selectAll();
    }

    /**
     * 根据ID查询
     * @param id
     * @return
     */
    @Override
    public Brand findById(Integer id){
        return  (Brand) brandMapper.selectByPrimaryKey(id);
    }


    /**
     * 增加
     * @param brand
     */
    @Override
    public void add(Brand brand){
        brandMapper.insert(brand);
    }


    /**
     * 修改
     * @param brand
     */
    @Override
    public void update(Brand brand){
        brandMapper.updateByPrimaryKey(brand);
    }

    /**
     * 删除
     * @param id
     */
    @Override
    public void delete(Integer id){
        brandMapper.deleteByPrimaryKey(id);
    }
}
