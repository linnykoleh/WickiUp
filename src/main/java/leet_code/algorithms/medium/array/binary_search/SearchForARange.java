package leet_code.algorithms.medium.array.binary_search;

/**
 * @author LinnykOleh
 */
public class SearchForARange {

	/**
	 * Given an array of integers sorted in ascending order, find the starting and ending position of a given target value.
	 *
	 * Your algorithm's runtime complexity must be in the order of O(log n).
	 *
	 * If the target is not found in the array, return [-1, -1].
	 *
	 * For example,
	 *        Given [5, 7, 7, 8, 8, 10] and target value 8,
	 *            return [3, 4].
	 *
	 * @param nums   an array of integers sorted in ascending order
	 * @param target value to find
	 * @return       array with positions
	 */
	public int[] searchRange_LinearImplementation(int[] nums, int target) {
		int[] result = {-1, -1};
		int count = 0;

		for(int i = 0; i < nums.length; i++){
			if(nums[i] == target){
				if(count == 0) {
					result[count] = i;
					result[++count] = i;
				}else
					result[count] = i;
			}
		}

		return result;
	}
}

/**
 *
 * Best solution.
 *
 * Easy java O(logn) solution.
 *
 * There must be two indices in the array. Which means, we can just simply apply to binary search twice to find each index of the target element.
 *
 */
class Solution {

	public int[] searchRange(int[] nums, int target) {
		int[] result = new int[2];
		result[0] = findFirst(nums, target);
		result[1] = findLast(nums, target);
		return result;
	}

	private int findFirst(int[] nums, int target) {
		int idx = -1;
		int start = 0;
		int end = nums.length - 1;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (nums[mid] >= target) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
			if (nums[mid] == target)
				idx = mid;
		}
		return idx;
	}

	private int findLast(int[] nums, int target) {
		int idx = -1;
		int start = 0;
		int end = nums.length - 1;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (nums[mid] <= target) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
			if (nums[mid] == target)
				idx = mid;
		}
		return idx;
	}
}
