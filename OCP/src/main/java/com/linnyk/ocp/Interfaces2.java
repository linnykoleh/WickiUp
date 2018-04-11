package com.linnyk.ocp;

import java.io.IOException;
import java.sql.SQLException;

interface Measurement{

	public default int getLength(){
		return 0;
	}
}

interface Size extends Measurement{

//	public static int getLength(){ Compilation error
//		return 0;                  Static method cannot override instance method
//	}
}

public class Interfaces2 {


}
