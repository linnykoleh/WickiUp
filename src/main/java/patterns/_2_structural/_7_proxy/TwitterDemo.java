package patterns._2_structural._7_proxy;

/**
 * @author LinnykOleh
 */
public class TwitterDemo {

	public static void main(String[] args) {
		TwitterService twitterService = (TwitterService) SecurityProxy.newInstance(new TwitterServiceStub());

		System.out.println(twitterService.getTimeline("Test"));
	}
}
