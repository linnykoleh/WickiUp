package com.linnyk.ocp.nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Files_list {

	/**
	    public static Stream<Path> list(Path dir) throws IOException
	 */

	public static void main(String[] args) throws IOException {
		final Stream<Path> list = Files.list(Paths.get("/home/olinnyk/IdeaProjects/WickiUp/"));
//		list.forEach(System.out::println);

		/*
		    /home/olinnyk/IdeaProjects/WickiUp/AWS
			/home/olinnyk/IdeaProjects/WickiUp/C:\logigng.log
			/home/olinnyk/IdeaProjects/WickiUp/OCP
			/home/olinnyk/IdeaProjects/WickiUp/pom.xml
			/home/olinnyk/IdeaProjects/WickiUp/.git
			....
		*/

		final Stream<Path> listIfFile = Files.list(Paths.get("/home/olinnyk/IdeaProjects/WickiUp/OCP/src/main/java/com/linnyk/ocp/nio/test_file/test.txt"));
		listIfFile.forEach(System.out::println);

		/*
		 Если переданный путь это файл тогда будет исключение

		 Exception in thread "main" java.nio.file.NotDirectoryException: /home/olinnyk/IdeaProjects/WickiUp/OCP/src/main/java/com/linnyk/ocp/nio/test_file/test.txt
			at sun.nio.fs.UnixFileSystemProvider.newDirectoryStream(UnixFileSystemProvider.java:426)
			at java.nio.file.Files.newDirectoryStream(Files.java:457)
			at java.nio.file.Files.list(Files.java:3451)
			at com.linnyk.ocp.nio.Files_list.main(Files_list.java:29)
		*/
	}
}