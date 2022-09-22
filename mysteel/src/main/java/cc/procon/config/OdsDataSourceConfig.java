package cc.procon.config;

import com.alibaba.druid.pool.DruidDataSource;
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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
public class OdsDataSourceConfig {

    @Value("${mybatis.mapper-locations}")
    private String mapperLocations;

    /**
     * 这里设置oracle为主数据源，给mybaits注入时优先使用这个数据源
     * @return
     */
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean(name = "odsDataSource")
    public DruidDataSource db1DataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        return dataSource;
    }

    @Bean(name = "odsConfiguration")
    @ConfigurationProperties(prefix = "mybatis.configuration")
    public org.apache.ibatis.session.Configuration configuration(){
        return new org.apache.ibatis.session.Configuration();
    }

    @Bean(name = "odsSqlSessionFactory")
    @Primary
    public SqlSessionFactory odsSqlSessionFactory(@Qualifier("odsDataSource") DataSource dataSource, @Qualifier("odsConfiguration") org.apache.ibatis.session.Configuration configuration)
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
