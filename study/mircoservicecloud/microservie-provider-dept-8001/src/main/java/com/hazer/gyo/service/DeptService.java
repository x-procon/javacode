package com.hazer.gyo.service;

import entity.Dept;

import java.util.List;

/**
 * @ClassName DeptService
 * @Description TODO
 * @Author Hazer
 * @Date 2020/1/22 19:24
 **/

public interface DeptService {
    public boolean add(Dept dept);

    public Dept get(Long id);

    public List<Dept> list();
}
