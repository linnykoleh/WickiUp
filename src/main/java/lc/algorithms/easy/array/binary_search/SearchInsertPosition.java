package lc.algorithms.easy.array.binary_search;

/**
 * @author LinnykOleh
 */
public class SearchInsertPosition {

	/**
	 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
     *
	 * You may assume no duplicates in the array.
     *
	 * Here are few examples.
	 *      [1,3,5,6], 5 → 2
	 *      [1,3,5,6], 2 → 1
	 *      [1,3,5,6], 7 → 4
	 *      [1,3,5,6], 0 → 0
	 *
	 *
	 * @param nums   input array
	 * @param target which elemetn find id
	 * @return       id of target
	 */
	public int searchInsert(int[] nums, int target) {

		int top = nums.length - 1;
		int bottom = 0;
		int index;

		while(true){
			index = (top + bottom) / 2;
			if(nums[index] == target){
				return index;
			}else if(target > nums[top]){
				return top + 1;
			}else if(target < nums[bottom]){
				return bottom;
			}else{
				if(target < nums[index]){
					top = index - 1;
				}else{
					bottom = index + 1;
				}
			}
		}
	}
}
