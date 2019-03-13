package com.linnyk.ocp.modificators.folder2.defaultPackage;

import com.linnyk.ocp.modificators.folder1.defaultPackage.DefaultParentClass;

public class DefaultChildClass extends DefaultParentClass {

	public void doWord() {
		System.out.println(/*param*/); // В классе наследники из другого пакета нельзя использовать
	}
}
