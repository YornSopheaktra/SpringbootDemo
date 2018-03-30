package com.springboot.starter;

import org.hibernate.SessionFactory;
import org.hibernate.jpa.HibernateEntityManagerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@ComponentScan
@EnableAutoConfiguration
@EnableJpaAuditing
@PropertySource("classpath:application.properties") 
public class StarterApplication extends SpringBootServletInitializer{
	public static void main(String[] args) {
		SpringApplication.run(StarterApplication.class, args);
	}
	@Bean  
	public SessionFactory sessionFactory(HibernateEntityManagerFactory hemf){  
	    return hemf.getSessionFactory();  
	}
	/*
	@Bean 
	public DataSource dataSource(){

		DataSource dataSource = new DataSource();
		
		System.out.println("-------------url: "+ environment.getRequiredProperty("spring.datasource.url"));
		System.out.println("-------------user: "+ environment.getRequiredProperty("spring.datasource.username"));
		System.out.println("-------------pwd: "+ environment.getRequiredProperty("spring.datasource.password"));
		System.out.println("-------------driver: "+ environment.getRequiredProperty("spring.datasource.driverClassName"));
		
	     dataSource.setUrl(environment.getRequiredProperty("spring.datasource.url"));
	     dataSource.setUsername(environment.getRequiredProperty("spring.datasource.username"));
	     dataSource.setPassword(environment.getRequiredProperty("spring.datasource.password"));
	     dataSource.setDriverClassName(environment.getRequiredProperty("spring.datasource.driverClassName"));
	     
	     
	     
		/*
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:"+System.getenv("jdbc")+"://"+System.getenv("POSTGRESQL_SERVICE_HOST")+":"+System.getenv("POSTGRESQL_SERVICE_PORT")+"/"+System.getenv("dbname"));
        dataSource.setUsername(System.getenv("dbuser"));
        dataSource.setPassword(System.getenv("dbpassword"));
        *
        return dataSource;
	}
	*/
}
