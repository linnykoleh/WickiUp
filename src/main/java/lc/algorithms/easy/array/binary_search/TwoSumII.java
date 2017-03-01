package lc.algorithms.easy.array.binary_search;

/**
 * @author LinnykOleh
 */
public class TwoSumII {

	/**
	 * Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.
	 *
	 * The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.
	 * Please note that your returned answers (both index1 and index2) are not zero-based.
	 *
	 * You may assume that each input would have exactly one solution and you may not use the same element twice.
	 *
	 * Input: numbers={2, 7, 11, 15}, target=9
	 * Output: index1=1, index2=2
	 *
	 * */

	public int[] twoSum_Linear_Search(int[] numbers, int target) {
		int[] result = new int[2];
		for(int i = 0; i < numbers.length; i++){
			int value = numbers[i];
			for(int j = i + 1; j < numbers.length; j++){
				if((value + numbers[j]) == target){
					result[0] = i + 1;
					result[1] = j + 1;
					return result;
				}
			}
		}
		return result;
	}

	public int[] twoSum_Binary_Search(int[] numbers, int target) {
		int[] result = new int[2];
		int top = 1;
		int bottom = 0;

		while(bottom < numbers.length){
			int valueBottom = numbers[bottom];
			int valueTop = numbers[top];

			if((valueBottom + valueTop) == target){
				result[0] = bottom + 1;
				result[1] = top + 1;
				return result;
			}else{
				top++;
				if(top == numbers.length){
					bottom++;
					top = bottom + 1;
				}
			}
		}
		return result;
	}

	public int[] twoSum_Best_Solution(int[] numbers, int target) {
		int[] result = new int[2];

		if (numbers == null || numbers.length < 2) return result;

		int left = 0, right = numbers.length - 1;
		while (left < right) {
			int v = numbers[left] + numbers[right];
			if (v == target) {
				result[0] = left + 1;
				result[1] = right + 1;
				break;
			} else if (v > target) {
				right--;
			} else {
				left++;
			}
		}
		return result;
	}
}
