package com.hazer.goods.dao;

import com.hazer.goods.pojo.Brand;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;


/**
 * @ClassName: BrandMapper
 * @description: 品牌Mapper
 * @author: Hazer
 * @create: 2020-03-05 23:11
 **/
@Repository
public interface BrandMapper extends Mapper<Brand> {

}
