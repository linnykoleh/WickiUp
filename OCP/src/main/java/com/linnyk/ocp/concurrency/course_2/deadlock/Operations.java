package com.linnyk.ocp.concurrency.course_2.deadlock;

public class Operations {

	/**
		 tryLock - получаешь лок если он свободен во время вызова
	 */

	public static void main(String[] args) {

		final Account a = new Account(1000);
		final Account b = new Account(2000);

		new Thread(() -> transfer(a, b, 500)).start();

		transfer(b, a, 500);
	}

	private static void transfer(Account acc1, Account acc2, int amount) throws IllegalArgumentException {
		if(acc1.getBalance() < amount){
			throw new IllegalArgumentException();
		}

		if(acc1.getLock().tryLock()) {
			System.out.println("Locked acc1");
			try {
				if(acc2.getLock().tryLock()) {
					System.out.println("Locked acc2");
					try {
						acc1.withdraw(amount);
						acc2.deposit(amount);
						System.out.println("Operations executed");
					}finally {
						acc2.getLock().unlock();
						System.out.println("UnLocked acc2");
					}
				}
			}
			finally {
				acc1.getLock().unlock();
				System.out.println("UnLocked acc2");
			}
		}else{
			System.out.println("Error waiting lock");
		}
	}

}