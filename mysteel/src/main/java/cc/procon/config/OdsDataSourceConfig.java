package cc.procon.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.google.common.collect.Lists;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;


@Configuration
public class OdsDataSourceConfig {

    @Value("${mybatis.ods.mapper-locations}")
    private String mapperLocations;

    @Value(value = "${spring.datasource.ods.url}")
    private String dbUrl;
    @Value(value = "${spring.datasource.ods.username}")
    private String username;
    @Value(value = "${spring.datasource.ods.password}")
    private String password;
    @Value(value = "${spring.datasource.ods.driver-class-name}")
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




    @Bean(name = "odsDataSource")
    @Primary
    public DruidDataSource odsDataSource() {
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
           e.printStackTrace();
        }

        datasource.setConnectionProperties(connectionProperties);
        return datasource;
    }


    @Bean(name = "odsSqlSessionFactory")
    @Primary
    public SqlSessionFactory odsSqlSessionFactory(@Qualifier("odsDataSource") DataSource dataSource)
            throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        // 读取mybatis小配置文件
        PathMatchingResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
        List<Resource> res = Lists.newArrayList();
        res.addAll(Arrays.asList(resourcePatternResolver.getResources(mapperLocations)));
        bean.setMapperLocations(res.toArray(new Resource[res.size()]));
        //分页插件

        Properties properties = new Properties();
        //数据库
        properties.setProperty("helperDialect", "oracle");
        //是否将参数offset作为PageNum使用
        properties.setProperty("offsetAsPageNum", "true");
        //是否进行count查询
        properties.setProperty("rowBoundsWithCount", "true");
        //是否分页合理化
        properties.setProperty("reasonable", "false");
        return bean.getObject();
    }

    @Bean(name = "odsTransactionManager")
    @Primary
    public DataSourceTransactionManager odsTransactionManager(@Qualifier("odsDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "odsSqlSessionTemplate")
    @Primary
    public SqlSessionTemplate odsSqlSessionTemplate(
            @Qualifier("odsSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }




}
