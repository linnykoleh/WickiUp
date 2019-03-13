package com.linnyk.ocp.modificators.folder2.protectedPackage;

import com.linnyk.ocp.modificators.folder1.protectedPackage.ProtectedParentClass;

public class ProtectedChildClass extends ProtectedParentClass {

	public void doWord() {
		System.out.println(param); // В классе наследники из другого пакета можно использовать
	}
}
