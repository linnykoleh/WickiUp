package lc.algorithms.easy.array;

/**
 * Created by LinnykOleh on 16.01.17.
 */
public class TwoSum {

	/**
	 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
     *
	 * You may assume that each input would have exactly one solution.
	 *
	 * Example:
	 * Given nums = [2, 7, 11, 15], target = 9,
     *
	 * cBecause nums[0] + nums[1] = 2 + 7 = 9,
	 * return [0, 1].
	 *
	 * @param nums inputs array
	 * @param target specific target
	 * @return      position of sum result
	 */
	public int[] twoSum(int[] nums, int target) {
		int[] result = new int[2];
		for(int i = 0; i < nums.length; i++){
			for(int j = i + 1; j < nums.length; j++){
				if(target == nums[i] + nums[j]){
					result[0] = i;
					result[1] = j;
					return result;
				}
			}
		}
		return result;
	}
}
