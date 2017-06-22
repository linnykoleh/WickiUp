package patterns._1_creational._4_factory_method;

import patterns._1_creational._4_factory_method.sites.Website;

/**
 * @author LinnykOleh
 */
public class FactoryDemo {

	public static void main(String[] args) {
		final Website blog = WebsiteFactory.getWebsite(WebsiteType.BLOG);
		blog.createWebsite();
		System.out.println(blog.getPages());

		final Website shop = WebsiteFactory.getWebsite(WebsiteType.SHOP);
		shop.createWebsite();
		System.out.println(shop.getPages());
	}
}
