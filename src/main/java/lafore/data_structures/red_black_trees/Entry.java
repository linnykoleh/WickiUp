package lafore.data_structures.red_black_trees;

import java.util.Map;

/**
 * @author LinnykOleh
 */
public class Entry<K, V>{

	private static final boolean RED   = false;
	private static final boolean BLACK = true;

	K key;
	V value;
	Entry<K, V> left;
	Entry<K, V> right;
	Entry<K, V> parent;
	boolean color = BLACK;

	Entry(K key, V value, Entry<K, V> parent) {
		this.key = key;
		this.value = value;
		this.parent = parent;
	}

	public K getKey() {
		return key;
	}

	public V getValue() {
		return value;
	}

	public V setValue(V value) {
		V oldValue = this.value;
		this.value = value;
		return oldValue;
	}

	public boolean equals(Object o) {
		if (!(o instanceof Map.Entry))
			return false;

		Entry<?,?> e = (Entry<?,?>) o;

		return valEquals(key,e.getKey()) && valEquals(value,e.getValue());
	}

	public int hashCode() {
		int keyHash = (key == null ? 0 : key.hashCode());
		int valueHash = (value == null ? 0 : value.hashCode());
		return keyHash ^ valueHash;
	}

	public String toString() {
		return key + "=" + value;
	}

	private static boolean valEquals(Object o1, Object o2) {
		return (o1 == null ? o2 == null : o1.equals(o2));
	}
}