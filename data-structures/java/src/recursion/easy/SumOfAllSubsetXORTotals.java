package recursion.easy;

/**
 * @author Ripan Baidya
 * @date 26/09/25
 * 
 * The XOR total of an array is defined as the bitwise XOR of all its elements, or 0 if the
 * array is empty.
 * For example, the XOR total of the array [2,5,6] is 2 XOR 5 XOR 6 = 1.
 * Given an array nums, return the sum of all XOR totals for every subset of nums.
 * Note: Subsets with the same elements should be counted multiple times.
 *
 * An array a is a subset of an array b if a can be obtained from b by deleting some (possibly
 * zero) elements of b.
 *
 * Example:
 * Input: nums = [1,3]
 * Output: 6
 * Explanation: The 4 subsets of [1,3] are:
 * - The empty subset has an XOR total of 0.
 * - [1] has an XOR total of 1.
 * - [3] has an XOR total of 3.
 * - [1,3] has an XOR total of 1 XOR 3 = 2.
 * 0 + 1 + 3 + 2 = 6
 */
public class SumOfAllSubsetXORTotals {
    private void dfs(int idx, int[] nums, int[] totalSum, int curr) {
        // Base Case
        if (idx == nums.length) {
            totalSum[0] += curr;
            return;
        }

        dfs(idx+1, nums, totalSum, curr^nums[idx]); // pick
        dfs(idx+1, nums, totalSum, curr); // non pick
    }
    public int subsetXORSum(int[] nums) {
        int[] sum = new int[1];
        dfs(0, nums, sum, 0);
        return sum[0];
    }

    static void main() {
        var obj = new SumOfAllSubsetXORTotals();
        
        int[] nums = {1, 3};
        int sum = obj.subsetXORSum(nums);

        System.out.println("sum = " + sum);
    }
}
