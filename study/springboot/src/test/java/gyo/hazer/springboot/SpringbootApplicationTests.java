package gyo.hazer.springboot;

import gyo.hazer.springboot.entity.Employee;
import gyo.hazer.springboot.mapper.EmployeeMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootApplicationTests {

    @Autowired
    EmployeeMapper employeeMapper;

    @Test
    void contextLoads()  {
       Employee employee = employeeMapper.getEmpById(1);
        System.out.println(employee);
    }

}
