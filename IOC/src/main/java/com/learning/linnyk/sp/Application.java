package com.learning.linnyk.sp;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author LinnykOleh
 */
public class Application {

	public static void main(String[] args) throws InterruptedException {
		final ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("sp/spring.xml");
//		while (true) {
//			Thread.sleep(1000);
//			context.getBean(Quoter.class).sayQuote();
//		}
	}
}
