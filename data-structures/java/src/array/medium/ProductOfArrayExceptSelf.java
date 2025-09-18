package array.medium;

import java.util.Arrays;

/**
 * @author Ripan Baidya
 * @date 18/09/25
 * 
 * Given an integer array nums, return an array answer such that answer[i] is equal to the product
 * of all the elements of nums except nums[i].
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 * You must write an algorithm that runs in O(n) time and without using the division operation.
 *
 * Example:
 *
 * Input: nums = [1,2,3,4]
 * Output: [24,12,8,6]
 * Example 2:
 */
public class ProductOfArrayExceptSelf {
    /**
     * Use two auxiliary arrays (`prefix` and `suffix`) to store the cumulative product
     * of elements before and after each index.
     * For each position `i`, the result is simply: res[i] = prefix[i] * suffix[i]
     *
     * Time Complexity: O(n)  (two passes for prefix/suffix + one pass for result)
     * Space Complexity: O(n) (extra space for prefix and suffix arrays)
     */
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length; // Size of the array

        // Arrays to store product of all elements before (prefix) and after (suffix)
        // each index
        int[] prefix = new int[n];
        int[] suffix = new int[n];

        // Build prefix product array
        // prefix[i] = product of nums[0] ... nums[i-1]
        prefix[0] = 1; // No elements before index 0
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] * nums[i - 1];
        }

        // Build suffix product array
        // suffix[i] = product of nums[i+1] ... nums[n-1]
        suffix[n - 1] = 1; // No elements after last index
        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] * nums[i + 1];
        }

        // Build result using prefix[i] * suffix[i]
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = prefix[i] * suffix[i];
        }

        return res;
    }

    public static void main(String[] args) {
        var obj = new ProductOfArrayExceptSelf();

        int[] nums = {1, 2, 3, 4};
        int[] res = obj.productExceptSelf(nums);
        System.out.println(Arrays.toString(res));
    }
}
