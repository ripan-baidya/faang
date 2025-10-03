package recursion.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Ripan Baidya
 * @date 24/09/25
 *
 * Given an integer array nums of unique elements, return all possible subsets (the power set). The solution
 * set must not contain duplicate subsets. Return the solution in any order.
 *
 * Example:
 * Input: nums = [1,2,3]
 * Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 */
public class Subsets {
    /**
     * Whenever a problem asks us to generate all possible combinations or subsets, recursion is usually the
     * go-to approach. One common technique is the "pick / not-pick" (or "include / exclude") strategy.
     *
     * At each step, we have two choices:
     *  1. Pick the current element and move forward.
     *  2. Skip (don’t pick) the current element and move forward.
     *
     * Once we reach the base case (when the index goes past the last element), we’ve formed one complete subset.
     * At that point, we add it to our answer list.
     *
     * Important: after we "pick" an element, we need to backtrack by removing it before exploring the "not-pick" case.
     * This ensures the element doesn’t incorrectly carry over into the next subset. By repeating this process for all
     * elements, we eventually generate every possible subset of the given array.
     */
    /**
     * Time Complexity: O(n * 2ⁿ), generating all subsets requires 2ⁿ recursive calls, and copying each subset of size
     * up to n takes O(n) time.
     * Auxiliary Space: O(n), recursion stack and temporary subset use at most n space at a time.
     */
    private void dfs(int idx, int[] nums, List<Integer> subset,
                    List<List<Integer>> ans) {
        // Base Case:
        if (idx == nums.length) {
            ans.add(new ArrayList<>(subset));
            return;
        }
        // Add the current element to the list, since we are picking the element
        subset.add(nums[idx]);
        dfs(idx+1, nums, subset, ans); // pick
        subset.remove(subset.size()-1); // remove picked element while backtracking
        dfs(idx+1, nums, subset, ans); // non-pick
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();

        // parameters: index, nums[], subset, ans
        dfs(0, nums, subset, ans);
        return ans;
    }

    static void main() {
        var obj = new Subsets();

        int[] nums = {1, 2, 3};
        List<List<Integer>> allSubsets = obj.subsets(nums);

        allSubsets.forEach(System.out::println);
    }
}
