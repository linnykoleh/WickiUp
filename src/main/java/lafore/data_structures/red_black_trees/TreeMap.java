package lafore.data_structures.red_black_trees;

import java.util.Comparator;
import java.util.Stack;

/**
 * @author LinnykOleh
 */
@SuppressWarnings("unchecked")
public class TreeMap<K, V> {

	private Entry<K, V> root;
	private final Comparator<? super K> comparator;

	private static final boolean RED   = false;
	private static final boolean BLACK = true;

	private int elements;

	public TreeMap() {
		comparator = null;
	}

	public TreeMap(Comparator<? super K> comparator) {
		this.comparator = comparator;
	}

	/*--------------- PUT --------------*/

	public V put(K key, V value) {
		Entry<K, V> entry = this.root;
		if (entry == null) {
			this.root = new Entry<>(key, value, null);
			return null;
		}
		int cmp;
		Entry<K, V> parent;
		Comparator<? super K> cpr = comparator;
		if (cpr != null) {
			do {
				parent = entry;
				cmp = cpr.compare(key, entry.key);
				if (cmp < 0) {
					entry = entry.left;
				} else if (cmp > 0) {
					entry = entry.right;
				} else {
					return entry.setValue(value);
				}
			} while (entry != null);
		} else {
			if (key == null) throw new NullPointerException();
			Comparable<? super K> keyOfInsertValue = (Comparable<? super K>) key;
			do {
				parent = entry;
				cmp = keyOfInsertValue.compareTo(entry.key);
				if (cmp < 0) {
					entry = entry.left;
				} else if (cmp > 0) {
					entry = entry.right;
				} else {
					return entry.setValue(value);
				}
			} while (entry != null);
		}
		Entry<K, V> entryOfKey = new Entry<>(key, value, parent);
		if (cmp < 0)
			parent.left = entryOfKey;
		else
			parent.right = entryOfKey;
		elements++;
		fixAfterInsertion(entryOfKey);
		return null;
	}

	private void fixAfterInsertion(Entry<K, V> entry) {
		entry.color = RED;

		while (entry != null && entry != root && entry.parent.color == RED) {
			if (parentOf(entry) == leftOf(parentOf(parentOf(entry)))) {
				Entry<K,V> y = rightOf(parentOf(parentOf(entry)));
				if (colorOf(y) == RED) {
					setColor(parentOf(entry), BLACK);
					setColor(y, BLACK);
					setColor(parentOf(parentOf(entry)), RED);
					entry = parentOf(parentOf(entry));
				} else {
					if (entry == rightOf(parentOf(entry))) {
						entry = parentOf(entry);
						rotateLeft(entry);
					}
					setColor(parentOf(entry), BLACK);
					setColor(parentOf(parentOf(entry)), RED);
					rotateRight(parentOf(parentOf(entry)));
				}
			} else {
				Entry<K,V> y = leftOf(parentOf(parentOf(entry)));
				if (colorOf(y) == RED) {
					setColor(parentOf(entry), BLACK);
					setColor(y, BLACK);
					setColor(parentOf(parentOf(entry)), RED);
					entry = parentOf(parentOf(entry));
				} else {
					if (entry == leftOf(parentOf(entry))) {
						entry = parentOf(entry);
						rotateRight(entry);
					}
					setColor(parentOf(entry), BLACK);
					setColor(parentOf(parentOf(entry)), RED);
					rotateLeft(parentOf(parentOf(entry)));
				}
			}
		}
		root.color = BLACK;
	}

	private static <K, V> boolean colorOf(Entry<K, V> entry) {
		return (entry == null ? BLACK : entry.color);
	}

	private static <K, V> Entry<K, V> parentOf(Entry<K, V> entry) {
		return (entry == null ? null: entry.parent);
	}

	private static <K, V> void setColor(Entry<K, V> entry, boolean color) {
		if (entry != null)
			entry.color = color;
	}

	private static <K, V> Entry<K, V> leftOf(Entry<K, V> entry) {
		return (entry == null) ? null: entry.left;
	}

	private static <K, V> Entry<K, V> rightOf(Entry<K, V> entry) {
		return (entry == null) ? null: entry.right;
	}

	private void rotateLeft(Entry<K, V> entry) {
		if (entry != null) {
			Entry<K, V> r = entry.right;
			entry.right = r.left;
			if (r.left != null) {
				r.left.parent = entry;
			}
			r.parent = entry.parent;
			if (entry.parent == null) {
				root = r;
			} else if (entry.parent.left == entry) {
				entry.parent.left = r;
			} else {
				entry.parent.right = r;
			}
			r.left = entry;
			entry.parent = r;
		}
	}

	/** From CLR */
	private void rotateRight(Entry<K, V> entry) {
		if (entry != null) {
			Entry<K, V> leftEntry = entry.left;
			entry.left = leftEntry.right;
			if (leftEntry.right != null) {
				leftEntry.right.parent = entry;
			}
			leftEntry.parent = entry.parent;
			if (entry.parent == null) {
				root = leftEntry;
			} else if (entry.parent.right == entry) {
				entry.parent.right = leftEntry;
			} else {
				entry.parent.left = leftEntry;
			}
			leftEntry.right = entry;
			entry.parent = leftEntry;
		}
	}

	/*/--------------- PUT --------------*/


	/*--------------- GET --------------*/

	public V get(Object key) {
		Entry<K, V> entry = getEntry(key);
		return (entry == null ? null : entry.value);
	}

	private Entry<K, V> getEntry(Object key) {
		if (comparator != null) {
			return getEntryUsingComparator(key);
		}
		if (key == null) {
			throw new NullPointerException();
		}
		Comparable<? super K> searchingKey = (Comparable<? super K>) key;
		Entry<K, V> entry = root;
		while (entry != null) {
			int result = searchingKey.compareTo(entry.key);
			if (result < 0) {
				entry = entry.left;
			} else if (result > 0) {
				entry = entry.right;
			} else {
				return entry;
			}
		}
		return null;
	}

	private Entry<K, V> getEntryUsingComparator(Object key) {
		Comparator<? super K> cpr = comparator;
		if (cpr != null) {
			Entry<K, V> entry = root;
			while (entry != null) {
				int result = cpr.compare((K)key, entry.key);
				if (result < 0) {
					entry = entry.left;
				} else if (result > 0) {
					entry = entry.right;
				} else {
					return entry;
				}
			}
		}
		return null;
	}

	/*/--------------- GET --------------*/

	public void displayTree() {

		Stack globalStack = new Stack();
		globalStack.push(root);
		int nBlanks = 62;
		boolean isRowEmpty = false;
		System.out.println("......................................................");

		while(!isRowEmpty) {
			Stack localStack = new Stack();
			isRowEmpty = true;
			for(int j = 0; j < nBlanks; j++) {
				System.out.print(" ");
			}

			while(!globalStack.isEmpty()) {
				Entry temp = (Entry)globalStack.pop();
				if(temp != null) {
					final String color = temp.color ? "black" : "red";
					System.out.print("("+temp.getKey() + " " +color + ")");
					localStack.push(temp.left);
					localStack.push(temp.right);
					if(temp.left != null || temp.right != null)
						isRowEmpty = false;
				} else {
					System.out.print(" ");
					localStack.push(null);
					localStack.push(null);
				}
				for(int j = 0; j < nBlanks * 2 - 2; j++) {
					System.out.print(" ");
				}
			}

			System.out.println();
			nBlanks /= 2;
			while(!localStack.isEmpty())
				globalStack.push(localStack.pop());
		}
		System.out.println("......................................................");
	}

}
