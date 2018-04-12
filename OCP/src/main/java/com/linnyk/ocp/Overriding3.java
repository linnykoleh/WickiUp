package com.linnyk.ocp;

public class Overriding3 {

	Parent3 doIt(Parent3 parent3){
		return new Parent3();
	}

}

class Overriding3Chind extends Overriding3 {

	@Override
	Child3 doIt(Parent3 parent3) {
		return new Child3();
	}

//	@Override
//	Parent3 doIt(Child3 parent3) { Compilation error. Сигнатура метода должна быть одинаковая,
//		return new Child3();                          ковариантные типы использутся только для
//	}                                                 для возвращаемого значения
}


class Parent3 {
}

class Child3 extends Parent3{

}
