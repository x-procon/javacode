package com.hazer.gyo.dao;

import entity.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ClassName DeptDao
 * @Description TODO
 * @Author Hazer
 * @Date 2020/1/22 19:19
 **/
@Repository
@Mapper
public interface DeptDao {
    Boolean addDept(Dept dept);

    Dept findById(Long id);

    List<Dept> findAll();
}
