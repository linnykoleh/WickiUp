package com.linnyk.ocp.nio;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class NioMarkReset {

	public static void main(String[] args) throws IOException {
		try(Reader r = new BufferedReader(new FileReader("/home/olinnyk/IdeaProjects/WickiUp/OCP/src/main/java/com/linnyk/ocp/nio/mark_reset/test.txt"))){

			if(r.markSupported()){
				BufferedReader in = (BufferedReader) r;
				System.out.println(in.readLine());
				in.mark(100);
				System.out.println(in.readLine());
				System.out.println(in.readLine());
				in.reset();
				System.out.println(in.readLine());
				in.reset();
				System.out.println(in.readLine());
				System.out.println(in.readLine());
				System.out.println(in.readLine());
			}else{
				System.out.println("Mark Not supported");
			}
		}

		// A
		// B
		// C
		// B
		// B
		// C
		// D

	}
}
