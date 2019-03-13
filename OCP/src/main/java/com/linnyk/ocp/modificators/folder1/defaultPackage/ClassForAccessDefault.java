package com.linnyk.ocp.modificators.folder1.defaultPackage;

public class ClassForAccessDefault {

	public void doWork() {
		System.out.println(new DefaultParentClass().param); // В просто классе из этого же пакета можно использовать
	}
}
