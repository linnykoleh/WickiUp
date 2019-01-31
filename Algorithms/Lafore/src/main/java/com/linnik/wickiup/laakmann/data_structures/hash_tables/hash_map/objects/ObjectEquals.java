package com.linnik.wickiup.laakmann.data_structures.hash_tables.hash_map.objects;

import java.util.Objects;

public class ObjectEquals {

	private final int a;

	public ObjectEquals(int a) {
		this.a = a;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ObjectEquals that = (ObjectEquals) o;
		return a == that.a;
	}

	@Override
	public int hashCode() {
		return Objects.hash(1);
	}

	@Override
	public String toString() {
		return "ObjectEquals{" +
				"a=" + a +
				'}';
	}
}
