package patterns._1_creational._3_prototype;

/**
 * @author LinnykOleh
 */
public class Demo {

	public static void main(String[] args) throws CloneNotSupportedException {

		final Registry registry = new Registry();

		final Movie movie = (Movie) registry.createItem("Movie");
		movie.setTitle("Patters");
		System.out.println(movie);

		final Movie movie1 = (Movie) registry.createItem("Movie");
		movie1.setTitle("Gang of Four");
		System.out.println(movie1);

		final Movie movie2 = (Movie) registry.createItem("Movie");
		System.out.println(movie2);


	}
}
