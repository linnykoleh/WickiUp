package com.linnik.wickiup.patterns._1_creational._1_singleton;

/**
 * @author LinnykOleh
 */
public class LazySingleton {

	private static LazySingleton instance;

	private LazySingleton(){

	}

	public static LazySingleton getInstance(){
		if(instance == null){
			instance = new LazySingleton();
		}
		return instance;
	}
}
