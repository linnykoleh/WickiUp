package com.linnik.wickiup.patterns._2_structural._4_decorator.live;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author LinnykOleh
 */
public class Live {

	public static void main(String[] args) throws IOException {
		final File file = new File("./file_name.txt");
		final FileOutputStream fileOutputStream = new FileOutputStream(file);
		final DataOutputStream dataOutputStream = new DataOutputStream(fileOutputStream);

		fileOutputStream.close();
		dataOutputStream.close();
	}
}
