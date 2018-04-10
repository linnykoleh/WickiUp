package com.linnyk.ocp;

import java.io.IOException;

public class Overriding2 {
}

class First{

	public void performWork() throws IOException {

	}

}

class Second extends First {

	@Override
	public void performWork() {

	}
}
