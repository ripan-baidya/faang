package array.easy;

import java.util.Arrays;

/**
 * @author Ripan Baidya
 * @date 30-07-2025
 *
 * Given an integer array nums, move all 0's to the end of it while maintaining the relative order
 * of the non-zero elements. Note that you must do this in-place without making a copy of the array.
 *
 * Example:
 *
 * Input: nums = [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 */
public class MoveZeros {
    /**
     * The idea is to move all the zeros to the end of the array while maintaining the relative order
     * of non-zero elements using two traversals.
     *
     * Time Complexity: O(n), as we are traversing the array only twice.
     * Auxiliary Space: O(1)
     */
    /*
    public void moveZeroes(int[] nums) {
        int n = nums.length; // array length
        int count = 0; // count of non-zero elements

        // If the current element is not zero, place it at the 'count' position
        // and move the 'count' pointer to the next position.
        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                nums[count ++] = nums[i];
            }
        }

        // Now all non-zero elements have been shifted to
        // the front. Make all elements 0 from count to end.
        while (count < n) {
            nums[count ++] = 0;
        }
    }
    */

    /**
     * The idea is similar to the previous approach where we took a pointer, say count to track where the next
     * non-zero element should be placed. However, on encountering a non-zero element, instead of directly
     * placing the non-zero element at arr[count], we will swap the non-zero element with arr[count]. This
     * will ensure that if there is any zero present at arr[count], it is pushed towards the end of array
     * and is not overwritten.
     *
     * Time Complexity: O(n), as we are traversing the array only once.
     * Space Complexity: O(1)
     */
    public void moveZeroes(int[] nums) {
        int n = nums.length; // array length
        // Pointer to track the position for next non-zero element
        int count = 0;

        for (int i = 0; i < n; i ++) {
            // when current element is non-zero
            if (nums[i] != 0) {
                // Swap the current element with the 0 at index 'count'
                int temp = nums[count];
                nums[count] = nums[i];
                nums[i] = temp;

                // move count pointer to next position
                count ++;
            }
        }
    }

    public static void main(String[] args) {
        var obj = new MoveZeros();

        int[] nums = {0, 1, 0, 3, 12};
        obj.moveZeroes(nums);

        System.out.println(Arrays.toString(nums));
    }
}
