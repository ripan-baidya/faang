package recursion.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ripan Baidya
 * @date 25/09/25
 *
 * Given an array of distinct integers candidates and a target integer target, return a list of
 * all unique combinations of candidates where the chosen numbers sum to target. You may return
 * the combinations in any order.
 * The same number may be chosen from candidates an unlimited number of times. Two combinations
 * are unique if the frequency of at least one of the chosen numbers is different.
 * The test cases are generated such that the number of unique combinations that sum up to target
 * is less than 150 combinations for the given input.
 *
 * Example:
 * Input: candidates = [2,3,6,7], target = 7
 * Output: [[2,2,3],[7]]
 * Explanation:
 * 2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
 * 7 is a candidate, and 7 = 7.
 * These are the only two combinations.
 */
public class CombinationSum {
    /**
     * Approach is very simple
     * 1. At every index, either pick the number (if ≤ target, and stay at same index since repeats
     * allowed) or skip it (move to next index).
     * 2. When target == 0, store the current path as a valid combination.
     * 3. Backtrack by removing the last picked number before exploring other choices.
     *
     * Time Complexity: O(2^n * k)
     * Space Complexity: O(target/min(candidates)) + O(output size)
     */
    private void helper(int idx, int[] candidates, int target,
                        List<Integer> list, List<List<Integer>> ans) {
        // Base case
        // Whenever we found target we would add it to the 'ans' list and return.
        if (target == 0) {
            ans.add(new ArrayList<>(list));
            return;
        }
        // When we reach the length we will return
        if (idx == candidates.length) return;

        // pick current element if it doesn’t exceed target
        if (candidates[idx] <= target) {
            list.add(candidates[idx]);
            helper(idx, candidates, target - candidates[idx], list, ans);
            list.remove(list.size() - 1); // backtrack
        }

        // skip current element
        helper(idx + 1, candidates, target, list, ans);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(0, candidates, target, new ArrayList<>(), ans);
        return ans;
    }

    static void main() {
        var obj = new CombinationSum();

        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> result = obj.combinationSum(candidates, target);

        System.out.println(result);
    }
}
