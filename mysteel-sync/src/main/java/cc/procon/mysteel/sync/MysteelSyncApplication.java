package cc.procon.mysteel.sync;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author Administrator
 */
@EnableAsync
@MapperScan("cc.procon.mysteel.sync.mapper")
@EnableTransactionManagement
@SpringBootApplication(scanBasePackages = {"cc.procon.mysteel.sync"})
public class MysteelSyncApplication {

    public static void main(String[] args) {
        SpringApplication.run(MysteelSyncApplication.class, args);
    }

}
