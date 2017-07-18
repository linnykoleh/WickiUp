package patterns._1_creational._1_singleton;

/**
 * @author LinnykOleh
 */
public class StaticSingleton {

	private static StaticSingleton instance = new StaticSingleton();

	private StaticSingleton(){

	}

	public static StaticSingleton getInstance(){
		return instance;
	}
}

