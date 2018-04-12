package com.linnyk.ocp;

public class FromToPrimitivies {

	public double returnDouble(){
		return new Integer(1);
	}

	public double returnDouble2(){
		return 1;
	}

//	public Double returnDoubleBoxed(){
//		return 1;           Compilation error, int cannot be boxed to Double
//	}

	public double returnDouble3(){
		return 2L;
	}

	public double returnDouble4(){
		return 2L;
	}

	public long returnLong(){
		return 1;
	}

//	public Long returnLongBoxed(){
//		return 1;         Compilation error, int cannot be boxed to Long
//	}

	public int returnInt(){
		return (int) 1L;
	}

	public int returnInt2(){
		return (int) 1.0;
	}



}
