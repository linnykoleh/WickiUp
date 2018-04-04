package com.linnyk.ocp;

import java.io.IOException;

public class OverrideException {


}

class Parent{

	void doSomeWork() throws IOException{

	}
}

class Child extends Parent {

/*
    @Override
	void doSomeWork() {
		//Без throws IOException - OK
	}

	@Override
	void doSomeWork() throws FileNotFoundException {
		//Сабкласс IOException - OK
	}

	@Override
	void doSomeWork() throws Exception {
		//Супер класс IOException - Compiler error
	}

	@Override
	void doSomeWork() throws RuntimeException {
		//RuntimeException - OK
	}
*/

}
