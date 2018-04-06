package com.linnyk.ocp;

import java.io.FileNotFoundException;
import java.io.IOException;

public class OverriddenThrow {

	public void doIt(){

	}

	public void doIt2() throws IOException {

	}

}

class ChildOverridden extends OverriddenThrow {

	//Переопределенный метод может бросить exception только Runtime если никакоко не было
	@Override
	public void doIt() throws RuntimeException{

	}

	//Переопределенный метод также может бросить exception подхидящий по типу
	@Override
	public void doIt2() throws FileNotFoundException {

	}

//	@Override
//	public void doIt2() throws Exception {
//  	Compilation error
//	}
}
