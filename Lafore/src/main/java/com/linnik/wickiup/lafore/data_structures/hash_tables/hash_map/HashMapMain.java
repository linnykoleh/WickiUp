package com.linnik.wickiup.lafore.data_structures.hash_tables.hash_map;

import org.junit.Test;

import com.linnik.wickiup.lafore.data_structures.hash_tables.hash_map.objects.BadKey;
import com.linnik.wickiup.lafore.data_structures.hash_tables.hash_map.objects.GoodKey;

/**
 * @author LinnykOleh
 */
public class HashMapMain {

	@Test
	public void test_real_HashMap(){
		final java.util.HashMap<String, String> hashMap = new java.util.HashMap<>();

		hashMap.put("1", "first");
		hashMap.put("1", "second");
		hashMap.put("1", "third");

		final String result = hashMap.get("1");

		System.out.println(result);
	}

	@Test
	public void test_simple_objects(){
		final HashMap<String, String> hashMap = new HashMap<>();

		hashMap.put("1", "first 1");
		hashMap.put("1", "second 1");
		hashMap.put("1", "third 1");

		hashMap.put("2", "second 2");
		hashMap.put("3", "third 3");

		final String result1 = hashMap.get("1");
		final String result3 = hashMap.get("3");

		System.out.println(result1);
		System.out.println(result3);
	}

	@Test
	public void test_object_with_normal_equal_and_hashcode(){
		final HashMap<GoodKey, String> hashMap = new HashMap<>();

		hashMap.put(new GoodKey("AB", "CD"), "value 1");
		hashMap.put(new GoodKey("AB", "CD"), "value 2");
		hashMap.put(new GoodKey("AB", "CD"), "value 3");

		hashMap.put(new GoodKey("ABC", "D"), "value 4");

		final String result1 = hashMap.get(new GoodKey("AB", "CD"));
		System.out.println(result1);

		final GoodKey key5 = new GoodKey("A", "BCD");
		hashMap.put(key5, "value 5");

		final String result2 = hashMap.get(new GoodKey("A", "BCD"));

		System.out.println(result2);
	}

	@Test
	public void test_object_with_bad_equal_and_hashcode_collision(){
		final HashMap<BadKey, String> hashMap = new HashMap<>();

		hashMap.put(new BadKey("AB", "CD"), "value 1");
		hashMap.put(new BadKey("AB", "CD"), "value 2");
		hashMap.put(new BadKey("AB", "CD"), "value 3");

		final String result1 = hashMap.get(new BadKey("AB", "CD"));
		System.out.println(result1); // value 3


		final BadKey badKey1 = new BadKey("A", "BCD");
		hashMap.put(badKey1, "value 4");

		final String result2 = hashMap.get(badKey1); // value 4
		System.out.println(result2);
		final String result3 = hashMap.get(new BadKey("A", "BCD")); //null
		System.out.println(result3);

		final BadKey badKey2 = new BadKey("", "ABCD");
		hashMap.put(badKey2, "value 5");

		final String result4 = hashMap.get(badKey2);
		System.out.println(result4); // value 5
		final String result5 = hashMap.get(new BadKey("", "ABCD")); //null
		System.out.println(result5);

	}
}
