package com.linnyk.ocp.concurrency.course_1.livelock;

public class Полиция {

	private boolean деньгиОтправленны = false;

	public void датьВзятку(Преступник преступник) {
		while (!преступник.isЗаложникОтпущен()) {
			System.out.println("Полиция ждет, чтобы преступник освободил заложника");

			try {
				Thread.sleep(1000);
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
		}
		System.out.println("Полиция: отправила деньги");
		this.деньгиОтправленны = true;
	}

	public boolean isДеньгиОтправленны() {
		return this.деньгиОтправленны;
	}

}