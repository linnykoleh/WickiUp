package com.learning.linnyk.java_brains._2_scope_lifecycle;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.learning.linnyk.java_brains._1_di.Point;

/**
 * @author LinnykOleh
 */
public class DrawingApp {

	public static void main(String[] args) {

		final AbstractApplicationContext beanFactory = new ClassPathXmlApplicationContext("java_brains/_2_scope_lifecycle/spring.xml");
		beanFactory.registerShutdownHook(); // enable destroying beans (@PreDestroy, implements DisposableBean)

		final Triangle triangleSingleton1 = (Triangle) beanFactory.getBean("triangleSingleton");
		final Triangle triangleSingleton2 = (Triangle) beanFactory.getBean("triangleSingleton");
		System.out.println((triangleSingleton1 == triangleSingleton2));  //true

		final Triangle trianglePrototype1 = (Triangle) beanFactory.getBean("trianglePrototype");
		final Triangle trianglePrototype2 = (Triangle) beanFactory.getBean("trianglePrototype");
		System.out.println((trianglePrototype1 == trianglePrototype2));  //false

		final TriangleAware triangleAware = (TriangleAware) beanFactory.getBean("triangleAware");
		triangleAware.draw();

		final TriangleInheritance triangleInheritance1 = (TriangleInheritance) beanFactory.getBean("triangle1");
		triangleInheritance1.draw();

		final TriangleInheritance triangleInheritance2 = (TriangleInheritance) beanFactory.getBean("triangle2");
		triangleInheritance2.draw();

		final TriangleLifecycle triangleLifecycle = (TriangleLifecycle) beanFactory.getBean("triangleLifecycle");

		final Point pointWithProperty = (Point) beanFactory.getBean("pointWithProperty");
		System.out.println(pointWithProperty);

	}
}
