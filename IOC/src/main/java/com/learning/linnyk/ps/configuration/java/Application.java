package com.learning.linnyk.ps.configuration.java;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.learning.linnyk.ps.configuration.java.service.CustomerService;

/**
 * @author LinnykOleh
 */
public class Application {

	public static void main(String[] args) {
		final ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		final CustomerService customerServiceSetterInjection = context.getBean("customerServiceSetterInjection", CustomerService.class);
		System.out.println(customerServiceSetterInjection.findAll());

		final CustomerService customerServiceConstructorInjection = context.getBean("customerServiceConstructorInjection", CustomerService.class);
		System.out.println(customerServiceConstructorInjection.findAll());

		final CustomerService customerServiceImpl = context.getBean("customerServiceImpl", CustomerService.class);
		System.out.println(customerServiceImpl.findAll());

	}
}
