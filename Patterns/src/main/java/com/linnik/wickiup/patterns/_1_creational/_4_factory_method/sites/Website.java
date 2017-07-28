package com.linnik.wickiup.patterns._1_creational._4_factory_method.sites;

import java.util.ArrayList;
import java.util.List;

import patterns._1_creational._4_factory_method.pages.Page;

/**
 * @author LinnykOleh
 */
public abstract class Website {

	protected List<Page> pages = new ArrayList<>();

	public Website() {
		this.createWebsite();
	}

	public List<Page> getPages() {
		return pages;
	}

	public abstract void createWebsite();
}
