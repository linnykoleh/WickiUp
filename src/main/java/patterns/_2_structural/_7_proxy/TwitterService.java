package patterns._2_structural._7_proxy;

/**
 * @author LinnykOleh
 */
public interface TwitterService {

	String getTimeline(String screenName);

	void postToTimeline(String screenName, String message);

}
