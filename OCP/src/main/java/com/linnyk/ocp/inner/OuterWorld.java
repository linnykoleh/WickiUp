package com.linnyk.ocp.inner;

public class OuterWorld {

	InnerPeace i = new InnerPeace();

	private class InnerPeace{
		private String reason = "none";
	}

	public static void main(String[] args) {
		System.out.println(new OuterWorld().i.reason);
	}
}
