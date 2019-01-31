## BigO

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