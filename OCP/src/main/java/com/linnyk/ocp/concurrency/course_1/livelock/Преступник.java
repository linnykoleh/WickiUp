package com.linnyk.ocp.concurrency.course_1.livelock;

public class Преступник {

	private boolean заложникОтпущен = false;

	public void освободитьЗаложника(Полиция полиция) {
		while (!полиция.isДеньгиОтправленны()) {
			System.out.println("Преступник ждет, чтобы полиция отправила деньги");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
		}
		System.out.println("Преступник: освободил заложника");
		this.заложникОтпущен = true;
	}

	public boolean isЗаложникОтпущен() {
		return this.заложникОтпущен;
	}
}