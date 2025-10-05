package recursion.medium;

import java.util.*;
/**
 * @author Ripan Baidya
 * @date 05/10/25
 *
 * Find all valid combinations of k numbers that sum up to n such that the following conditions are true:
 * - Only numbers 1 through 9 are used.
 * - Each number is used at most once.
 * Return a list of all possible valid combinations. The list must not contain the same combination twice,
 * and the combinations may be returned in any order.
 *
 * Example:
 * Input: k = 3, n = 7
 * Output: [[1,2,4]]
 * Explanation: 1 + 2 + 4 = 7, There are no other valid combinations.
 */
public class CombinationSumIII {
    /**
     * Approach 1: ********* Backtracking *********
     * We use backtracking to find all unique combinations of numbers 1–9 that sum to n using exactly k numbers.
     * Starting from a given number, we iteratively choose the next candidate, add it to the current path,  and
     * explore further with an updated sum. If the sum equals n and the path size is k, we record the combination.
     * Backtracking ensures we explore all valid combinations while pruning paths that exceed the target or length
     * limit.
     *
     * Time Complexity: O(C(9, k) × k)
     * Space Complexity: O(k)
     */
    private void dfs(int start, int end, int k, int n, int curSum,
                     List<Integer> path, List<List<Integer>> ans) {
        // base case: Combination found
        if (curSum == n && path.size() == k) {
            ans.add(new ArrayList<>(path));
            return;
        }

        // base case: exceeds the target or size of the path exceeds k
        if (path.size() > k || curSum > n) return;

        for (int i = start; i <= end; i ++) {
            path.add(i);
            dfs(i+1, end, k, n, curSum+i, path, ans);
            path.remove(path.size()-1);
        }
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();

        // start, end, k, n, curSum, path, ans
        dfs(1, 9, k, n, 0, new ArrayList<>(), ans);
        return ans;
    }

    static void main() {
        var obj = new CombinationSumIII();

        int k = 3;
        int n = 7;
        List<List<Integer>> ans = obj.combinationSum3(k, n);
        System.out.println("ans = " + ans);
    }
}
