package lafore.data_structures.red_black_trees;

import org.junit.Test;

import lafore.data_structures.red_black_trees.for_tests.Key;

import java.util.Comparator;

public class TreeMapApp {

	@Test
	public void testSimpleObjects() {
		final TreeMap<Integer, String> treeMap = new TreeMap<>();

		treeMap.put(4, "hello 4");
		treeMap.put(5, "hello 5");
		treeMap.put(3, "hello 3");
		treeMap.put(2, "hello 2");
		treeMap.put(6, "hello 6");
		treeMap.put(1, "hello 1");

		System.out.println(treeMap);
	}

	@Test
	public void testTrickyObjectsWithComparable() {
		final TreeMap<Key, String> treeMap = new TreeMap<>();

		treeMap.put(new Key(4), "hello 4");
		treeMap.put(new Key(5), "hello 5");
		treeMap.put(new Key(3), "hello 3");
		treeMap.put(new Key(2), "hello 2");
		treeMap.put(new Key(6), "hello 6");
		treeMap.put(new Key(1), "hello 1");

		System.out.println(treeMap);
	}

	@Test
	public void testTrickyObjectsWithComparator() {
		final TreeMap<Key, String> treeMap = new TreeMap<>(Comparator.comparingInt(Key::getIndex));

		treeMap.put(new Key(4), "hello 4");
		treeMap.put(new Key(5), "hello 5");
		treeMap.put(new Key(3), "hello 3");
		treeMap.put(new Key(2), "hello 2");
		treeMap.put(new Key(6), "hello 6");
		treeMap.put(new Key(1), "hello 1");

		System.out.println(treeMap);
	}
}
