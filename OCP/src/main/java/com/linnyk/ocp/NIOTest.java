package com.linnyk.ocp;

import java.nio.file.Path;
import java.nio.file.Paths;

public class NIOTest {

	public static void main(String[] args) {
		resolveIfFile();
	}

	private static void resolve() {
		Path path = Paths.get("/home/files/nio/");
		Path resolved = path.resolve(Paths.get("text1.txt")); // or Path resolved = path.resolve("text1.txt");

		System.out.println(path); // /home/files/nio
		System.out.println(resolved); // /home/files/nio/text1.txt
	}

	private static void resolveIfFile() {
		Path path = Paths.get("/home/files/nio/text.txt");
		Path resolved = path.resolve(Paths.get("text1.txt")); // or Path resolved = path.resolve("text1.txt");

		System.out.println(path); // /home/files/nio/text.txt
		System.out.println(resolved); // /home/files/nio/text.txt/text1.txt
	}

	private static void resolveAbsolute() {
		Path path = Paths.get("/home/files/nio/");
		Path resolved = path.resolve(Paths.get("/text1.txt")); // or Path resolved = path.resolve("text1.txt")

		/* Если путь абсолютный, но он же и возвращается*/

		System.out.println(path); // /home//files/nio
		System.out.println(resolved); // /text1.txt
	}

	private static void relativize() {
		Path path = Paths.get("nio/text.txt");
		Path relativized = path.relativize(Paths.get("text1.txt"));

		System.out.println(path); // nio/text.txt
		System.out.println(relativized); // ../../text1.txt
	}

	private static void relativizeAbsolute() {
		Path path = Paths.get("nio/text.txt");
		Path relativized = path.relativize(Paths.get("/text1.txt"));

		/*
		Если один из путей абсолютный путь, тогда исключение

		Exception in thread "main" java.lang.IllegalArgumentException: 'other' is different type of Path
			at sun.nio.fs.UnixPath.relativize(UnixPath.java:416)
			at sun.nio.fs.UnixPath.relativize(UnixPath.java:43)
			at com.linnyk.ocp.NIOTest.relativizeAbsolute(NIOTest.java:40)
			at com.linnyk.ocp.NIOTest.main(NIOTest.java:9)
		*/
	}

	private static void resolveSiblings() {
		Path path = Paths.get("/home/files/nio/test.txt");
		Path resolveSibling = path.resolveSibling(Paths.get("text1.txt")); // or Path resolveSibling = path.resolveSibling("text1.txt");

		System.out.println(path); // /home/files/nio/test.txt
		System.out.println(resolveSibling); // /home/files/nio/text1.txt
	}

	private static void resolveSiblingsAbsolute() {
		Path path = Paths.get("/home/files/nio/test.txt");
		Path resolveSibling = path.resolveSibling(Paths.get("/text1.txt")); // or Path resolveSibling = path.resolveSibling("text1.txt");

		/* Если путь абсолютный, но он же и возвращается*/

		System.out.println(path); // /home/files/nio/test.txt
		System.out.println(resolveSibling); // /text1.txt
	}
}
