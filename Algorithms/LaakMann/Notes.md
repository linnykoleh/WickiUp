## BigO

[Big-O Complexity Chart](http://bigocheatsheet.com/) 

- Big O time is the language and metric used to describe the efficiency of algorithms.

### Time Complexity

- O (big 0): In academia, big O describes an upper bound on the time. An algorithm that prints all the
  values in an array could be described as O(N), but it could also be described as O(N2), O(N3), or 0( 2
  N) (or many other big O times). The

#### Best Case, Worst Case, and Expected Case

- **Best Case**: If all elements are equal, then quick sort will, on average, just traverse through the array once.
    - This is `O(N)`
- **Worst Case**: What if we get really unlucky and the pivot is repeatedly the biggest element in the array?    
  In this case, our recursion doesn't divide the
  array in half and recurse on each half. It just shrinks the subarray by one element. 
    - This will degenerate to an `O(N2)` runtime.
- **Expected Case**
    - We can expect a runtime of `O(NlogN)`
    
### Space Complexity

- Time is not the only thing that matters in an algorithm. We might also care about the amount of memory or space-required by an algorithm.    
- Space complexity is a parallel concept to time complexity. If we need to create an array of size n, this will
  require `0(n)` space. If we need a two-dimensional array of size nxn, this will require `O(n2)` space.
  
![alt text](images/Screenshot.png)  

![alt text](images/order_of_growth.png)  


| Big-O      |  computations for 10 things |  computations for 100 things
|------------|-----------------------------|---------------------------
|O(1)        |   1                         |     1
|O(log(n))   |   3                         |     7
|O(n)        |  10                         |   100
|O(n log(n)) |  30                         |   700
|O(n^2)      | 100                         | 10000

For example: 
```java
List<int> numbers = new List<int> {1,2,3,4,5,6,7,12,543,7};
```

- `O (1)`

```java
return numbers.First();
```

- `O (n) `
	- `O (n)` означает, что время, затрачиваемое вашим алгоритмом, растет линейно по мере увеличения вашего ввода. 

```java
int result = 0;
foreach (int num in numbers){
    result += num;
}
return result;
```

- `O (n log (n))`

```java
int result = 0;
foreach (int num in numbers)
{
    int index = numbers.length - 1;
    while (index > 1)
    {
        // yeah, stupid, but couldn't come up with something more useful :-(
        result += numbers[index];
        index /= 2;
    }
}
return result;
```

- `O (n ^ 2)`
	- `O (n ^ 2)` означает, что время, в течение которого ваш алгоритм растет, становится квадратом вашего ввода

```java
int result = 0;
foreach (int outerNum in numbers)
{
    foreach (int innerNum in numbers)
    {
        result += outerNum * innerNum;
    }
}
return result;
```

##### Примеры

- `O(1) — константная сложность`
Также случается, что время работы алгоритма вообще не зависит от размера входных данных. 
Тогда сложность обозначают как O(1). Например, для определения значения третьего элемента массива не нужно ни запоминать элементы, ни проходить по ним сколько-то раз

- `O(n) — линейная сложность`
Такой сложностью обладает, например, алгоритм поиска наибольшего элемента в не отсортированном массиве. 
Нам придётся пройтись по всем n элементам массива, чтобы понять, какой из них максимальный.

- `O(log n) — логарифмическая сложность`
Простейший пример — бинарный поиск. Если массив отсортирован, мы можем проверить, есть ли в нём какое-то конкретное значение, методом деления пополам. 
Проверим средний элемент, если он больше искомого, то отбросим вторую половину массива — там его точно нет. 
Если же меньше, то наоборот — отбросим начальную половину. И так будем продолжать делить пополам, в итоге проверим log n элементов.

![alt text](images/2_log.svg)  

- `O(n2) — квадратичная сложность`
Такую сложность имеет, например, алгоритм сортировки вставками. В канонической реализации он представляет из себя два вложенных цикла: 
один, чтобы проходить по всему массиву, а второй, чтобы находить место очередному элементу в уже отсортированной части. 
Таким образом, количество операций будет зависеть от размера массива как n * n, т. е. n2.
