package com.linnyk.ocp.nio;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Files_lines {

	/**
	    - public static Stream<String> lines(Path path) throws IOException
	    - public static Stream<String> lines(Path path, Charset cs) throws IOException

	 */

	public static void main(String[] args) throws IOException {
		final Stream<String> lines = Files.lines(Paths.get("/home/olinnyk/IdeaProjects/WickiUp/OCP/src/main/java/com/linnyk/ocp/nio/test_file/test.txt"));
		final Stream<String> linesWithCharSet = Files.lines(Paths.get("/home/olinnyk/IdeaProjects/WickiUp/OCP/src/main/java/com/linnyk/ocp/nio/test_file/test.txt"),
				Charset.defaultCharset());

		lines.forEach(System.out::println);
		linesWithCharSet.forEach(System.out::println);

		// Выведет все содержимое файла
		//
        // Hello
		// Test
		// Test#2


		final Stream<String> linesIfDirectry = Files.lines(Paths.get("/home/olinnyk/IdeaProjects/WickiUp/"));
		linesIfDirectry.forEach(System.out::println);

		/*
		 Если переданный путь это папка то будет исключение

		  Exception in thread "main" java.io.UncheckedIOException: java.io.IOException: Is a directory
				at java.io.BufferedReader$1.hasNext(BufferedReader.java:574)
				at java.util.Iterator.forEachRemaining(Iterator.java:115)
				at java.util.Spliterators$IteratorSpliterator.forEachRemaining(Spliterators.java:1801)
				at java.util.stream.ReferencePipeline$Head.forEach(ReferencePipeline.java:580)
				at com.linnyk.ocp.nio.Files_lines.main(Files_lines.java:30)
		*/
	}
}