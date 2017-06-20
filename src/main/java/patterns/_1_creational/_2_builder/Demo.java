package patterns._1_creational._2_builder;

/**
 * @author LinnykOleh
 */
public class Demo {

	public static void main(String[] args) {

		final LunchOrder lunchOrder = new LunchOrder.Builder()
				.bread("Wheat")
				.condiments("Lettude")
				.dressing("Mayo")
				.meat("Tukey")
				.build();

		System.out.println(lunchOrder.getBread());
		System.out.println(lunchOrder.getCondiments());
		System.out.println(lunchOrder.getDressing());
		System.out.println(lunchOrder.getMeat());

	}
}
