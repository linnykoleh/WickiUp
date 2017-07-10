package patterns._3_behavioral._2_command.live;

/**
 * @author LinnykOleh
 */
public class Live {

	public static void main(String[] args) {
		final Task task = new Task(2, 4);
		final Thread thread1 = new Thread(task);  //encapsulates request
		thread1.start();	//invoker

		final Task task1 = new Task(3, 4);
		final Thread thread2 = new Thread(task1);
		thread2.start();
	}
}

class Task implements Runnable{

	private int num1;
	private int num2;

	Task(int num1, int num2) {
		this.num1 = num1;
		this.num2 = num2;
	}

	@Override
	public void run() {
		System.out.println(num1 * num2); // receiver
	}
}
