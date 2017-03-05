package lc.algorithms.medium.array.binary_search;

/**
 * @author LinnykOleh
 */
public class FindTheDuplicateNumber {

    public int findDuplicate(int[] nums) {

        int searchingIndex = 0;
        int searchingValue;

        while(searchingIndex < nums.length){
            searchingValue = nums[searchingIndex];
            boolean result = findDuplicate(nums, searchingValue, searchingIndex);
            if(result){
                return searchingValue;
            }else{
                searchingIndex++;
            }
        }
        return -1;
    }

    public boolean findDuplicate(int[] nums, int value, int leftIndex){
        int left = leftIndex + 1;
        int right = nums.length - 1;
        int mid;


        while(left < right){
            mid = (left + right) / 2;
            int midValue = nums[mid];
            if(value == midValue){
                return true;
            }

            if(midValue > value){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return false;
    }
}
