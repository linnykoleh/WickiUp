package com.linnik.wickiup.lafore.data_structures.hash_tables.hash_map;

import java.util.Objects;

/**
 * @author LinnykOleh
 */
public class Node<K, V> {

	final int hashCodeKey;
	final K key;
	V value;
	Node<K,V> next;

	public Node(int hashCodeKey, K key, V value, Node<K,V> next) {
		this.hashCodeKey = hashCodeKey;
		this.key = key;
		this.value = value;
		this.next = next;
	}

	public final String toString() {
		return key + "=" + value;
	}

	public final int hashCode() {
		return Objects.hashCode(key) ^ Objects.hashCode(value);
	}

	public final boolean equals(Object o) {
		if (o == this)
			return true;
		if (o instanceof Node) {
			Node e = (Node)o;
			return Objects.equals(key, e.key) && Objects.equals(value, e.value);
		}
		return false;
	}

}
