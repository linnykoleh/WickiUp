package com.linnyk.ocp.modificators.folder1;

import com.linnyk.ocp.modificators.folder1.defaultPackage.DefaultParentClass;
import com.linnyk.ocp.modificators.folder1.protectedPackage.ProtectedParentClass;

public class ClassForAccessProtectedAndDefault {

	public void doWork() {
		new DefaultParentClass()/*.param*/;   // В другом просто классе из другого пакета нельзя использовать
		new ProtectedParentClass()/*.param*/; // В другом просто классе из другого пакета нельзя использовать
	}
}
