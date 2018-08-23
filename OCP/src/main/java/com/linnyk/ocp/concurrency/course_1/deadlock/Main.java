package com.linnyk.ocp.concurrency.course_1.deadlock;

public class Main {

	public static void main(String[] args) {
		final Wallet wallet = new Wallet();
		final Bank bank = new Bank();

		wallet.bank = bank;
		bank.wallet = wallet;

		final MyThreadA myThreadA = new MyThreadA(wallet);
		final MyThreadB myThreadB = new MyThreadB(bank);

		myThreadA.start();
		myThreadB.start();
	}
}

class MyThreadA extends Thread {

	Wallet wallet;

	public MyThreadA(Wallet wallet) {
		this.wallet = wallet;
	}

	@Override
	public void run() {
		System.out.println(wallet.getMoneyFromBank());
	}
}

class MyThreadB extends Thread {

	Bank bank;

	public MyThreadB(Bank bank) {
		this.bank = bank;
	}

	@Override
	public void run() {
		System.out.println(bank.getMoneyFromWallet());
	}
}

class Wallet {

	Bank bank;

	public synchronized int getMoneyFromWallet(){
		return 1;
	}

	public synchronized int getMoneyFromBank(){
		return bank.getMoneyFromBank();
	}
}

class Bank {

	Wallet wallet;

	public synchronized int getMoneyFromBank(){
		return 2;
	}

	public synchronized int getMoneyFromWallet(){
		return wallet.getMoneyFromWallet();
	}

}
