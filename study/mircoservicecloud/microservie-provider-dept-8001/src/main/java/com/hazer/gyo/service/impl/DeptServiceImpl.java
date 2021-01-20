package com.hazer.gyo.service.impl;

import com.hazer.gyo.dao.DeptDao;
import com.hazer.gyo.service.DeptService;
import entity.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName DeptServiceImpl
 * @Description TODO
 * @Author Hazer
 * @Date 2020/1/22 19:25
 **/
@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    DeptDao deptDao;

    @Override
    public boolean add(Dept dept) {
        return deptDao.addDept(dept);
    }

    @Override
    public Dept get(Long id) {
        return deptDao.findById(id);
    }

    @Override
    public List<Dept> list() {
        return deptDao.findAll();
    }
}
