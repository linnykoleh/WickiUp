package patterns._1_creational._4_factory_method;

import patterns._1_creational._4_factory_method.sites.Blog;
import patterns._1_creational._4_factory_method.sites.ErrorWebSite;
import patterns._1_creational._4_factory_method.sites.Shop;
import patterns._1_creational._4_factory_method.sites.Website;

/**
 * @author LinnykOleh
 */
public class WebsiteFactory {

	public static Website getWebsite(WebsiteType siteType){
		switch (siteType){
			case BLOG: return new Blog();
			case SHOP: return new Shop();
			default: return new ErrorWebSite();
		}
	}
}
