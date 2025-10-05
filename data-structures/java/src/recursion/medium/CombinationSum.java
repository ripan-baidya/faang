package recursion.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ripan Baidya
 * @date 25/09/25
 *
 * Given an array of distinct integers candidates and a target integer target, return a list of all unique
 * combinations of candidates where the chosen numbers sum to target. You may return the combinations  in
 * any order. The same number may be chosen from candidates an unlimited number of times. Two combinations
 * are unique if the frequency of at least one of the chosen numbers is different. The test cases are
 * generated such that the number of unique combinations that sum up to target is less than 150 combinations
 * for the given input.
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
     * Approach: Backtracking
     * The idea is to explore all possible combinations of candidates array. At each step, we have two choices:
     *  1. Pick the current element and move forward.
     *  2. Skip (don’t pick) the current element and move forward.
     *
     * We stop the recursion when we either reach the length of the candidates array or the current sum exceeds
     * the target. If we find a valid combination (where the sum of the elements in the combination is equal to
     * the target), we add it to the 'ans' list. We use backtracking to remove the last element from the 'path'
     * and explore other possibilities when we exceed the target or reach the end of the candidates array.
     *
     * Time Complexity: O(2 t/m)
     * Space Complexity: O(t/m), where t is the target and m is the minimum value in the candidates array.
     */
    private void dfs(int idx, int[] candidates, int target, int currentSum, List<Integer> path,
                     List<List<Integer>> ans) {
        // Base Case 1: Whenever we found target we would add it to the 'ans' list and return.
        if (currentSum == target) {
            ans.add(new ArrayList<>(path));
            return;
        }
        // Base Case 2: When we reach the length or currentSum exceeds target we will return
        if (idx == candidates.length || currentSum > target) return;

        path.add(candidates[idx]);
        dfs(idx, candidates, target, target+candidates[idx], path, ans);
        path.removeLast(); // remove while backtrack

        // check for next index
        dfs(idx+1, candidates, target, currentSum, path, ans);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();

        // parameters: idx, candidates, target, currentSum, path, ans
        dfs(0, candidates, target, 0, new ArrayList<>(), ans);
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
