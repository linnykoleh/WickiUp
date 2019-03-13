package com.linnyk.ocp.modificators.folder1.protectedPackage;

public class ProtectedChildClass extends ProtectedParentClass {

	public void doWord(){
		System.out.println(param); // В классе наследники из того же пакета можно использовать
	}
}
