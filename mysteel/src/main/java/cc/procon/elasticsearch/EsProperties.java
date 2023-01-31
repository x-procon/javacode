package cc.procon.elasticsearch;

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * es 配置参数
 *
 * @author procon
 * @since 2022-12-14
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "elasticsearch")
@ToString
public class EsProperties {
    private String clusterNodes;
    /**
     *  连接超时时间
     */
    private int connectTimeOut;
    /**
     * 连接超时时间
     */
    private int socketTimeOut;
    /**
     * 获取连接的超时时间
     */
    private int connectionRequestTimeOut;
    /**
     * 最大连接数
     */
    private int maxConnectNum;
    /**
     * 最大路由连接数
     */
    private int maxConnectPerRoute;

    /**
     * 分片数
     */
    private int numberOfShards;

    /**
     * 副本数
     */
    private int numberOfReplicas;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 使用的协议
     */
    private  String scheme;
}
