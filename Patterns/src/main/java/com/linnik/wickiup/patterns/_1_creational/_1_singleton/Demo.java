package com.linnik.wickiup.patterns._1_creational._1_singleton;

/**
 * @author LinnykOleh
 */
public class Demo{

	public static void main(String[]args){
		final StaticSingleton staticInstance1 = StaticSingleton.getInstance();
		final StaticSingleton staticInstance2 = StaticSingleton.getInstance();

		System.out.format("StaticSingletons %s \n", (staticInstance1 == staticInstance2 && staticInstance1.hashCode() ==staticInstance2.hashCode()));

		final LazySingleton lazySingleton1 = LazySingleton.getInstance();
		final LazySingleton lazySingleton2 = LazySingleton.getInstance();

		System.out.format("LazySingletons %s \n", (lazySingleton1 == lazySingleton2 && lazySingleton1.hashCode() == lazySingleton2.hashCode()));

		final ThreadSafeSingleton threadSafeSingleton1 = ThreadSafeSingleton.getInstance();
		final ThreadSafeSingleton threadSafeSingleton2 = ThreadSafeSingleton.getInstance();

		System.out.format("LazySingletons %s \n", (threadSafeSingleton1 == threadSafeSingleton2 && threadSafeSingleton1.hashCode() == threadSafeSingleton2.hashCode()));

		final ThreadSafeSingleton threadSafeSingleton3 = ThreadSafeSingleton.getInstanceDoubleLocking();
		final ThreadSafeSingleton threadSafeSingleton4 = ThreadSafeSingleton.getInstanceDoubleLocking();

		System.out.format("LazySingletons double locking %s \n", (threadSafeSingleton3 == threadSafeSingleton4 && threadSafeSingleton3.hashCode() == threadSafeSingleton4.hashCode()));

	}

}