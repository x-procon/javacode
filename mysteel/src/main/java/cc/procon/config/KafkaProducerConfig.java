package cc.procon.config;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * kafka生产者配置
 *
 * @author procon
 * @since 2022-09-22
 */

@Configuration
public class KafkaProducerConfig {

    @Value("${kafka.servers}")
    private  String servers;

    @Value("${kafka.consumer.batch-size}")
    private Integer batchSize;

    @Value("${kafka.producer.retries}")
    private Integer retries;

    @Bean
    public ProducerFactory producerOneFactory() {

        //生产者配置
        Map<String, Object> props = new HashMap<>();
        //连接地址
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, servers);
        //重试，0为不启用重试机制
        props.put(ProducerConfig.RETRIES_CONFIG, retries);
        //控制批处理大小，单位为字节
        props.put(ProducerConfig.BATCH_SIZE_CONFIG, batchSize);
        //生产者消息的键的序列化器
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        //生产者消息的值的序列化器
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        return new DefaultKafkaProducerFactory<String, String>(props);
    }

    @Bean
    @SuppressWarnings("unchecked")
    public KafkaTemplate<String, String> getKafkaTemplateOne() {
        return new KafkaTemplate<String, String>(producerOneFactory());
    }
}
