package cc.procon;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author procon
 * @since 2022-09-20
 */
@EnableAsync
@EnableKafka
@MapperScan("cc.procon.mapper")
@SpringBootApplication(scanBasePackages = {"cc.procon"})
@EnableTransactionManagement
public class MySteelApplication {
    public static void main(String[] args) {
        SpringApplication.run(MySteelApplication.class, args);
    }
}
