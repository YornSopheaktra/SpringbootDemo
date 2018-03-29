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

		dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:"+System.getenv("jdbc")+"://"+System.getenv("POSTGRESQL_SERVICE_HOST")+":"+System.getenv("POSTGRESQL_SERVICE_PORT")+"/"+System.getenv("dbname"));
        dataSource.setUsername(System.getenv("dbuser"));
        dataSource.setPassword(System.getenv("dbpassword"));
        return dataSource;
	}
}
