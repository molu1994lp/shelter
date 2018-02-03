package com.shelter;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.shelter.worker.WorkerDao;
import com.shelter.worker.WorkerDaoImpl;

@Configuration
@EnableWebMvc
public class ShelterAppConfig extends WebMvcConfigurerAdapter{
	
	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/Shelter");
		dataSource.setUsername("root");
		dataSource.setPassword("admin");
		
		return dataSource;
	}
	@Bean
	public WorkerDao getWorkerDao() {
		return new WorkerDaoImpl(getDataSource());
	}

}
