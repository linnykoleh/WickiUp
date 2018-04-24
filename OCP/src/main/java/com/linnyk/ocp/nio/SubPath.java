package com.linnyk.ocp.nio;

import java.nio.file.Path;
import java.nio.file.Paths;

public class SubPath {

	public static void main(String[] args) {
		Path path = Paths.get("/finance/data/reports/daily/pnl.txt");

		final Path subpath = path.subpath(0, 2);

		System.out.println(subpath); // finance/data

	}
}
