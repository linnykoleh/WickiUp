package com.linnyk.ocp.nio;

import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

public class Files_readAllBytes {

	/**
	 	public static byte[] readAllBytes(Path path) throws IOException

	 */

	public static void main(String[] args) throws IOException {
		final byte[] bytes =
				Files.readAllBytes(Paths.get("/home/olinnyk/IdeaProjects/WickiUp/OCP/src/main/java/com/linnyk/ocp/nio/test_file/test.txt"));

		for (int i = 0; i < bytes.length - 1; i++) {
			System.out.print(" " + bytes[i]);
		}
		// 72 101 108 108 111 10 84 101 115 116 10 84 101 115 116 35
	}

}