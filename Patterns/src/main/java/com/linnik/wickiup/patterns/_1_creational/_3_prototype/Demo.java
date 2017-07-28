package com.linnik.wickiup.patterns._1_creational._3_prototype;

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

		/*

		    {runTime=2, title=Patters, price=24.99, url=hello.movie hashcode=1173230247}
			{runTime=2, title=Gang of Four, price=24.99, url=hello.movie hashcode=856419764}
            {runTime=2, title=Basic movie, price=24.99, url=hello.movie hashcode=621009875}

		 */


	}
}
