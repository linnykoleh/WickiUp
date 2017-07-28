package com.linnik.wickiup.leet_code.algorithms.medium.array.binary_search;

/**
 * @author LinnykOleh
 */
public class FindFirstAndLastIndex {

	/**
	 * Given a *sorted* array of integers, by the target value find first and the last
	 * index using binary search.
	 *
	 * Example:
	 *     nums - [1,2,3,4,5,6,7,8,8,9] target - 8
	 *
	 *  return [4, 5]
	 *
	 * @param nums   sorted array of integers
	 * @param target value to find
	 * @return       array of indexes
	 */
	public int[] find(int[] nums, int target){
		int[] res = new int[2];

		res[0] = findFirst(nums, target);
		res[1] = findLast(nums, target);

		return res;
	}

	public int findFirst(int[] nums, int target){
		int returnValue = -1;
		int left = 0;
		int right = nums.length - 1;
		int mid;

		while(left <= right){
			mid = (left + right) / 2;
			int midValue = nums[mid];
			if(midValue >= target){
				right = mid - 1;
			}else {
				left++;
			}
			if(midValue == target){
				returnValue = mid;
			}
		}
		return returnValue;
	}

	public int findLast(int[] nums, int target){
		int returnValue = -1;
		int left = 0;
		int right = nums.length - 1;
		int mid;

		while(left <= right){
			mid = (left + right) / 2;
			int midValue = nums[mid];
			if(midValue <= target){
				left = mid + 1;
			}else{
				right--;
			}
			if(midValue == target){
				returnValue = mid;
			}
		}
		return returnValue;
	}

	public static void main(String[] args) {
		int[] ints = new FindFirstAndLastIndex().find(new int[]{1,2,3,4,5,6,7,8,8,9}, 8);
		System.out.println(ints[0] == 7 && ints[1] == 8 ? "Accepted" : "Error");
	}
}
