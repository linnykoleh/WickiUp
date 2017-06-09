package patterns._1_creational._1_singleton;

/**
 * @author LinnykOleh
 */
public class ThreadSafeSingleton {

	private static ThreadSafeSingleton instance;

	private ThreadSafeSingleton(){

	}

	public static synchronized ThreadSafeSingleton getInstance(){
		if(instance == null){
			instance = new ThreadSafeSingleton();
		}
		return instance;
	}

	public static ThreadSafeSingleton getInstanceDoubleLocking(){
		if(instance == null){
			synchronized(ThreadSafeSingleton.class){
				if(instance == null){
					instance = new ThreadSafeSingleton();
				}
			}
		}
		return instance;
	}


}
