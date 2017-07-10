package patterns._3_behavioral._1_chain_of_resposibility;

/**
 * @author LinnykOleh
 */
public class Demo {

	public static void main(String[] args) {
		final Director bryan = new Director();
		final VP crystal = new VP();
		final CEO jeff = new CEO();

		bryan.setSuccessor(crystal);
		crystal.setSuccessor(jeff);

		bryan.handleRequest(new Request(RequestType.CONFERENCE, 500));

		bryan.handleRequest(new Request(RequestType.PURCHASE, 1000));

		bryan.handleRequest(new Request(RequestType.PURCHASE, 2000));

	}
}
