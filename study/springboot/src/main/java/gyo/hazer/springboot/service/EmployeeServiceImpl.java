package gyo.hazer.springboot.service;

import gyo.hazer.springboot.entity.Employee;
import gyo.hazer.springboot.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName: EmployeeServiceImpl
 * @Author: Hazer
 * @Description:
 * @Date: 2020/1/2 13:53
 * @Version: 1.0
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    public EmployeeMapper employeeMapper;
    @Override
    public Employee getEmpById(Integer id) {
        return employeeMapper.getEmpById(id);
    }
}
