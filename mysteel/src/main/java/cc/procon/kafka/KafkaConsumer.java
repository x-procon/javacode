package cc.procon.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * kafka 消费者
 *
 * @author procon
 * @since 2022-09-22
 */
@Component
public class KafkaConsumer {

//    @KafkaListener(topics = "${kafka.topic}", groupId = "${kafka.consumer.group-id}", containerFactory = "batchFactory")
    public void consumerTest(List<ConsumerRecord<String, String>> records) throws InterruptedException {
        //接收打印分区 下标 消息体 处理后打印分区 下标 处理状态
        int partition = records.get(0).partition();
        long offset = records.get(0).offset();
        for (ConsumerRecord<String, String> consumerRecord : records) {
            String message = consumerRecord.value() == null ? "" : consumerRecord.value();
            if(message.trim().equals("hello world61")){
                System.exit(0);
            }
            Thread.sleep(100);
            System.out.printf("partition: %d,offset: %d,消费信息: %s %n",partition,offset,message);
        }
    }

    public static void main(String[] args) {
        System.out.println(Math.abs("htf_damp_dw_ogg_link_index".hashCode()) % 3);;
    }
}
