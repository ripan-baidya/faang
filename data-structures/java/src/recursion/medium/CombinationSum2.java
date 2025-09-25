package recursion.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Ripan Baidya
 * @date 25/09/25
 *
 * Given a collection of candidate numbers (candidates) and a target number (target), find all
 * unique combinations in candidates where the candidate numbers sum to target.
 * Each number in candidates may only be used once in the combination.
 * Note: The solution set must not contain duplicate combinations.
 *
 * Example:
 *
 * Input: candidates = [10,1,2,7,6,1,5], target = 8
 * Output:
 * [ [1,1,6], [1,2,5], [1,7], [2,6] ]
 */
public class CombinationSum2 {
    /**
     * Approach:
     *
     * 1. Sort the array to handle duplicates easily.
     * 2. Use DFS / backtracking to explore all combinations:
     *  - At each step, pick the current number and recurse with reduced target.
     *  - Backtrack by removing the number after recursion.
     *  - Skip duplicates to avoid repeating combinations.
     * 3. Stop recursion if target becomes 0 (valid combination) or number exceeds target / end of array.
     *
     * Time Complexity: O(2^N * n)
     * Space Complexity: O(2^N * n)
     */
    private void dfs(int i, int[] candidates, int target, List<Integer> cur, List<List<Integer>> ans) {
        // Base case: if the remaining target is 0, we found a valid combination
        if (target == 0) {
            // add a copy of current combination
            ans.add(new ArrayList<>(cur));
            return;
        }

        // If we reach the end of the array or the current candidate is greater
        // than the target, stop
        if (i == candidates.length || candidates[i] > target) {
            return;
        }

        // Option 1: pick the current element
        // add current candidate to the combination
        cur.add(candidates[i]);
        // move to next element
        dfs(i + 1, candidates, target - candidates[i], cur, ans);
        // backtrack: remove the last element added
        cur.remove(cur.size() - 1);

        // Option 2: skip duplicates
        // Move 'i' forward until we find a different element to avoid repeating
        // the same combination
        while (i + 1 < candidates.length && candidates[i] == candidates[i + 1]) {
            i += 1;
        }

        // Skip the current element and move to the next one
        dfs(i + 1, candidates, target, cur, ans);
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // sort to handle duplicates easily
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        // start DFS from index 0
        dfs(0, candidates, target, new ArrayList<>(), ans);
        return ans;
    }

    static void main() {
        var obj = new CombinationSum2();

        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;
        List<List<Integer>> result = obj.combinationSum2(candidates, target);

        System.out.println(result);
    }
}
