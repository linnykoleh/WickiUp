package com.linnyk.ocp.inner;

import java.io.Serializable;

public class OuterClassExtending {

	class Inner extends OuterClass{

	}

	class Inner1 extends Thread{

	}

	class Inner2 extends OuterClassExtending{

	}

	class Inner3 implements Serializable {

	}

	void myMethod(){

		class MemberInner extends Inner{

		}

		class MemberInner1 extends OuterClassExtending{

		}

		class MemberInner2 implements Serializable {

		}
	}

}
