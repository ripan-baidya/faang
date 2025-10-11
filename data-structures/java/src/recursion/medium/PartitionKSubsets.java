package recursion.medium;

import java.util.Arrays;

/**
 * @author Ripan Baidya
 * @date 11/10/25
 *
 * Given an integer array nums and an integer k, return true if it is possible to divide this array into
 * k non-empty subsets whose sums are all equal.
 *
 * Example:
 * Input: nums = [4,3,2,3,5,2,1], k = 4
 * Output: true
 * Explanation: It is possible to divide it into 4 subsets (5), (1, 4), (2,3), (2,3) with equal sums.
 */
public class PartitionKSubsets {
    /**
     * Approach: ******** Backtracking ********
     * The problem can be solved using a bottom-up approach. We first calculate the sum of all elements in the
     * array and divide it by k. If the sum is not divisible by k, it is not possible to divide the array into
     * k subsets with equal sum. We initialize a boolean array of size n, where n is the length of the input
     * array, to keep track of the numbers that have been used in the current subset. We also initialize a 2D
     * array of size k x (n / k + 1) to keep track of the current sum of each subset.
     * We then iterate through all subsets and for each subset, we iterate through all elements in the array. If
     * we can add the current element to the current subset without exceeding the target sum, we add it to the
     * subset and update the current sum. If we have formed k subsets with equal sum, we return true. If we are
     * unable to form k subsets with equal sum, we return false.
     *
     * Time Complexity: O(n * 2ⁿ), generating all subsets requires 2ⁿ recursive calls, and copying each subset of
     * size.
     * Space Complexity: O(n), used array and recursion stack use at most n space at a time.
     */

    // DFS helper to try partitioning into k subsets of equal sum
    private boolean dfs(int start, int k, int target, int[] nums, int currSum, boolean[] used) {
        // If only 1 subset left, the rest automatically form valid subsets
        if (k == 1) return true;

        // If current subset reaches target, move to next subset
        if (currSum == target) {
            return dfs(0, k - 1, target, nums, 0, used);
        }

        for (int i = start; i < nums.length; i++) {
            // Skip if already used or would exceed target
            if (used[i] || currSum + nums[i] > target) continue;

            // Pick number
            used[i] = true;
            if (dfs(i + 1, k, target, nums, currSum + nums[i], used)) return true;
            used[i] = false; // backtrack

            // Optimization: if first element didn't work, no need to try others at this level
            if (currSum == 0) break;
        }

        return false;
    }

    // Entry function
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int total = Arrays.stream(nums).sum();
        if (total % k != 0) return false; // can't evenly divide

        Arrays.sort(nums);
        int target = total / k;
        if (nums[nums.length - 1] > target) return false; // largest number too big

        boolean[] used = new boolean[nums.length];
        return dfs(0, k, target, nums, 0, used);
    }

    static void main() {
        var obj = new PartitionKSubsets();

        int[] nums = {4,3,2,3,5,2,1};
        int k = 4;
        boolean result = obj.canPartitionKSubsets(nums, k);
        System.out.println(result);
    }
}
