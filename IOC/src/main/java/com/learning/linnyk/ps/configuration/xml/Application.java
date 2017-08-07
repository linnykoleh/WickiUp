package com.learning.linnyk.ps.configuration.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.learning.linnyk.ps.configuration.xml.service.CustomerService;

/**
 * @author LinnykOleh
 */
public class Application {

	public static void main(String[] args) {
		final ApplicationContext context = new ClassPathXmlApplicationContext("ps/configuration/xml/spring.xml");
		
		final CustomerService customerService = context.getBean("customerServiceImpl", CustomerService.class);
		System.out.println(customerService.findAll());
	}
}
