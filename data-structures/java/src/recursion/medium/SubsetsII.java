package recursion.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Ripan Baidya
 * @date 03/10/25
 *
 * Given an integer array nums that may contain duplicates, return all possible subsets (the power set).
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 *
 * Example:
 *
 * Input: nums = [1,2,2]
 * Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
 */
public class SubsetsII {
    // Pre-requisite: ******** Subsets ********
    /**
     * Approach 1: Using Backtracking (Optimized)
     * The idea is to use backtracking to explore all possible subsets of the array. We first sort the array so that
     * duplicate elements appear together. This allows us to easily skip over duplicates at the same recursion level
     * and avoid generating the same subset more than once.
     *
     * We use the same basic approach as in the Subsets problem. However, we skip over duplicates by continuing the
     * loop until we find a number that is different from the current number. This ensures that we don't generate the
     * same subset more than once. After we've skipped over the duplicates, we then call dfs for non-pick.
     *
     * Time Complexity: O(n * 2ⁿ), generating all subsets requires 2ⁿ recursive calls, and copying each subset of size
     * up to n takes O(n) time.
     * Auxiliary Space: O(n), recursion stack and temporary subset use at most n space at a time.
     */
    private void dfs(int idx, int[] nums, List<Integer> subset, List<List<Integer>> ans) {
        if (idx == nums.length) {
            ans.add(new ArrayList<>(subset));
            return;
        }
        // pick
        subset.add(nums[idx]); // add current element to subset
        dfs(idx+1, nums, subset, ans);
        subset.remove(subset.size()-1); // remove while backtract

        // skip duplicates
        while (idx+1 < nums.length && nums[idx] == nums[idx+1]) idx ++;
        // non-pick
        dfs(idx+1, nums, subset, ans);
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> ans = new ArrayList<>();
        // parameters: index, nums[], subset, ans
        dfs(0, nums, new ArrayList<>(), ans);

        return ans;
    }

    static void main() {
        var obj = new SubsetsII();

        int[] nums = {1, 2, 2};
        List<List<Integer>> subsets = obj.subsetsWithDup(nums);
        System.out.println(subsets);
    }
}
