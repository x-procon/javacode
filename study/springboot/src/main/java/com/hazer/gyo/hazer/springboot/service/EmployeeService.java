package com.hazer.gyo.hazer.springboot.service;

import com.hazer.gyo.hazer.springboot.entity.Employee;

/**
 * @ClassName: EmployeeService
 * @Author: Hazer
 * @Description:
 * @Date: 2020/1/2 13:52
 * @Version: 1.0
 */
public interface EmployeeService {
    Employee getEmpById(Integer id);
}
