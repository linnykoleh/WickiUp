package patterns._3_behavioral._8_state;

/**
 * @author LinnykOleh
 */
public class FanLowState extends State{

	private Fan fan;

	public FanLowState(Fan fan) {
		this.fan = fan;
	}

	@Override
	public void handleRequest() {
		System.out.println("Turning fan on to medium");
		fan.setState(fan.getFanMedState());
	}

	@Override
	public String toString() {
		return "Fan is low";
	}
}
