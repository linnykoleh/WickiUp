package patterns._2_structural._7_proxy;

/**
 * @author LinnykOleh
 */
public class TwitterServiceStub implements TwitterService{

	@Override
	public String getTimeline(String screenName) {
		return "My neato timeline";
	}

	@Override
	public void postToTimeline(String screenName, String message) {

	}
}
