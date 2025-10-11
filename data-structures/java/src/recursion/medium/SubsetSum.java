package recursion.medium;

/**
 * @author Ripan Baidya
 * @date 11/10/25
 *
 * Given an array of positive integers arr[] and a value sum, determine if there is a subset of arr[] with
 * sum equal to given sum.
 *
 * Examples:
 * Input: arr[] = [3, 34, 4, 12, 5, 2], sum = 9
 * Output: true
 * Explanation: Here there exists a subset with target sum = 9, 4+3+2 = 9.
 */
public class SubsetSum {
    /**
     * Approach: ******** Backtracking ********
     * We use backtracking to explore all possible subsets of the array and check if any of them sum to the target.
     * and return true if we find a valid subset.
     *
     * Time Complexity: O(2ⁿ) where n is the length of the array.
     * Space Complexity: O(n) due to the recursion stack.
     */

    // DFS helper to check if a subset sums to target
    private static boolean dfs(int pos, int[] nums, int[] currSum, int target) {
        // Base case: reached end of array
        if (pos == nums.length) {
            return currSum[0] == target;
        }

        // Only continue if current sum is <= target
        if (currSum[0] <= target) {
            // Pick current element
            currSum[0] += nums[pos];
            if (dfs(pos + 1, nums, currSum, target)) return true;
            currSum[0] -= nums[pos]; // backtrack

            // Do not pick current element
            if (dfs(pos + 1, nums, currSum, target)) return true;
        }

        return false; // no valid subset found
    }

    // Entry function to check if subset sum exists
    static Boolean isSubsetSum(int[] nums, int target) {
        return dfs(0, nums, new int[1], target);
    }

    static void main() {
        var obj = new SubsetSum();

        int[] nums = {3, 34, 4, 12, 5, 2};
        int sum = 9;
        boolean result = obj.isSubsetSum(nums, sum);
        System.out.println(result);
    }
}
