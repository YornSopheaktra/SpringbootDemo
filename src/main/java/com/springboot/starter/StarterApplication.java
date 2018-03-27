package com.springboot.starter;

//import org.apache.tomcat.jdbc.pool.DataSource;
import org.hibernate.SessionFactory;
import org.hibernate.jpa.HibernateEntityManagerFactory;
import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.springboot.starter.util.Debugger;

@SpringBootApplication
@ComponentScan
//@EnableAutoConfiguration
@EnableJpaAuditing
public class StarterApplication {

	public static void main(String[] args) {
		SpringApplication.run(StarterApplication.class, args);
	}
	@Bean  
	public SessionFactory sessionFactory(HibernateEntityManagerFactory hemf){  
	    return hemf.getSessionFactory();  
	}
	
	@Bean 
	public DriverManagerDataSource dataSource(){
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
       /* dataSource.setDriverClassName(environment.getRequiredProperty("jdbc.driverClassName"));
        dataSource.setUrl(environment.getRequiredProperty("jdbc.url"));
        dataSource.setUsername(environment.getRequiredProperty("jdbc.username"));
        dataSource.setPassword(environment.getRequiredProperty("jdbc.password"));
        Debugger.debugObject("Datasouce: ", dataSource);
        */
		
		
		dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:"+System.getenv("jdbc")+"://"+System.getenv("POSTGRESQL_SERVICE_HOST")+":"+System.getenv("POSTGRESQL_SERVICE_PORT")+"/"+System.getenv("dbname"));
        dataSource.setUsername(System.getenv("dbuser"));
        dataSource.setPassword(System.getenv("dbpassword"));
        System.out.println("-----------------HOST : "+System.getenv("POSTGRESQL_SERVICE_HOST"));
        System.out.println("-----------------PORT : "+System.getenv("POSTGRESQL_SERVICE_PORT"));
        System.out.println("-----------------DBName : "+System.getenv("dbname"));
        System.out.println("-----------------USER : "+System.getenv("dbuser"));
        System.out.println("-----------------PWD : "+System.getenv("dbpassword"));
        Debugger.debugObject("===========Datasouce: ", dataSource);
        return dataSource;
        //{"url":"jdbc:mysql://localhost:3306/labomanagement","username":"root","password":"123","connectionProperties":null,"logger":{"name":"org.springframework.jdbc.datasource.DriverManagerDataSource"}}

	}
}
