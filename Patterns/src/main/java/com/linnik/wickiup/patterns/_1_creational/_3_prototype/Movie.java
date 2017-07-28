package com.linnik.wickiup.patterns._1_creational._3_prototype;

/**
 * @author LinnykOleh
 */
public class Movie extends Item {

	private int runTime;

	public int getRunTime() {
		return runTime;
	}

	public void setRunTime(int runTime) {
		this.runTime = runTime;
	}

	public String toString() {
		return "{" +
				"runTime=" + runTime +
				super.toString() +
				" hashcode=" + hashCode()+
				'}';
	}
}
