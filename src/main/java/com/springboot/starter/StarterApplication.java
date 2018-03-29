package com.springboot.starter;

import org.hibernate.SessionFactory;
import org.hibernate.jpa.HibernateEntityManagerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@SpringBootApplication
@ComponentScan
//@EnableAutoConfiguration
@EnableJpaAuditing
public class StarterApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(StarterApplication.class, args);
	}
	@Bean  
	public SessionFactory sessionFactory(HibernateEntityManagerFactory hemf){  
	    return hemf.getSessionFactory();  
	}
	
	@Bean 
	public DriverManagerDataSource dataSource(){
		/*
		 * Implement by: Sopheaktra
		 * Implement Date: 2018-03-29 
		 * Description:
		 *   Get Data-Source from System-Environment-Variables
		 * 
		*/
		DriverManagerDataSource dataSource = new DriverManagerDataSource();		
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:"+System.getenv("jdbc")+"://"+System.getenv("POSTGRESQL_SERVICE_HOST")+":"+System.getenv("POSTGRESQL_SERVICE_PORT")+"/"+System.getenv("dbname"));
        dataSource.setUsername(System.getenv("dbuser"));
        dataSource.setPassword(System.getenv("dbpassword"));
        return dataSource;
	}
}
