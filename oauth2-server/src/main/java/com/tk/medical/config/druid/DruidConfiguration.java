package com.tk.medical.config.druid;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.WebStatFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * druid连接配置
 */
@Slf4j
@Configuration
public class DruidConfiguration {
    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    @Value("${spring.datasource.driver-class-name}")
    private String driverClassName;

    @Value("${spring.druid.initialSize}")
    private int initialSize;

    @Value("${spring.druid.minIdle}")
    private int minIdle;

    @Value("${spring.druid.maxActive}")
    private int maxActive;

    @Value("${spring.druid.maxWait}")
    private int maxWait;

    @Value("${spring.druid.timeBetweenEvictionRunsMillis}")
    private int timeBetweenEvictionRunsMillis;

    @Value("${spring.druid.minEvictableIdleTimeMillis}")
    private int minEvictableIdleTimeMillis;

    @Value("${spring.druid.validationQuery}")
    private String validationQuery;

    @Value("${spring.druid.testWhileIdle}")
    private boolean testWhileIdle;

    @Value("${spring.druid.testOnBorrow}")
    private boolean testOnBorrow;

    @Value("${spring.druid.testOnReturn}")
    private boolean testOnReturn;

    @Value("${spring.druid.poolPreparedStatements}")
    private boolean poolPreparedStatements;

    @Value("${spring.druid.maxPoolPreparedStatementPerConnectionSize}")
    private int maxPoolPreparedStatementPerConnectionSize;

    @Value("${spring.druid.filters}")
    private String filters;

    @Value("{spring.druid.connectionProperties}")
    private String connectionProperties;


    @Bean
    @Primary
    public DataSource dataSource() {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUrl(url);
        druidDataSource.setUsername(username);
        //这里可以做加密处理
        druidDataSource.setPassword(password);
        druidDataSource.setDriverClassName(driverClassName);
        //configuration
        druidDataSource.setInitialSize(initialSize);
        druidDataSource.setMinIdle(minIdle);
        druidDataSource.setMaxActive(maxActive);
        druidDataSource.setMaxWait(maxWait);
        druidDataSource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
        druidDataSource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
        druidDataSource.setValidationQuery(validationQuery);
        druidDataSource.setTestWhileIdle(testWhileIdle);
        druidDataSource.setTestOnBorrow(testOnBorrow);
        druidDataSource.setTestOnReturn(testOnReturn);
        druidDataSource.setPoolPreparedStatements(poolPreparedStatements);
        druidDataSource.setMaxPoolPreparedStatementPerConnectionSize(maxPoolPreparedStatementPerConnectionSize);
        try {
            druidDataSource.setFilters(filters);
        } catch (SQLException e) {
            log.info("连接异常" + e.getMessage());
        }
        druidDataSource.setConnectionProperties(connectionProperties);
        return druidDataSource;
    }


    @Bean
    public FilterRegistrationBean statFilter(){
        WebStatFilter webStatFilter = new WebStatFilter();
        //创建过滤器
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(webStatFilter);
        //设置过滤器过滤路径
        filterRegistrationBean.addUrlPatterns("/*");
        //忽略过滤的形式
        filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        return filterRegistrationBean;
    }


}
