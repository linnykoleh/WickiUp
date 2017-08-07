package com.learning.linnyk.ps.configuration.java;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.learning.linnyk.ps.configuration.java.repository.CustomRepository;
import com.learning.linnyk.ps.configuration.java.repository.HibernateCustomRepository;
import com.learning.linnyk.ps.configuration.java.service.CustomerService;
import com.learning.linnyk.ps.configuration.java.service.CustomerServiceImpl;

/**
 * @author LinnykOleh
 */
@Configuration
@ComponentScan("com.learning.linnyk.ps.configuration.java") /* autowiring */
public class AppConfig {

	@Bean(name = "customerServiceSetterInjection")
	public CustomerService customerServiceSetterInjection(){
		final CustomerServiceImpl customerService = new CustomerServiceImpl();
		customerService.setCustomRepository(customRepository());

		return customerService;
	}

	@Bean(name = "customerServiceConstructorInjection")
	public CustomerService customerServiceConstructorInjection(){
		return new CustomerServiceImpl(customRepository());
	}

	@Bean
	public CustomRepository customRepository(){
		return new HibernateCustomRepository();
	}
}
