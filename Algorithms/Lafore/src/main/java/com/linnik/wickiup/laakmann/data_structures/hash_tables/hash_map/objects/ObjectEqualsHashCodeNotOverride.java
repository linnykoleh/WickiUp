package com.linnik.wickiup.laakmann.data_structures.hash_tables.hash_map.objects;

public class ObjectEqualsHashCodeNotOverride {

	private int a;
	private int b;

	public ObjectEqualsHashCodeNotOverride(int a, int b) {
		this.a = a;
		this.b = b;
	}

	@Override
	public String toString() {
		return "{" + a + ", " + b + "}";
	}
}
