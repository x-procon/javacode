package cc.procon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * kafka controller
 *
 * @author procon
 * @since 2022-09-22
 */

@RestController
@RequestMapping("/kafka")
public class KafkaController {

    @Value("${kafka.topic}")
    private String topic;

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    @GetMapping("/send")
     public void send(){
        for (int i = 0; i < 100; i++) {
            String data = " hello world" +i;
            kafkaTemplate.send(topic,data);
        }

     }
}
