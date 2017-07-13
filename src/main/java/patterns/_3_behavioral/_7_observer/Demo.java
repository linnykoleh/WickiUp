package patterns._3_behavioral._7_observer;

/**
 * @author LinnykOleh
 */
public class Demo {

	public static void main(String[] args) {
		final Subject subject = new MessageStream();

		final PhoneClient phoneClient = new PhoneClient(subject);
		final TabletClient tabletClient = new TabletClient(subject);

		phoneClient.addMessage("Here is a new message");
		tabletClient.addMessage("Another new message!");
	}
}
