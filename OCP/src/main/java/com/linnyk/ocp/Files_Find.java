package com.linnyk.ocp;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Files_Find {


	/**

	 Конструкор
		 - public static Stream<Path> find(Path start, int maxDepth, BiPredicate<Path, BasicFileAttributes> matcher, FileVisitOption... options)
	 Возвращает
	     -Stream<Path>
	 Throws
	     - IOException

	 */

	public static void main(String[] args) throws IOException {
		final Stream<Path> result = Files.find(Paths.get("/home/olinnyk/IdeaProjects/WickiUp/OCP/src/main/java/com/linnyk/ocp/find/"), 5,
				(path, basicFileAttributes) -> {
					{
						System.out.println(path);
						return path.endsWith("txt");
					}
				});
		result.forEach(System.out::println);
	}
}
