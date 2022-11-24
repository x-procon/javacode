package cc.procon.config;

import com.alibaba.druid.pool.DruidDataSource;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author procon
 * @since 2022-11-24
 */
@Slf4j
@Configuration
public class DwDataSourceConfig {
    @Value("${mybatis.dw.mapper-locations}")
    private String mapperLocations;

    @Value(value = "${spring.datasource.dw.url}")
    private String dbUrl;
    @Value(value = "${spring.datasource.dw.username}")
    private String username;
    @Value(value = "${spring.datasource.dw.password}")
    private String password;
    @Value(value = "${spring.datasource.dw.driver-class-name}")
    private String driverClassName;
    @Value("${spring.datasource.type}")
    private String type;
    @Value("${spring.datasource.initialSize}")
    private int initialSize;
    @Value("${spring.datasource.minIdle}")
    private int minIdle;
    @Value("${spring.datasource.maxActive}")
    private int maxActive;
    @Value("${spring.datasource.maxWait}")
    private int maxWait;
    @Value("${spring.datasource.timeBetweenEvictionRunsMillis}")
    private int timeBetweenEvictionRunsMillis;
    @Value("${spring.datasource.minEvictableIdleTimeMillis}")
    private int minEvictableIdleTimeMillis;
    @Value("${spring.datasource.validationQuery}")
    private String validationQuery;
    @Value("${spring.datasource.testWhileIdle}")
    private boolean testWhileIdle;
    @Value("${spring.datasource.testOnBorrow}")
    private boolean testOnBorrow;
    @Value("${spring.datasource.testOnReturn}")
    private boolean testOnReturn;
    @Value("${spring.datasource.poolPreparedStatements}")
    private boolean poolPreparedStatements;
    @Value("${spring.datasource.maxPoolPreparedStatementPerConnectionSize}")
    private int maxPoolPreparedStatementPerConnectionSize;
    @Value("${spring.datasource.filters}")
    private String filters;
    @Value("${spring.datasource.connectionProperties}")
    private String connectionProperties;




    @Bean(name = "dwDataSource")
    @Primary
    public DruidDataSource dwDataSource() {
        DruidDataSource datasource = new DruidDataSource();
        datasource.setUrl(this.dbUrl);
        datasource.setUsername(username);
        datasource.setPassword(password);
        datasource.setDriverClassName(driverClassName);
        datasource.setInitialSize(initialSize);
        datasource.setMinIdle(minIdle);
        datasource.setMaxActive(maxActive);
        datasource.setMaxWait(maxWait);
        datasource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
        datasource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
        datasource.setValidationQuery(validationQuery);
        datasource.setTestWhileIdle(testWhileIdle);
        datasource.setTestOnBorrow(testOnBorrow);
        datasource.setTestOnReturn(testOnReturn);
        datasource.setPoolPreparedStatements(poolPreparedStatements);

        try {
            datasource.setFilters(filters);
        } catch (SQLException e) {
            log.error("异常", e);
        }

        datasource.setConnectionProperties(connectionProperties);
        return datasource;
    }



    @Bean(name = "dwTransactionManager")
    @Primary
    public DataSourceTransactionManager dwTransactionManager(@Qualifier("dwDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "dwSqlSessionTemplate")
    @Primary
    public SqlSessionTemplate dwSqlSessionTemplate(
            @Qualifier("dwSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    @Bean(name = "dwSessionConfiguration")
    @ConfigurationProperties(prefix = "mybatis.dw.configuration")
    public org.apache.ibatis.session.Configuration dwSessionConfiguration(){
        return new org.apache.ibatis.session.Configuration();
    }

    @Bean(name = "dwSqlSessionFactory")
    @Primary
    public SqlSessionFactory sqlSessionFactory(@Qualifier("dataSource") DataSource dataSource, @Qualifier("dwSessionConfiguration") org.apache.ibatis.session.Configuration configuration)
            throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        // 读取mybatis小配置文件
        PathMatchingResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
        List<Resource> res = new ArrayList<>(Arrays.asList(resourcePatternResolver.getResources(mapperLocations)));
        bean.setMapperLocations(res.toArray(new Resource[res.size()]));
        bean.setConfiguration(configuration);
        return bean.getObject();
    }
}
