package patterns._3_behavioral._8_state;

/**
 * @author LinnykOleh
 */
public class FanMedState extends State {

	private Fan fan;

	public FanMedState(Fan fan) {
		this.fan = fan;
	}

	@Override
	public void handleRequest() {
		System.out.println("Turning fan on to high");
		fan.setState(fan.getFanHighState());
	}

	@Override
	public String toString() {
		return "Fan is on medium";
	}
}
