package com.linnyk.ocp.nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.stream.Stream;

public class Files_move {

	/**
	 	public static Path move(Path source, Path target, CopyOption... options)
	 */

	public static void main(String[] args) throws IOException {
		final Path move = Files.move(
				Paths.get("/home/olinnyk/IdeaProjects/WickiUp/OCP/src/main/java/com/linnyk/ocp/nio/move/source.txt"),
				Paths.get("/home/olinnyk/IdeaProjects/WickiUp/OCP/src/main/java/com/linnyk/ocp/nio/move/target.txt"),
				StandardCopyOption.REPLACE_EXISTING
		);

		Stream<String> linesSource = Files.lines(Paths.get("/home/olinnyk/IdeaProjects/WickiUp/OCP/src/main/java/com/linnyk/ocp/nio/move/source.txt"));
		linesSource.forEach(System.out::println);

		/*
		    Исключение получается потомучто мы мувнули файл и его больше нет

			Exception in thread "main" java.nio.file.NoSuchFileException: /home/olinnyk/IdeaProjects/WickiUp/OCP/src/main/java/com/linnyk/ocp/nio/test_file_2/source.txt

		*/

		Stream<String> linesDestination = Files.lines(Paths.get("/home/olinnyk/IdeaProjects/WickiUp/OCP/src/main/java/com/linnyk/ocp/nio/move/target.txt"));
		linesDestination.forEach(System.out::println); // source
	}

}
