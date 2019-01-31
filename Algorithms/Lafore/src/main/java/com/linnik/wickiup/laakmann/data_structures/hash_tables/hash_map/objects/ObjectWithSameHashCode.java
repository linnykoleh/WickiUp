package com.linnik.wickiup.laakmann.data_structures.hash_tables.hash_map.objects;

import java.util.Objects;

public class ObjectWithSameHashCode {

	private final int a;
	private final int b;

	public ObjectWithSameHashCode(int a, int b) {
		this.a = a;
		this.b = b;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ObjectWithSameHashCode that = (ObjectWithSameHashCode) o;
		return a == that.a &&
				b == that.b;
	}

	@Override
	public int hashCode() {
		return Objects.hash(1);
	}

	@Override
	public String toString() {
		return "{" + a + ", " + b + "}";
	}
}
