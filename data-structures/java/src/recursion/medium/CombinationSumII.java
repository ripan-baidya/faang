package recursion.medium;

import javax.xml.xpath.XPath;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Ripan Baidya
 * @date 25/09/25
 *
 * Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations
 * in candidates where the candidate numbers sum to target. Each number in candidates may only be used once in the
 * combination.
 * Note: The solution set must not contain duplicate combinations.
 *
 * Example:
 *
 * Input: candidates = [10,1,2,7,6,1,5], target = 8
 * Output:[[1,1,6], [1,2,5], [1,7], [2,6]]
 */
public class CombinationSumII {
    /**
     * Approach: Backtracking
     * At each step, we can either include the current number or skip it to explore other possibilities.
     * Before recursion, we sort the array so we can easily skip duplicate elements and avoid repeating
     * the same combinations. After exploring one choice, we backtrack by removing the last added number
     * to restore the previous state.
     *
     * Time Complexity: O(2^N * n)
     * Space Complexity: O(2^N * n)
     */
    private void dfs(int idx, int[] candidates, int target, int currentSum,
                     List<Integer> path, List<List<Integer>> ans){
        // Base Case:
        if (currentSum == target) {
            ans.add(new ArrayList<>(path));
            return;
        }
        // Base Case 2:
        if (idx == candidates.length || currentSum > target) return;


        path.add(candidates[idx]);
        dfs(idx, candidates, target, target+candidates[idx], path, ans);
        path.removeLast(); // backtrack

        // skip duplicates
        while (idx + 1 < candidates.length && candidates[idx] == candidates[idx + 1]) idx ++;

        // Skip the current element and move to the next one
        dfs(idx+1, candidates, target, currentSum, path, ans);
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates); // sort to handle duplicates
        List<List<Integer>> ans = new ArrayList<>();

        // parameters: idx, candidates, target, currentSum, path, ans
        dfs(0, candidates, target, 0, new ArrayList<>(), ans);
        return ans;
    }

    static void main() {
        var obj = new CombinationSumII();

        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;
        List<List<Integer>> result = obj.combinationSum2(candidates, target);

        System.out.println(result);
    }
}
