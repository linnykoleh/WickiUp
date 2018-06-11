package com.learning.linnyk.sp;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.learning.linnyk.sp.part1.Quoter;

/**
 * @author LinnykOleh
 */
public class Application {

	public static void main(String[] args) throws InterruptedException {
		final ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("sp/spring.xml");
		final Quoter bean = context.getBean(Quoter.class);
		System.out.println(bean);

		while (true) {
			Thread.sleep(1000);
			context.getBean(Quoter.class).sayQuote();
		}
	}
}
