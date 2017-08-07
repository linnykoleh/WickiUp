package com.learning.linnyk.annotation_event;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author LinnykOleh
 */
public class DrawingApp {

	public static void main(String[] args) {

		final ApplicationContext beanFactory = new ClassPathXmlApplicationContext("annotation_event/spring.xml");

		final Shape circle = (Shape)beanFactory.getBean("circle");
		circle.draw();

	}
}
