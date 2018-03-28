package com.linnyk.ocp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class CustomCollector {

	public static void main(String[] args) {
		List<Item> lists = Arrays.asList(
				new Item(1, "bar"),
				new Item(2, "foo1"),
				new Item(2, "foo2"),
				new Item(2, "foo3")
		);

		Collector<Item, HashMap<Integer, Item>, HashMap<Integer, Item>> mapCollectorLong = Collector.of(
				new Supplier<HashMap<Integer, Item>>() {
					/*
						Supplier, создаёт контейнер.
						Для реализации коллектора нам необходимо предоставить Supplier, который создает контейнер.
						Здесь хранится накопленное значение.
					*/
					@Override
					public HashMap<Integer, Item> get() {
						return new HashMap<>();
					}
				},
				new BiConsumer<HashMap<Integer, Item>, Item>() {

					/*
						BiConsumer для накопление элементов
						Затем нам нужно создать функцию, которая определяет, как мы добавим элемент в контейнер.
					*/
					@Override
					public void accept(HashMap<Integer, Item> integerItemHashMap, Item o) {
						integerItemHashMap.put(o.getId(), o);
					}
				},
				new BinaryOperator<HashMap<Integer, Item>>() {

					/*
						BinaryOperator для объединение двух частичных результатов.
						При последовательном восстановлении Supplier и BiConsumer выше были бы достаточными.
						Но чтобы иметь возможность поддерживать параллельную реализацию,
						нам необходимо предоставить объединитель.
						Объединитель - это функция, которая определяет, как можно комбинировать два контейнера результата.
					 */
					@Override
					public HashMap<Integer, Item> apply(HashMap<Integer, Item> integerItemHashMap,
							HashMap<Integer, Item> integerItemHashMap2) {
						integerItemHashMap.putAll(integerItemHashMap2);
						return integerItemHashMap;
					}
				}
		);

		Collector<Item, HashMap<Integer, Item>, HashMap<Integer, Item>> mapCollectorShort = Collector.of(
				HashMap::new,
				(itemHashMap, o) -> itemHashMap.put(o.getId(), o),
				(itemHashMap, integerItemHashMap2) -> {
					itemHashMap.putAll(integerItemHashMap2);
					return itemHashMap;
				}
		);

		Map<Integer, Item> collect = lists.stream().collect(mapCollectorShort);
		System.out.println(collect); // {1={id=1, name='bar'}, 2={id=2, name='foo3'}}

		/*
		Map<Integer, Item> collectError = lists.stream().collect(Collectors.toMap(Item::getId, Function.identity()));

		Ошибка, потому-что ключи одинаковые

		Exception in thread "main" java.lang.IllegalStateException: Duplicate key {id=2, name='foo1'}
			at java.util.stream.Collectors.lambda$throwingMerger$0(Collectors.java:133)
			at java.util.HashMap.merge(HashMap.java:1253)
			at java.util.stream.Collectors.lambda$toMap$58(Collectors.java:1320)
			at java.util.stream.ReduceOps$3ReducingSink.accept(ReduceOps.java:169)
			at java.util.Spliterators$ArraySpliterator.forEachRemaining(Spliterators.java:948)
			at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:481)
			at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:471)
			at java.util.stream.ReduceOps$ReduceOp.evaluateSequential(ReduceOps.java:708)
			at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
			at java.util.stream.ReferencePipeline.collect(ReferencePipeline.java:499)
			at com.swissquote.eforex.cmt.core.impl.computation.CollectorsOf.main(CollectorsOf.java:74)

		*/
	}

	static class Item{

		private int id;
		private String name;

		public Item(int id, String name) {
			this.id = id;
			this.name = name;
		}

		public int getId() {
			return id;
		}

		public String getName() {
			return name;
		}

		@Override
		public String toString() {
			return "{" +
					"id=" + id +
					", name='" + name + '\'' +
					'}';
		}
	}
}
