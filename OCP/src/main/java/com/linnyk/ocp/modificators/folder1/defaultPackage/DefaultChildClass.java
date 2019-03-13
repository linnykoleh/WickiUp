package com.linnyk.ocp.modificators.folder1.defaultPackage;

public class DefaultChildClass extends DefaultParentClass {

	public void doWord(){
		System.out.println(param); // В классе наследники из того же пакета можно использовать
	}
}
