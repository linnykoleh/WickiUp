package patterns._3_behavioral._8_state;

/**
 * @author LinnykOleh
 */
public abstract class State {

	public void handleRequest(){
		System.out.println("Shouldn't be able to get here");
	}
}
