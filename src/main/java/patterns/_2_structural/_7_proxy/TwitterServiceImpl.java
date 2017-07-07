package patterns._2_structural._7_proxy;

import java.util.List;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

/**
 * @author LinnykOleh
 */
public class TwitterServiceImpl implements TwitterService {

	private static final String TWITTER_CONSUMER_KEY = "JZnAC4flwOSQE5poNmEK9o3MP";
	private static final String TWITTER_SECRET_KEY = "pInuifnymhYBc6DlSwLAYtIFY0c9fGh3pCymUCVTwKqL6dkQ4b";
	private static final String TWITTER_ACCESS_TOKEN = "739125113128374272-AKBDM8iJrQ7Ybfya9nvE48u4OFMysiw";
	private static final String TWITTER_ACCESS_TOKEN_SECRET = "BtfYkipQ3rCEO7vxrGSGFuqXZmy8wsXKCljGAmS9TnHYn";

	@Override
	public String getTimeline(String screenName) {

		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true)
				.setOAuthConsumerKey(TWITTER_CONSUMER_KEY)
				.setOAuthConsumerSecret(TWITTER_SECRET_KEY)
				.setOAuthAccessToken(TWITTER_ACCESS_TOKEN)
				.setOAuthAccessTokenSecret(TWITTER_ACCESS_TOKEN_SECRET);
		TwitterFactory tf = new TwitterFactory(cb.build());
		Twitter twitter = tf.getInstance();
		StringBuilder builder = new StringBuilder();
		try {
			Query query = new Query(screenName);
			QueryResult result;
			do {
				result = twitter.search(query);
				List<Status> tweets = result.getTweets();
				for (Status tweet : tweets) {
					builder.append("@" + tweet.getUser().getScreenName() + " - " + tweet.getText());
					builder.append("\n");
				}
			} while ((query = result.nextQuery()) != null);

		} catch (TwitterException te) {
			te.printStackTrace();
			System.out.println("Failed to search tweets: " + te.getMessage());
		}
		return builder.toString();
	}

	@Override
	public void postToTimeline(String screenName, String message) {
		System.out.println(message);
	}
}
