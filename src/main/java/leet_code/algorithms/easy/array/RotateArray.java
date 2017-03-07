package leet_code.algorithms.easy.array;

/**
 * @author LinnykOleh
 */
public class RotateArray {

	/**
	 * Rotate an array of n elements to the right by k steps.
	 *
	 * For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
	 * @param nums arrays to rotate
	 * @param k     from which index
	 */
	public void rotate(int[] nums, int k) {
		int [] numsRes = new int[nums.length];

		if(k >= 0 && nums.length >= k){
			for(int j = 0; j < nums.length; k++, j++){
				if(k == nums.length){
					k = 0;
				}
				numsRes[j] = nums[k];
			}
			nums = numsRes;
		}
	}

	public void rotate_BestSolution(int[] nums, int k) {

		if(nums == null || nums.length < 2){
			return;
		}

		k = k % nums.length;
		reverse(nums, 0, nums.length - k - 1);
		reverse(nums, nums.length - k, nums.length - 1);
		reverse(nums, 0, nums.length - 1);

	}

	private void reverse(int[] nums, int i, int j){
		int tmp;
		while(i < j){
			tmp = nums[i];
			nums[i] = nums[j];
			nums[j] = tmp;
			i++;
			j--;
		}
	}
}
