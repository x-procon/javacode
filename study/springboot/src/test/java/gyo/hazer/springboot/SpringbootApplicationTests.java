package gyo.hazer.springboot;

import gyo.hazer.springboot.entity.Employee;
import gyo.hazer.springboot.mapper.EmployeeMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;


@SpringBootTest
class SpringbootApplicationTests {

    @Autowired
    EmployeeMapper employeeMapper;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    RedisTemplate<Object, Employee> redisTemplate;



    @Test
    void stringRedisTemp(){
        stringRedisTemplate.opsForList().leftPush("1","22");
        stringRedisTemplate.opsForList().leftPush("2","33");
        //stringRedisTemplate.opsForList().leftPushAll("3","22","2232","232dsa");

    }

    @Test
    void redisTemp(){
        Employee employee = employeeMapper.getEmpById(1);
        //redisTemplate.opsForValue().set("emp",employee);
        Object object = redisTemplate.opsForValue().get("emp");
        employee =(Employee) object;
//        for(Object o:employees){
//            employee = (Employee) o;
//            System.out.println(employee);
//        }


    }

    @Test
    void contextLoads()  {
       Employee employee = employeeMapper.getEmpById(1);
        System.out.println(employee);
    }

}
