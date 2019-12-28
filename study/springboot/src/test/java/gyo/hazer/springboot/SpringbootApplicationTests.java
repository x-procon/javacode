package gyo.hazer.springboot;

import gyo.hazer.springboot.entity.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.SQLException;

@SpringBootTest
class SpringbootApplicationTests {
    @Autowired
    Person person;

    @Autowired
    DataSource dataSource;

    @Test
    void contextLoads() throws SQLException {


        System.out.println(dataSource.getClass());
    }

}
