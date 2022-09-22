package cc.procon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author procon
 * @since 2022-09-20
 */
@EnableAsync
@SpringBootApplication(scanBasePackages = {"cc.procon"})
@EnableTransactionManagement
public class MySteelApplication {
    public static void main(String[] args) {
        SpringApplication.run(MySteelApplication.class, args);
    }
}
