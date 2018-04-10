package com.linnyk.ocp.nio;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Files_readAllLines {

	/**
	 	public static List<String> readAllLines(Path path) throws IOException

	 	public static List<String> readAllLines(Path path, Charset cs) throws IOException

	 */

	public static void main(String[] args) throws IOException {
		final List<String> strings =
				Files.readAllLines(Paths.get("/home/olinnyk/IdeaProjects/WickiUp/OCP/src/main/java/com/linnyk/ocp/nio/test_file/test.txt"));

		strings.forEach(System.out::println);
		// Hello
		// Test
		// Test#2

		final List<String> strings1 =
				Files.readAllLines(
						Paths.get("/home/olinnyk/IdeaProjects/WickiUp/OCP/src/main/java/com/linnyk/ocp/nio/test_file/test.txt"),
						Charset.defaultCharset()
				);

		strings1.forEach(System.out::println);
		// Hello
		// Test
		// Test#2
	}

}