package com.linnik.wickiup.patterns._1_creational._4_factory_method.sites;

import patterns._1_creational._4_factory_method.pages.CartPage;
import patterns._1_creational._4_factory_method.pages.ItemPage;
import patterns._1_creational._4_factory_method.pages.SearchPage;

/**
 * @author LinnykOleh
 */
public class Shop extends Website {

	@Override
	public void createWebsite() {
		pages.add(new CartPage());
		pages.add(new ItemPage());
		pages.add(new SearchPage());
	}
}
