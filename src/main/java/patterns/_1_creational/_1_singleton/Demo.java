package patterns._1_creational._1_singleton;

/**
 * @author LinnykOleh
 */
public class Demo{

	public static void main(String[]args){
		System.out.format("StaticSingletons %s \n", StaticSingleton.getInstance() == StaticSingleton.getInstance());
		System.out.format("LazySingletons %s \n", LazySingleton.getInstance() == LazySingleton.getInstance());
		System.out.format("LazySingletons %s \n", ThreadSafeSingleton.getInstance() == ThreadSafeSingleton.getInstance());
	}

}