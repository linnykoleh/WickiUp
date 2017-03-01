package lc.algorithms.easy.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LinnykOleh
 */
public class FindAllNumbersDisappearedInArray {

    /**
     * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
     *
     * Find all the elements of [1, n] inclusive that do not appear in this array.
     *
     * Example:
     *
     *  Input:
     *      [4,3,2,7,8,2,3,1]
     *
     *  Output:
     *      [5,6]
     *
     * @param nums array with numbers
     * @return     all numbers disappeared in array
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        final List<Integer> result = new ArrayList<>();
        int[] array = new int[nums.length + 1];

        for (int num : nums) {
            array[num] = num;
        }
        for(int j = 1; j < array.length; j++){
            if(array[j] == 0){
                result.add(j);
            }
        }
        return result;
    }
}
