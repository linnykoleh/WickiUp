package lafore.data_structures.hash_tables.hash_map;

import java.util.Objects;

/**
 * @author LinnykOleh
 */
public class Node<K, V> {

	final int hash;
	final K key;
	V value;
	Node<K,V> next;

	public Node(int hash, K key, V value, Node<K,V> next) {
		this.hash = hash;
		this.key = key;
		this.value = value;
		this.next = next;
	}

	public final K getKey() {
		return key;
	}
	public final V getValue() {
		return value;
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
			return Objects.equals(key, e.getKey()) && Objects.equals(value, e.getValue());
		}
		return false;
	}

}
