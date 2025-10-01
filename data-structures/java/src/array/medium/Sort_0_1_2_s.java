package array.medium;

import java.util.Arrays;

/**
 * @author Ripan Baidya
 * @date 31-07-2025
 *
 * Given an array arr[] containing only 0s, 1s, and 2s. Sort the array in ascending order.
 * Note: You need to solve this problem without utilizing the built-in sort function.
 *
 * Example :
 * Input: nums = [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 */

/**
 * using built in function
 *
 * Time Complexity: O(n log n)
 * Space Complexity: O(1)
 */
/**
 * public void sortColors(int[] nums) {
 *         Arrays.sort(nums);
 * }
 */

/**
 * Better Approach:
 * We will count the occurrence of each color in the array and then replace the array elements with
 * the three different colors respectively 0, 1 and 2.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
/**
 * public void sortColors(int[] nums) {
 *         int n = nums.length;
 *
 *         // we use c1, c2, c3 to denote three different colors
 *         int c1 = 0, c2 = 0, c3 = 0;
 *
 *         // count the occurrence of each color in the array
 *         for (int i = 0; i < n; i ++){
 *             if(nums[i] == 0) c1 ++;
 *             else if(nums[i] == 1) c2 ++;
 *             else if(nums[i] == 2) c3 ++;
 *         }
 *
 *         int it = 0;  // iterator
 *
 *         // replace the array elements with the three different colors
 *         while(c1 != 0){
 *             nums[it ++] = 0;
 *             c1 --;
 *         }
 *         while(c2 != 0){
 *             nums[it ++] = 1;
 *             c2 --;
 *         }
 *         while(c3 != 0){
 *             nums[it ++] = 2;
 *             c3 --;
 *         }
 *     }
 */

/**
 * optimal solution
 * The idea is to sort the array of size n using three pointers: low = 0, mid = 0 and high = n - 1 such that
 * the array is divided into 4 parts -
 *      1. arr[0 .. low - 1] → All 0s
 *      2. arr[low .. mid - 1] → All 1s
 *      3. arr[mid .. high] → Unprocessed elements (unknown)
 *      4. arr[high + 1 .. n - 1] → All 2s
 */
public class Sort_0_1_2_s {
    // function to swap two numbers
    private void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public void sortColors(int[] nums) {
        int n = nums.length;

        // low: boundary for 0s
        // mid: current element being checked
        // high: boundary for 2s
        int low = 0, mid = 0, high = n-1;

        // process elements until mid crosses high
        while (mid <= high){
            // current is 0: swap with lo and move both
            // pointers forward
            if (nums[mid] == 0){
                swap(nums, low, mid);
                low ++;
                mid ++;
            }
            else if (nums[mid] == 1){
                // current is 1: it's already in correct position
                mid ++;
            }
            else {
                // current is 2: swap with hi and move hi backward
                // do not increment mid, as swapped value needs
                // to be re-checked
                swap(nums, mid, high);
                high --;
            }
        }
    }

    public static void main(String[] args) {
        var obj = new Sort_0_1_2_s();

        int[] nums = {2,0,2,1,1,0};
        obj.sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}
