package com.qf.sxd.dao;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;


@Configuration
// @PropertySource("classpath:application.properties")
@EnableConfigurationProperties(JdbcProperties.class)
public class JdbcConfig {
   /* @Value("${jdbc.driverClassName}")
    String driverClassName;

    @Value("${jdbc.url}")
    String url;

    @Value("${jdbc.username}")
    String username;

    @Value("${jdbc.password}")
    String password;*/
    @Autowired
    private JdbcProperties prop;

    public JdbcConfig(JdbcProperties prop){
       this.prop=prop;
    }
    @Bean
    public DataSource dataSource(JdbcProperties prop){
        DruidDataSource dataSource=new DruidDataSource();
        dataSource.setUrl(prop.getUrl());
        dataSource.setDriverClassName(prop.getDriverClassName());
        dataSource.setUsername(prop.getUsername());
        dataSource.setPassword(prop.getPassword());
        return dataSource;
    }
}
