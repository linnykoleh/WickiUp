package com.linnik.wickiup.lafore.data_structures.hash_tables.hash_map.objects;

import java.util.Objects;

public class ObjectWithEqualsAlwaysFalse {

	private final int a;
	private final int b;

	public ObjectWithEqualsAlwaysFalse(int a, int b) {
		this.a = a;
		this.b = b;
	}

	@Override
	public boolean equals(Object o) {
		return false;
	}

	@Override
	public int hashCode() {
		return Objects.hash(a, b);
	}

	@Override
	public String toString() {
		return "{" + a + ", " + b + "}";
	}
}