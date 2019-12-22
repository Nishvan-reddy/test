package com.example.helloworld.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

@Configuration
public class HibernateConfiguration {
	
	private String DRIVER_CLASS_NAME;
	
	private String PASSWORD;
	
	private String URL;
	
	private String USERNAME;
	
	private String DIALECT;
	
	private String SHOW_SQL;
	
	private String HBM2DDL_AUTO;
	
	private String PACKAGE_TO_SCAN;
	
	@Bean
	public DataSource dataSource(){
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		dataSource.setDriverClassName(DRIVER_CLASS_NAME);
		dataSource.setUrl(URL);
		dataSource.setUsername(USERNAME);
		dataSource.setPassword(PASSWORD);
		
		return dataSource;
	}
	
	@Bean
	public LocalSessionFactoryBean sessionFactory(){
		LocalSessionFactoryBean sessionFactory=new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setPackagesToScan(PACKAGE_TO_SCAN);
		Properties props=new Properties();
		props.put("hibernate.dialect", DIALECT);
		props.put("hibernate.show_sql", SHOW_SQL);
		props.put("hibernate.hbm2ddl.auto", HBM2DDL_AUTO);
		sessionFactory.setHibernateProperties(props);
		return sessionFactory;
	}
	
	

}
