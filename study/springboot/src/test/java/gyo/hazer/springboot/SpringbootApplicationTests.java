package gyo.hazer.springboot;

import gyo.hazer.springboot.entity.Employee;
import gyo.hazer.springboot.mapper.EmployeeMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.Date;


@SpringBootTest
class SpringbootApplicationTests {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate<Object, Employee> redisTemplate;

    @Autowired
    private JavaMailSenderImpl javaMailSender;



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

    @Test
    void sendMail(){
        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

            mimeMessageHelper.setSubject("make love baby");
            mimeMessageHelper.setText("<h1 style='color:red'>今晚来我家！</h1>",true);
            mimeMessageHelper.setFrom("1187147080@qq.com","gyo");
            mimeMessageHelper.setSentDate(new Date());
            mimeMessageHelper.setTo(new String[]{"huangpuguang@foxmail.com","huangpuguang@outlook.com"});
            //mimeMessageHelper.addAttachment("saber",new File("F:\\AppData\\JetBrains\\jetbrains-agent.jar"));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
