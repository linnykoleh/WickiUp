package com.linnik.wickiup.lafore.data_structures.hash_tables.hash_map.objects;

import java.util.Objects;

public class ObjectHashCodeNotOverride {

	private int a;
	private int b;

	public ObjectHashCodeNotOverride(int a, int b) {
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
		ObjectHashCodeNotOverride that = (ObjectHashCodeNotOverride) o;
		return Objects.equals(a, that.a) && Objects.equals(b, that.b);
	}

	@Override
	public String toString() {
		return "{" + a + ", " + b + "}";
	}
}
