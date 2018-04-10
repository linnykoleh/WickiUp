package com.linnyk.ocp.nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.stream.Stream;

public class Files_copy {

	/**
	    public static Path copy(Path source, Path target, CopyOption... options)throws IOException

	    public static long copy(InputStream in, Path target, CopyOption... options) throws IOException

	 	public static long copy(Path source, OutputStream out) throws IOException

	 	private static long copy(InputStream source, OutputStream sink) throws IOException

	 */

	public static void main(String[] args) throws IOException {
		copyWithoutCopyAction();
	}

	private static void copyWithCopyAction() throws IOException {
		final Path copy = Files.copy(
				Paths.get("/home/olinnyk/IdeaProjects/WickiUp/OCP/src/main/java/com/linnyk/ocp/nio/copy/source.txt"),
				Paths.get("/home/olinnyk/IdeaProjects/WickiUp/OCP/src/main/java/com/linnyk/ocp/nio/copy/target.txt"),
				StandardCopyOption.REPLACE_EXISTING
		);

		Stream<String> linesSource = Files.lines(Paths.get("/home/olinnyk/IdeaProjects/WickiUp/OCP/src/main/java/com/linnyk/ocp/nio/copy/source.txt"));
		linesSource.forEach(System.out::println); // source

		Stream<String> linesDestination = Files.lines(Paths.get("/home/olinnyk/IdeaProjects/WickiUp/OCP/src/main/java/com/linnyk/ocp/nio/copy/target.txt"));
		linesDestination.forEach(System.out::println); // source
	}

	private static void copyWithoutCopyAction() throws IOException {
		final Path copy = Files.copy(
				Paths.get("/home/olinnyk/IdeaProjects/WickiUp/OCP/src/main/java/com/linnyk/ocp/nio/copy/source.txt"),
				Paths.get("/home/olinnyk/IdeaProjects/WickiUp/OCP/src/main/java/com/linnyk/ocp/nio/copy/targetNew.txt")
		);

		Stream<String> linesSource = Files.lines(Paths.get("/home/olinnyk/IdeaProjects/WickiUp/OCP/src/main/java/com/linnyk/ocp/nio/copy/source.txt"));
		linesSource.forEach(System.out::println); // source


		Stream<String> linesDestination = Files.lines(Paths.get("/home/olinnyk/IdeaProjects/WickiUp/OCP/src/main/java/com/linnyk/ocp/nio/copy/targetNew.txt"));
		linesDestination.forEach(System.out::println); // source
	}

}
