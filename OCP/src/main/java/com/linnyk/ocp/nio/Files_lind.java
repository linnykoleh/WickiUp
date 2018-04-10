package com.linnyk.ocp.nio;

import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Files_lind {


	/**

	 public static Stream<Path> find(Path start, int maxDepth, BiPredicate<Path, BasicFileAttributes> matcher, FileVisitOption... options) throws IOException

	 */

	public static void main(String[] args) throws IOException {
		final Stream<Path> result = Files.find(Paths.get("/home/olinnyk/IdeaProjects/WickiUp/OCP/src/main/java/com/linnyk/ocp/nio/test_file/"),
				5,
				(path, basicFileAttributes) -> path.endsWith("test.txt"), FileVisitOption.FOLLOW_LINKS);

		result.forEach(System.out::println); // /home/olinnyk/IdeaProjects/WickiUp/OCP/src/main/java/com/linnyk/ocp/nio/test_file/test.txt
	}
}
