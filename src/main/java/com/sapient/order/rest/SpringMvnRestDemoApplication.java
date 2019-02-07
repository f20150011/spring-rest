package com.sapient.order.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;;

@SpringBootApplication
@EnableTransactionManagement
public class SpringMvnRestDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMvnRestDemoApplication.class, args);
	}

	@Bean
	public DriverManagerDataSource dataSource() {
		return new DriverManagerDataSource("jdbc:mysql://{ip}/{schema}", "{user}", "{password}");
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean() {
		LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
		emf.setDataSource(dataSource());
		emf.setPackagesToScan(new String[] { "com.sapient.order.rest"});
		emf.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		return emf;
	}

	@Bean
	public PlatformTransactionManager transactionManager() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactoryBean().getObject());
		return transactionManager;
	}
}
