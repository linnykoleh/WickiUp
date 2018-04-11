package com.linnyk.ocp.nio;

import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Files_walk {

	/**
	 	public static Stream<Path> walk(Path start, int maxDepth, FileVisitOption... options) throws IOException

	    public static Stream<Path> walk(Path start, FileVisitOption... options) throws IOException

	 */

	public static void main(String[] args) throws IOException {
		final Stream<Path> walk = Files.walk(
				Paths.get("/home/olinnyk/IdeaProjects/WickiUp/OCP/src/main/java/com/linnyk/ocp/nio"),
				5,
				FileVisitOption.FOLLOW_LINKS);

		walk.forEach(System.out::println);

		/*
			/home/olinnyk/IdeaProjects/WickiUp/OCP/src/main/java/com/linnyk/ocp/nio
			/home/olinnyk/IdeaProjects/WickiUp/OCP/src/main/java/com/linnyk/ocp/nio/Files_walk.java
			/home/olinnyk/IdeaProjects/WickiUp/OCP/src/main/java/com/linnyk/ocp/nio/Files_list.java
			/home/olinnyk/IdeaProjects/WickiUp/OCP/src/main/java/com/linnyk/ocp/nio/test_file
			/home/olinnyk/IdeaProjects/WickiUp/OCP/src/main/java/com/linnyk/ocp/nio/test_file/test.txt
			/home/olinnyk/IdeaProjects/WickiUp/OCP/src/main/java/com/linnyk/ocp/nio/Files_find.java
			/home/olinnyk/IdeaProjects/WickiUp/OCP/src/main/java/com/linnyk/ocp/nio/Files_lines.java
		*/

		final Stream<Path> walk1 = Files.walk(
				Paths.get("/home/olinnyk/IdeaProjects/WickiUp/OCP/src/main/java/com/linnyk/ocp/nio"),
				FileVisitOption.FOLLOW_LINKS);

		walk1.forEach(System.out::println);

		/*
			/home/olinnyk/IdeaProjects/WickiUp/OCP/src/main/java/com/linnyk/ocp/nio
			/home/olinnyk/IdeaProjects/WickiUp/OCP/src/main/java/com/linnyk/ocp/nio/Files_walk.java
			/home/olinnyk/IdeaProjects/WickiUp/OCP/src/main/java/com/linnyk/ocp/nio/Files_list.java
			/home/olinnyk/IdeaProjects/WickiUp/OCP/src/main/java/com/linnyk/ocp/nio/test_file
			/home/olinnyk/IdeaProjects/WickiUp/OCP/src/main/java/com/linnyk/ocp/nio/test_file/test.txt
			/home/olinnyk/IdeaProjects/WickiUp/OCP/src/main/java/com/linnyk/ocp/nio/Files_find.java
			...
		*/

		final Stream<Path> walkIfFile = Files.walk(
				Paths.get("/home/olinnyk/IdeaProjects/WickiUp/OCP/src/main/java/com/linnyk/ocp/nio/test_file/test.txt"),
				5,
				FileVisitOption.FOLLOW_LINKS);

		walkIfFile.forEach(System.out::println);
//		/home/olinnyk/IdeaProjects/WickiUp/OCP/src/main/java/com/linnyk/ocp/nio/test_file/test.txt
	}

}