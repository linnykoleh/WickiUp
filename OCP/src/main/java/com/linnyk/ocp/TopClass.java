package com.linnyk.ocp;

public class TopClass {

	public Inner inner = new Inner(){

		public void doA() {
			System.out.println("Hello");
		}
	};

	public void doA(){
//		inner.doA();  Compilation error, Cannot resolve method doA()
	}

}

class Inner{


}
