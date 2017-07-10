package patterns._3_behavioral._3_chain_of_resposibility;

/**
 * @author LinnykOleh
 */
public abstract class Handler {

	protected Handler successor;

	public void setSuccessor(Handler successor) {
		this.successor = successor;
	}

	public abstract void handleRequest(Request request);
}
