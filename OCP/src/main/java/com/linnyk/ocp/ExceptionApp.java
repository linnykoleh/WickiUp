package com.linnyk.ocp;

import java.io.IOException;

public class ExceptionApp {

	public static void main(String[] args) {
		try {
			try {
				doSomethingRuntimeException();
			}
			catch (IOException e) {
				System.out.println("catch IOException");
			}
			finally {
				System.out.println("finally IOException");
			}

		}
		catch (Exception e) {
			System.out.println("catch Exception");
		}
		finally {
			System.out.println("finally Exception");
		}
	}

	private static void doSomethingException() throws Exception {
		throw new Exception();
		//finally IOException
		//catch Exception
		//finally Exception
	}

	private static void doSomethingIOException() throws IOException {
		throw new IOException();
		//catch IOException
		//finally IOException
		//finally Exception
	}

	private static void doSomethingRuntimeException() throws IOException {
		throw new RuntimeException();
		//finally IOException
		//catch Exception
		//finally Exception
	}
}
