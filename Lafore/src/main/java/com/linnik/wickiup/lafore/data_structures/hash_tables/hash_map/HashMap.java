package com.linnik.wickiup.lafore.data_structures.hash_tables.hash_map;

/**
 * @author LinnykOleh
 */
public class HashMap<K, V> {

	private transient Node<K,V>[] hashTable;

	/**
	 * The number of times this HashMap has been structurally modified
	 * Structural modifications are those that change the number of mappings in
	 * the HashMap or otherwise modify its internal structure (e.g.,
	 * rehash).  This field is used to make iterators on Collection-views of
	 * the HashMap fail-fast.  (See ConcurrentModificationException).
	 *
	 *  If updates Iterator while iteration we will get ConcurrentModificationException
	 *
	 	if (modificationsCount != expectedModCount)
		   throw new ConcurrentModificationException();
	 */
	private transient int modificationsCount;

	/**
	 * The number of key-value mappings contained in this map.
	 */
	private transient int size;

	/**
	 * The next size value at which to resize (capacity * load factor).
	 */
	private int threshold;

	static final int DEFAULT_INITIAL_CAPACITY = 1 << 4;

	public V put(K key, V value) {
		int hashCodeKey = hash(key);
		return putVal(hashCodeKey, key, value, true                                                                        );
	}

	private V putVal(int hashCodeKey, K key, V value, boolean evict) {
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
			hashTable[indexForNode] = new Node<>(indexForNode, hashCodeKey, key, value, null);
		} else {
			Node<K,V> next;
			K keyForNodeByHashCodeKey = nodeByHashCodeKey.key;
			if (nodeByHashCodeKey.hashCodeKey == hashCodeKey && keyForNodeByHashCodeKey == key || (key != null && key.equals(keyForNodeByHashCodeKey))) {
				next = nodeByHashCodeKey;
			} else if (nodeByHashCodeKey instanceof HashMap.TreeNode){
					next = ((HashMap.TreeNode<K,V>) nodeByHashCodeKey).putTreeVal(this, hashTable, hashCodeKey, key, value);
			} else {
				while(true){
					next = nodeByHashCodeKey.next;
					if (next == null) {
						nodeByHashCodeKey.next = new Node<>(indexForNode, hashCodeKey, key, value, null);
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
		++modificationsCount;
		if (++size > threshold)
			resize(); //stub
		afterNodeInsertion(evict); //stub
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

	private Node<K, V>[] resize() {
		//stub emulating real HashMap
		return null;
	}

	void afterNodeInsertion(boolean evict) {
		//stub emulating real HashMap
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder("HashMap{");
		for(Node<K, V> node: hashTable ){
			if(node != null) {
				stringBuilder.append("\n\t");
				stringBuilder.append("[Bucket ");
				stringBuilder.append(node.bucket + "] ");
				stringBuilder.append("==> ");

				stringBuilder.append(node.buildString());
			}
		}
		stringBuilder.append("\n}");
		return stringBuilder.toString();
	}

	static class TreeNode<K, V> extends Node<K, V>{

		public TreeNode(int bucket, int hashCodeKey, K key, V value, Node<K, V> next) {
			super(bucket, hashCodeKey, key, value, next);
		}

		final TreeNode<K,V> putTreeVal(HashMap<K,V> hashMap, Node<K,V>[] hashTable, int hashCodeKey, K key, V value) {
			return this;
		}
	}
}
