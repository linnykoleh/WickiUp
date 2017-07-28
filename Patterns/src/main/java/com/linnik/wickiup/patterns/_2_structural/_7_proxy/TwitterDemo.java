package com.linnik.wickiup.patterns._2_structural._7_proxy;

/**
 * @author LinnykOleh
 */
public class TwitterDemo {

	public static void main(String[] args) {
		final TwitterService twitterService = (TwitterService) SecurityProxy.newInstance(new TwitterServiceStub());
		System.out.println(twitterService.getTimeline("Test"));

		final TwitterService twitterServiceReal = (TwitterService) SecurityProxy.newInstance(new TwitterServiceImpl());
		System.out.println(twitterServiceReal.getTimeline("Java"));
		twitterServiceReal.postToTimeline("Java", "Post message to twitter");
	}
}
