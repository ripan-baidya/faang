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

    /**
     * Approach 1: ***** Backtracking *****
     * we use recursion to calculate the XOR sum while forming subsets. At each step, we choose to either include
     * or exclude the current element and pass the updated XOR value accordingly. This way, we compute the  total
     * XOR of all subsets directly during recursion.The sum of both choices (with and without the current element)
     * is returned to build the final answer efficiently.
     *
     * Time Complexity: O(2ⁿ), where n is the length of the input array nums.
     * Space Complexity: O(n)
     */

    // Entry point
    public int subsetXORSum(int[] nums) {
        int[] ans = new int[1]; // ans
        dfs(0, 0, nums, ans);
        return ans[0];
    }

    // helper function to calculate the XOR sum while forming subsets
    private void dfs(int idx, int curXor, int[] nums, int[] totalSum) {
        if (idx == nums.length) {
            totalSum[0] += curXor;
            return;
        }

        dfs(idx+1, curXor^nums[idx], nums, totalSum); // pick
        dfs(idx+1, curXor, nums, totalSum); // non-pick
    }

    static void main() {
        var obj = new SumOfAllSubsetXORTotals();
        
        int[] nums = {1, 2, 3};
        int ans = obj.subsetXORSum(nums);

        System.out.println(ans); // 12
    }
}
