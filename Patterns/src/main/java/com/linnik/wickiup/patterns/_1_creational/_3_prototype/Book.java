package com.linnik.wickiup.patterns._1_creational._3_prototype;

/**
 * @author LinnykOleh
 */
public class Book extends Item {

	private int numberOfPages;

	public int getNumberOfPages() {
		return numberOfPages;
	}

	public void setNumberOfPages(int numberOfPages) {
		this.numberOfPages = numberOfPages;
	}

	@Override
	public String toString() {
		return "{" +
				"numberOfPages=" + numberOfPages +
				super.toString() +
				" hashcode=" + hashCode()+
				'}';
	}
}
