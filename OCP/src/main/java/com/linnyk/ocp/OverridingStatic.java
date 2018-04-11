package com.linnyk.ocp;

public class OverridingStatic {

	/**
		 МОЖНО перегружать статический метод,

	     НЕЛЬЗЯ переопределять статический нестатическим и нестатический статическим
	 */
}
//-------------------------------------------------------------------
class ParentNew {

	public int doIt(){
		return 0;
	}
}

class ChildNew extends ParentNew {

//	public static int doIt(){
		//// Сompilation error. Cannot override static method
//		return 0;
//	}

}
//-------------------------------------------------------------------

class ParentNew2 {

	public static int doIt(){
		return 0;
	}

	public static int doIt(int a){
		return 0;
	}

}

class ChildNew2 extends ParentNew2 {

//	public int doIt(){
		// Сompilation error. Cannot override static method
//		return 0;
//	}

}
//-------------------------------------------------------------------


