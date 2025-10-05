package recursion.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ripan Baidya
 * @date 26/09/25
 *
 * Given two integers n and k, return all possible combinations of k numbers chosen from the range [1, n].
 * You may return the answer in any order.
 *
 * Example:
 * Input: n = 4, k = 2
 * Output: [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
 */
public class Combinations {
    /**
     * Approach: Backtracking
     * This problem can be solved using backtracking. The idea is to start from each element and try to form
     * all possible combinations of size 'k' by selecting one element from the remaining elements. We keep
     * track of the current combination by adding elements to the 'list' and backtrack when the size of the list
     * reaches 'k'. The base case is when the size of the list is equal to 'k', we add a copy of the list to
     * the answer.
     *
     * Time Complexity: O(n * 2ⁿ)
     * Space Complexity: O(n)
     */
    private void dfs(int start, int n, int k, List<Integer> list,
                     List<List<Integer>> ans) {
        // Base Case
        if (list.size() == k) {
            ans.add(new ArrayList<>(list));
            return;
        }

        // for each element we will start iterating from start to n
        for (int i = start; i <= n; i ++) {
            list.add(i);
            dfs(i+1, n, k, list, ans); // recursive call
            list.removeLast(); // backtrack
        }
    }
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();

        // parameters: start, n, k, list, ans
        dfs(1, n, k, new ArrayList<>(), ans);
        return ans;
    }

    static void main() {
        var obj = new Combinations();
        int n = 4, k = 2;
        List<List<Integer>> combinations = obj.combine(n, k);

        System.out.println(combinations);
    }
}
