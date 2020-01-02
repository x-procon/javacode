package gyo.hazer.springboot.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import gyo.hazer.springboot.entity.Employee;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.cache.CacheManagerCustomizers;
import org.springframework.boot.autoconfigure.cache.CacheProperties;
import org.springframework.boot.autoconfigure.cache.RedisCacheManagerBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ResourceLoader;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.RedisSerializer;

import java.net.UnknownHostException;
import java.util.LinkedHashSet;
import java.util.List;

/**
 * @ProjectName: javacode
 * @Package: gyo.hazer.springboot.config
 * @ClassName: MyRedisConfig
 * @Author: Hazer
 * @Description:
 * @Date: 2020/1/2 21:44
 * @Version: 1.0
 */
@Configuration
public class MyRedisConfig {
    @Bean
    public RedisTemplate<Object, Employee> redisJsonTemplate(RedisConnectionFactory redisConnectionFactory)
            throws UnknownHostException {
        RedisTemplate<Object, Employee> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory);
        RedisSerializer redisSerializer = new Jackson2JsonRedisSerializer(Employee.class);
        template.setDefaultSerializer(redisSerializer);
        return template;
    }
    @Bean
    public RedisCacheManager cacheManager(RedisConnectionFactory connectionFactory) {

        Jackson2JsonRedisSerializer<Object> redisSerializer = new Jackson2JsonRedisSerializer<>(Object.class);

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);

        redisSerializer.setObjectMapper(objectMapper);

        RedisCacheConfiguration cacheConfiguration = RedisCacheConfiguration.defaultCacheConfig()
                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(redisSerializer));

        RedisCacheManager redisCacheManager = RedisCacheManager.builder(connectionFactory).cacheDefaults(cacheConfiguration).build();

        return redisCacheManager;
    }
}
