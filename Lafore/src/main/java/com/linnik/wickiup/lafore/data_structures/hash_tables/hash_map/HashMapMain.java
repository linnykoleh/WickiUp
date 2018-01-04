package com.linnik.wickiup.lafore.data_structures.hash_tables.hash_map;

import org.junit.Test;

import com.linnik.wickiup.lafore.data_structures.hash_tables.hash_map.objects.BadKey;
import com.linnik.wickiup.lafore.data_structures.hash_tables.hash_map.objects.GoodKey;
import com.linnik.wickiup.lafore.data_structures.hash_tables.hash_map.objects.ObjectEqualsHashCodeNotOverride;
import com.linnik.wickiup.lafore.data_structures.hash_tables.hash_map.objects.ObjectEqualsNotOverride;
import com.linnik.wickiup.lafore.data_structures.hash_tables.hash_map.objects.ObjectHashCodeNotOverride;

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

	@Test
	public void test_object_with_equal_not_override(){
		// Если equals не переопределен, и ключи это разные объекты мы всегда будем писать в линкед лист
		// тк ключи сравниваются по: (равны ли хэш коды ключей и равны ли ссылки ключей) или (equals ли ключи)
		// (hashCodeKey == hashCodeKey && key == key) || (key.equals(key)
		// в нашем случае ключи все разные 'new ObjectEqualsNotOverride'
		final HashMap<ObjectEqualsNotOverride, String> hashMap = new HashMap<>();

		hashMap.put(new ObjectEqualsNotOverride(1,2), "1");
		hashMap.put(new ObjectEqualsNotOverride(1,2), "2");
		hashMap.put(new ObjectEqualsNotOverride(1,2), "3");

		// Если equals не переопределен, и ключи это одинаковые объекты мы всегда будем перезаписывать значение
		// тк если хэш коды ключей одинаковые и ссылки ключей равны друг другу (==)
		// это значит, что ссылка у них одинаковая,
		// значит значения для этого ключа будет переписываться,
		// даже если не переопределен equals
		final ObjectEqualsNotOverride key = new ObjectEqualsNotOverride(1, 3);
		hashMap.put(key, "4");
		hashMap.put(key, "5");
		hashMap.put(key, "6");

		hashMap.put(new ObjectEqualsNotOverride(2,2), "7");

		System.out.println(hashMap);

		/*
		HashMap{
			[Bucket 3] ==> [Key: {1, 2} (h:3) = Value: {1}] ==> [Key: {1, 2} (h:3) = Value: {2}] ==> [Key: {1, 2} (h:3) = Value: {3}] ==> [Key: {1, 2} (h:3) = Value: {6}]
			[Bucket 4] ==> [Key: {2, 2} (h:4) = Value: {7}]
		}
		*/
	}

	@Test
	public void test_object_with_hashcode_not_override(){
		// Если hashCode не переопределен, то используется их реализация из Object ( public native int hashCode())
		// значит для каждого ключа hashCode всегда разный (неизвестно какой)
		// значит и bucket тоже разный
		// значит каждый элемент ложится в отдельный bucket
		// но может быть ситуация, что для разных hashCode bucket(а их default значение для HashMap = 16)
		// может одинаковый (хэш функция так посчитала)
		// значит элементы хранятся в линкед листе
		final HashMap<ObjectHashCodeNotOverride, String> hashMap = new HashMap<>();

		hashMap.put(new ObjectHashCodeNotOverride(1,2), "1");
		hashMap.put(new ObjectHashCodeNotOverride(1,2), "2");
		hashMap.put(new ObjectHashCodeNotOverride(1,2), "3");

		final ObjectHashCodeNotOverride key = new ObjectHashCodeNotOverride(1, 2);
		hashMap.put(key, "4");
		hashMap.put(key, "5");
		hashMap.put(key, "6");

		hashMap.put(new ObjectHashCodeNotOverride(2,2), "7");

		System.out.println(hashMap);

		/*
		HashMap{
			[Bucket 5] ==> [Key: {1, 2} (h:2094411587) = Value: {1}]
			[Bucket 6] ==> [Key: {1, 2} (h:1620303253) = Value: {2}]
			[Bucket 13] ==> [Key: {1, 2} (h:90320863) = Value: {3}]
			[Bucket 4] ==> [Key: {1, 2} (h:1216590855) = Value: {6}] ==> [Key: {2, 2} (h:2107447833) = Value: {7}]
		}
		*/
	}

	@Test
	public void test_object_with_hashcode_and_equals_not_override(){
		// Точно также как если бы hashCode был бы не переопределен
		// тк hashCode не известен и поведение не понятно
		final HashMap<ObjectEqualsHashCodeNotOverride, String> hashMap = new HashMap<>();

		hashMap.put(new ObjectEqualsHashCodeNotOverride(1,2), "1");
		hashMap.put(new ObjectEqualsHashCodeNotOverride(1,2), "2");
		hashMap.put(new ObjectEqualsHashCodeNotOverride(1,2), "3");

		final ObjectEqualsHashCodeNotOverride key = new ObjectEqualsHashCodeNotOverride(1, 2);
		hashMap.put(key, "4");
		hashMap.put(key, "5");
		hashMap.put(key, "6");

		hashMap.put(new ObjectEqualsHashCodeNotOverride(2,2), "7");

		System.out.println(hashMap);

		/*
		HashMap{
			[Bucket 7] ==> [Key: {1, 2} (h:1343441044) = Value: {3}] ==> [Key: {1, 2} (h:693632176) = Value: {6}]
			[Bucket 8] ==> [Key: {1, 2} (h:1586270964) = Value: {1}]
			[Bucket 10] ==> [Key: {2, 2} (h:326549596) = Value: {7}]
			[Bucket 15] ==> [Key: {1, 2} (h:1642360923) = Value: {2}]
		}
		*/
	}
}
