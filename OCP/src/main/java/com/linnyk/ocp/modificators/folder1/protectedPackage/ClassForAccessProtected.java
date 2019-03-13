package com.linnyk.ocp.modificators.folder1.protectedPackage;

public class ClassForAccessProtected {

	public void doWork() {
		System.out.println(new ProtectedParentClass().param); // В просто классе из этого же пакета можно использовать
	}
}
