package com.revature.test;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Profile("integration-test")
@ComponentScan("com.revature")
@Configuration
public class IntegrationConfig {

	//DataSource info
			public static final String DATASOURCE_URL = 
					"jdbc:postgresql://" + 
					System.getenv("DB_URL") + 
					":5432/" + 
					System.getenv("USER_DB_TEST_NAME") +     // Change it to UserTest database -- IYAD 
					"?";
			public static final String DATASOURCE_DRIVERNAME = "org.postgresql.Driver";
			public static final String DATASOURCE_USERNAME = System.getenv("DB_USERNAME");
			public static final String DATASOURCE_PASSWORD = System.getenv("DB_PASSWORD");
			public static final String DATASOURCE_SCHEMA = "public";
			
			@Bean
			public DataSource dataSource() {
				
				DriverManagerDataSource dataSource = new DriverManagerDataSource();
				dataSource.setUrl(DATASOURCE_URL);
				dataSource.setDriverClassName(DATASOURCE_DRIVERNAME);
				dataSource.setUsername(DATASOURCE_USERNAME);
				dataSource.setPassword(DATASOURCE_PASSWORD);
				dataSource.setSchema(DATASOURCE_SCHEMA);
				return dataSource;
				
			}
			
			@Bean
			public JdbcTemplate jdbcTemplate(DataSource dataSource) {
				JdbcTemplate template = new JdbcTemplate();
				template.setDataSource(dataSource);
				return Mockito.spy(template);
			}

			@Bean
			public Logger logger() {
				return Logger.getRootLogger();
			}
		
}
