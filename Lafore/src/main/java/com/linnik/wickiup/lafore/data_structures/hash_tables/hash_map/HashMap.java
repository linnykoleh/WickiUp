package com.linnik.wickiup.lafore.data_structures.hash_tables.hash_map;

/**
 * @author LinnykOleh
 */
public class HashMap<K, V> {

	private transient Node<K,V>[] hashTable;

	static final int DEFAULT_INITIAL_CAPACITY = 1 << 4;

	public V put(K key, V value) {
		int hashCodeKey = hash(key);
		return putVal(hashCodeKey, key, value);
	}

	private V putVal(int hashCodeKey, K key, V value) {
		int newHashTableSize;
		int indexForNode;
		Node<K,V> nodeByHashCodeKey;

		if (hashTable == null || hashTable.length == 0) {
			hashTable = new Node[DEFAULT_INITIAL_CAPACITY];
		}
		newHashTableSize = hashTable.length;
		indexForNode = (newHashTableSize - 1) & hashCodeKey;
		nodeByHashCodeKey = hashTable[indexForNode];
		if (nodeByHashCodeKey == null) {
			hashTable[indexForNode] = new Node<>(hashCodeKey, key, value, null);
		} else {
			Node<K,V> next;
			K keyForNodeByHashCodeKey = nodeByHashCodeKey.key;
			if (nodeByHashCodeKey.hashCodeKey == hashCodeKey && keyForNodeByHashCodeKey == key || (key != null && key.equals(keyForNodeByHashCodeKey))) {
					next = nodeByHashCodeKey;
			} else {
				while(true){
					next = nodeByHashCodeKey.next;
					if (next == null) {
						nodeByHashCodeKey.next = new Node<>(hashCodeKey, key, value, null);
						break;
					}
					if (next.hashCodeKey == hashCodeKey) {
						keyForNodeByHashCodeKey = next.key;
						if(keyForNodeByHashCodeKey == key || ( key != null && key.equals(keyForNodeByHashCodeKey) )) {
							break;
						}
					}
					nodeByHashCodeKey = next;
				}
			}
			if (next != null) {
				V oldValue = next.value;
				if (oldValue != null) {
					next.value = value;
				}
				return oldValue;
			}
		}
		return null;
	}

	private static int hash(Object key) {
		return (key == null) ? 0 : (key.hashCode()) ^ (key.hashCode() >>> 16);
	}

	public V get(Object key) {
		final int hashCodeForKey = hash(key);
		final Node<K,V> nodeByKey = getNode(hashCodeForKey, key);
		return nodeByKey == null ? null : nodeByKey.value;
	}

	private Node<K,V> getNode(int hashCodeKey, Object keySearch) {
		Node<K,V> current;
		Node<K,V> next;
		K keyForNode;

		if (hashTable != null && hashTable.length > 0) {
			int indexByHashCodeKey = (hashTable.length - 1) & hashCodeKey;
			current = hashTable[indexByHashCodeKey];
			if(current != null) {
				if (current.hashCodeKey == hashCodeKey) {
					keyForNode = current.key;
					if (keyForNode == keySearch || (keySearch != null && keySearch.equals(keyForNode))) {
						return current;
					}
				}
				next = current.next;
				if (next != null) {
					do {
						if (next.hashCodeKey == hashCodeKey) {
							keyForNode = next.key;
							if (keyForNode == keySearch || (keySearch != null && keySearch.equals(keyForNode))) {
								return next;
							}
						}
					}
					while ((next = next.next) != null);
				}
			}
		}
		return null;
	}
}
