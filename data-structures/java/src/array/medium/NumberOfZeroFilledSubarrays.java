package array.medium;

/**
 * @author Ripan Baidya
 * @date 18/09/25
 * 
 * Given an integer array nums, return the number of subarrays filled with 0.
 * A subarray is a contiguous non-empty sequence of elements within an array.
 *
 * Example :
 *
 * Input: nums = [1,3,0,0,2,0,0,4]
 * Output: 6
 * Explanation:
 * There are 4 occurrences of [0] as a subarray.
 * There are 2 occurrences of [0,0] as a subarray.
 * There is no occurrence of a subarray with a size more than 2 filled with 0.
 * Therefore, we return 6.
 */

public class NumberOfZeroFilledSubarrays {
    /**
     * we will maintain two variables, total and cnt. which will initialize to 0.
     * we will iterate through the array and if the current element is not zero, we will reset cnt to 0.
     * else we will increment cnt by 1 and add it to total. and one the entire iteration is done, we will
     * return total.
     *
     * time: O(n)
     * space: O(1)
     */
    public long zeroFilledSubarray(int[] nums) {
        long total = 0; // count total number of zero filled subarrays
        int cnt = 0; // count subarrays

        for (int i = 0; i < nums.length; i ++) {
            if (nums[i] != 0) {
                cnt = 0;
            }  else {
                total += ++cnt;
            }
        }

        return total;
    }

    public static void main(String[] args) {
        var obj = new NumberOfZeroFilledSubarrays();

        int[] nums = {1,3,0,0,2,0,0,4};
        long total = obj.zeroFilledSubarray(nums);

        System.out.println("total = " + total);
    }
}
