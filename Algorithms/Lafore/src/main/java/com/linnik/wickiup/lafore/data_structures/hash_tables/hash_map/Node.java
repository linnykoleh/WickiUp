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
	int bucket;

	public Node(int bucket, int hashCodeKey, K key, V value, Node<K,V> next) {
		this.bucket = bucket;
		this.hashCodeKey = hashCodeKey;
		this.key = key;
		this.value = value;
		this.next = next;
	}

	public String buildString() {
		final StringBuilder stringBuilder = new StringBuilder(this.toString());
		Node<K,V> currentNext = next;
		while (currentNext != null){
			stringBuilder.append(" ==> ");
			stringBuilder.append(currentNext.toString());
			currentNext = currentNext.next;
		}
		return stringBuilder.toString();
	}

	@Override
	public final int hashCode() {
		return Objects.hashCode(key) ^ Objects.hashCode(value);
	}

	@Override
	public final boolean equals(Object o) {
		if (o == this)
			return true;
		if (o instanceof Node) {
			Node e = (Node)o;
			return Objects.equals(key, e.key) && Objects.equals(value, e.value);
		}
		return false;
	}

	@Override
	public  String toString() {
		return "[Key: " + key + " (h:" + key.hashCode() + ") = Value: {" + value + "}]";
	}

}
