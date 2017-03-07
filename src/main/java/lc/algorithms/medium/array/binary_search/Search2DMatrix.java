package lc.algorithms.medium.array.binary_search;

/**
 * @author LinnykOleh
 */
public class Search2DMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length > 0 && matrix[0].length > 0) {
            int rowIndex = findRow(matrix, target);
            if (rowIndex != -1) {
                return findTarget(matrix[rowIndex], target);
            }
        }
        return false;
    }

    private boolean findTarget(int[] array, int target){
        int left = 0;
        int right = array.length - 1;
        int mid;

        while(left <= right){
            mid = left + ((right - left) / 2);
            int midValue = array[mid];
            if(midValue == target){
                return true;
            }
            if(mid > target){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return false;
    }

    private int findRow(int[][] matrix, int target){
        int left = 0;
        int right = matrix.length - 1;
        int mid;

        while(left <= right){
            mid = left + ((right - left) / 2);
            int midRowFirstValue = matrix[mid][0];
            if(midRowFirstValue <= target){
                return mid;
            }else{
                right = mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Search2DMatrix().searchMatrix(
                new int[][]{
                        new int[]{ 1, 3, 5, 7},
                        new int[]{10,11,16,20},
                        new int[]{23,30,34,50}},
                3));

        System.out.println(new Search2DMatrix().searchMatrix(
                new int[][]{
                        new int[]{1}},
                1));

        System.out.println(new Search2DMatrix().searchMatrix(
                new int[][]{
                        new int[]{}},
                1));

        System.out.println(new Search2DMatrix().searchMatrix(
                new int[][]{
                        new int[]{1}},
                0));
    }
}
