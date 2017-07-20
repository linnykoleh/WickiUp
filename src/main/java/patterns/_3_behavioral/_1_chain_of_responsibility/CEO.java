package patterns._3_behavioral._1_chain_of_responsibility;

/**
 * @author LinnykOleh
 */
public class CEO extends Handler{

	@Override
	public void handleRequest(Request request) {
		System.out.println("CEOs can approve anything they want");
	}
}
