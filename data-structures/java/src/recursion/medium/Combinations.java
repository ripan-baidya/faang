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
 * Explanation: There are 4 choose 2 = 6 total combinations.
 * Note that combinations are unordered, i.e., [1,2] and [2,1] are considered to be the same combination.
 */
public class Combinations {
    private void dfs(int start, int n, int k,
                     List<Integer> list, List<List<Integer>> ans) {
        if (list.size() == k) {
            ans.add(new ArrayList<>(list));
            return;
        }

        // iterate: start ... n
        for (int i = start; i <= n; i ++) {
            list.add(i);
            dfs(i+1, n, k, list, ans);
            list.remove(list.size()-1);
        }
    }
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
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
