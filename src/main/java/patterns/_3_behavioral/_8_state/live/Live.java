package patterns._3_behavioral._8_state.live;

/**
 * @author LinnykOleh
 */
public class Live {

	public static void main(String[] args) {
		final Fan fan = new Fan();

		fan.pullChain();

		System.out.println(fan);

		fan.pullChain();

		System.out.println(fan);
	}
}

class Fan {

	private final static int OFF = 0;
	private final static int LOW = 1;
	private final static int MED = 2;

	private int state = OFF;

	public void pullChain(){
		if(state == OFF){
			System.out.println("Turning fan on to low." );
			state = LOW;
		}else if(state == LOW){
			System.out.println("Turning fan off.");
			state = OFF;
		}else if(state == MED){
			System.out.println("Turning fan off.");
			state = OFF;
		}
	}

	@Override
	public String toString() {
		if(state == OFF){
			return "Fan is off";
		}else if(state == LOW){
			return "Fan is on low";
		}else if(state == MED){
			return "Fan is on medium";
		}
		return "";
	}
}
