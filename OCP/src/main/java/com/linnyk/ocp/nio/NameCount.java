package com.linnyk.ocp.nio;

import java.nio.file.Path;
import java.nio.file.Paths;

public class NameCount {

	public static void main(String[] args) {
		Path p1 = Paths.get("photos/../beaches/./calangute/a.txt;");
		System.out.println(p1); // photos/../beaches/./calangute/a.txt;

		Path p2 = p1.normalize();
		System.out.println(p2); // beaches/calangute/a.txt;

		Path p3 = p1.relativize(p2);
		System.out.println(p3); // ../../../../../../beaches/calangute/a.txt;

		Path p4 = p2.relativize(p1);
		System.out.println(p4); // ../../../photos/../beaches/./calangute/a.txt;

		System.out.println(p1.getNameCount() + " " + p2.getNameCount() + " " +
				           p3.getNameCount() + " " + p4.getNameCount());
		// 6 3 9 9
	}
}
