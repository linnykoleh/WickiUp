package com.learning.linnyk.sp.part2;

import com.learning.linnyk.sp.TerminatorQuoter;
import com.learning.linnyk.sp.part1.Quoter;

/**
 * @author LinnykOleh
 */
public class T1000 extends TerminatorQuoter implements Quoter {

	@Override
	public void sayQuote() {
		System.out.println("I'm liquid");
	}
}
