package com.linnik.wickiup.lafore.data_structures.hash_tables.hash_map.objects;

public class ObjectEqualsNotOverride {

	private int a;
	private int b;

	public ObjectEqualsNotOverride(int a, int b) {
		this.a = a;
		this.b = b;
	}

	@Override
	public int hashCode() {
		return (a + b);
	}

	@Override
	public String toString() {
		return "{" + a + ", " + b + "}";
	}
}
