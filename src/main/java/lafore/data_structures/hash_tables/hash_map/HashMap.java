package lafore.data_structures.hash_tables.hash_map;

/**
 * @author LinnykOleh
 */
public class HashMap<K, V> {

	private transient Node<K,V>[] hashTable;

	public V put(K key, V value) {
		return putVal(hash(key), key, value);
	}

	private V putVal(int hashCodeKey, K key, V value) {
		int newHashTableSize;
		int indexForNode;

		Node<K,V> nodeByHashCodeKey;

		if (hashTable == null || hashTable.length == 0)
			hashTable = resize();
			newHashTableSize = hashTable.length;
		if ((nodeByHashCodeKey = hashTable[indexForNode = (newHashTableSize - 1) & hashCodeKey]) == null)
			hashTable[indexForNode] = new Node<>(hashCodeKey, key, value, null);
		else {
			Node<K,V> next;
			K keyForNodeByHashCodeKey;
			if (nodeByHashCodeKey.hash == hashCodeKey && ((keyForNodeByHashCodeKey = nodeByHashCodeKey.key) == key || (key != null && key.equals(keyForNodeByHashCodeKey))))
				next = nodeByHashCodeKey;
			else {
				while(true) {
					next = nodeByHashCodeKey.next;
					if (next == null) {
						nodeByHashCodeKey.next = new Node<>(hashCodeKey, key, value, null);
						break;
					}
					if (next.hash == hashCodeKey && ((keyForNodeByHashCodeKey = next.key) == key || (key != null && key.equals(keyForNodeByHashCodeKey)))) {
						break;
					}
					nodeByHashCodeKey = next;
				}
			}
			if (next != null) {
				V oldValue = next.value;
				if (oldValue == null) {
					next.value = value;
				}
				return oldValue;
			}
		}
		return null;
	}

	private Node<K,V>[] resize(){
		//stub for resizing hashMap full code is here
		//@code java.util.HashMap.resize()
		return hashTable;
	}

	private static int hash(Object key) {
		return (key == null) ? 0 : (key.hashCode()) ^ (key.hashCode() >>> 16);
	}
}
