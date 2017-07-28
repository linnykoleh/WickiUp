package com.linnik.wickiup.lafore.data_structures.hash_tables.hash_map.objects;

/**
 *  @author LinnykOleh
 */
public class BadKey {

	private String a;
	private String b;

	public BadKey(String a, String b) {
		this.a = a;
		this.b = b;
	}

	/** Bad equals and hashcode in order to obtain a collision*/
	@Override
	public int hashCode() {
		return (a + b).length();
	}

	@Override
	public boolean equals(Object obj) {
		return a.length() == b.length();
	}
}
