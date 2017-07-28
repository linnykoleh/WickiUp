

[Main Information](src/main/resources/main_info.md)

| <H3> Data structures                                                                             | <H3> Algorithms                                                                                  |<H3> Patterns                       			                  			           | <H3> SOLID                                                                                 |
|--------------------------------------------------------------------------------------------------|--------------------------------------------------------------------------------------------------|------------------------------------------------------------------------------------|--------------------------------------------------------------------------------------------|
| [Arrays](src/main/resources/data_structures/arrays/arrays.md)                                    | [Bubble sort](src/main/resources/algorithms/bubble_sort/bubble_sort.md)                          |	[Creational](Patterns/src/main/java/patterns/_1_creational/creational_patterns.md) |  [Single Responsibility Principle](Solid/src/main/resources/solid/single_responsibility.md)|
| [Linked lists](src/main/resources/data_structures/linked_lists/linked_lists.md)                  | [Selection sort](src/main/resources/algorithms/selection_sort/selection_sort.md)                 |	[Structural](Patterns/src/main/java/patterns/_2_structural/structural_patterns.md) |  [Open Closed Principle](Solid/src/main/resources/solid/open_close.md)                     |
| [Hash tables](src/main/resources/data_structures/hash_tables/hash_tables.md)                     | [Insertion sort](src/main/resources/algorithms/insertion_sort/insertion_sort.md)                 | [Behavioral](Patterns/src/main/java/patterns/_3_behavioral/behavioral_patterns.md) |  [Liskov’s Substitution Principle](Solid/src/main/resources/solid/liskov_substitution.md)  |
| [Binary trees](src/main/resources/data_structures/binary_trees/binary_trees.md)                  |                                                                                                  |	                                   			                  			           |  [Interface Segregation Principle](Solid/src/main/resources/solid/interface_segregation.md)|
| [Red black trees](src/main/resources/data_structures/red_black_trees/red_black_trees.md)         |                                                                                                  |                                    			                   			           |  [Dependency Inversion Principle](Solid/src/main/resources/solid/dependency_inversion.md)  |
| [Stack](src/main/resources/data_structures/stack/stack.md)                                       |                                                                                                  |                                    			                  			           |                                                                                            |


 ![alt text](src/main/resources/images/solid.png)

### Algorithms complexity

 ![alt text](src/main/resources/images/search_complexity.png)
 
 ![alt text](src/main/resources/images/sort_complexity.png)
 
 ![alt text](src/main/resources/images/data_structures_complexity.png)
 
 ![alt text](src/main/resources/images/o-complexity.png)
 
 
 > In order to run benchmarking
 
 > mvn clean install -DskipTests
 > java -jar target/benchmarks.jar
