package com.linnik.wickiup.patterns._1_creational._4_factory_method;

import com.linnik.wickiup.patterns._1_creational._4_factory_method.sites.Blog;
import com.linnik.wickiup.patterns._1_creational._4_factory_method.sites.ErrorWebSite;
import com.linnik.wickiup.patterns._1_creational._4_factory_method.sites.Shop;
import com.linnik.wickiup.patterns._1_creational._4_factory_method.sites.Website;

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
