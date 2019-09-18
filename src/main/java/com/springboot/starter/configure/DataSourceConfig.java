package com.springboot.starter.configure;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import javax.sql.DataSource;
import java.util.Properties;


/*
 * Author: Sopheaktra Yorn
 * Date: 02-07-2019
 */
@Configuration
@PropertySource(value = "classpath:vault.properties")
public class DataSourceConfig {

    @Value("${${evn}.datasource.driverClassName}")
    private String DRIVER;

    @Value ("${${evn}.datasource.url}")
    private String URL;

    @Value ("${${evn}.datasource.username}")
    private String USER_NAME;

    @Value ("${${evn}.datasource.password}")
    private String PASSWORD;

    @Value ("${${evn}.datasource.schema}")
    private String SCHEMA;


    private Logger log= LoggerFactory.getLogger(HibernateConfig.class);

/*

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(DRIVER);
        dataSource.setUrl(URL);
        dataSource.setUsername(USER_NAME);
        dataSource.setPassword(PASSWORD);

        log.info("=====>>>> Obtained database credentials from Vault Properties");
        log.info("=====>>>> driver:" + dataSource.getCatalog());
        log.info("=====>>>> url:" + dataSource.getUrl());
        log.info("=====>>>> username:" + dataSource.getUsername());
        log.info("=====>>>> schema:" + dataSource.getSchema());
        return dataSource;
    }
*/



    @Bean
    public DriverManagerDataSource dataSource() {
        DriverManagerDataSource factoryBean = new DriverManagerDataSource();
        factoryBean.setDriverClassName(DRIVER);
        factoryBean.setUrl(URL);
        factoryBean.setUsername(USER_NAME);
        factoryBean.setPassword(PASSWORD);
        factoryBean.setSchema(SCHEMA);

        log.info("=====>>>> Obtained database credentials from Vault Properties");
        log.info("=====>>>> driver:" + factoryBean);
        log.info("=====>>>> url:" + factoryBean.getUrl());
        log.info("=====>>>> username:" + factoryBean.getUsername());
        log.info("=====>>>> schema:" + factoryBean.getSchema());
        return factoryBean;
    }

}
