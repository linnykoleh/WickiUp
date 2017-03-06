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
            if(findDuplicate(nums, searchingValue, searchingIndex))
                return searchingValue;
            else
                searchingIndex++;
        }
        return -1;
    }

    private boolean findDuplicate(int[] nums, int value, int leftIndex){
        int left = leftIndex + 1;
        int right = nums.length - 1;
        int mid;

        while(left <= right){
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

    public static void main(String[] args) {
        System.out.println(new FindTheDuplicateNumber().findDuplicate(new int[]{1, 2, 3, 4, 5, 6, 7, 7, 8, 9}));

        System.out.println(new FindTheDuplicateNumber().findDuplicate(new int[]{1, 1, 1, 2, 3, 4, 5, 8, 11}));

        System.out.println(new FindTheDuplicateNumber().findDuplicate(new int[]{1, 2, 3, 4, 5, 8, 11, 11}));
    }
}

class FindTheDuplicateNumber_Best{

    public int findDuplicate(int[] nums) {
        int n = nums.length;
        int slow = n;
        int fast = n;

        do{
            slow = nums[slow-1];
            fast = nums[nums[fast-1]-1];
        }while(slow != fast);
        slow = n;
        while(slow != fast){
            slow = nums[slow-1];
            fast = nums[fast-1];
        }
        return slow;
    }

    public static void main(String[] args) {
        System.out.println(new FindTheDuplicateNumber_Best().findDuplicate(new int[] {2, 5, 1, 1, 4, 3}));
        System.out.println(new FindTheDuplicateNumber_Best().findDuplicate(new int[] {3, 3, 4, 1, 2, 5}));
    }

}
