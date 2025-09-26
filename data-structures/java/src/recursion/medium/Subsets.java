package recursion.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Ripan Baidya
 * @date 24/09/25
 *
 * Given an integer array nums of unique elements, return all possible subsets (the power set).
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 *
 * Example 1:
 * Input: nums = [1,2,3]
 * Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 */
public class Subsets {
    /**
     * Whenever a problem asks us to generate all possible combinations or subsets, recursion is
     * usually the go-to approach. One common technique is the "pick / not-pick" (or "include /
     * exclude") strategy.
     *
     * At each step, we have two choices:
     *  1. Pick the current element and move forward.
     *  2. Skip (don’t pick) the current element and move forward.
     *
     * Once we reach the base case (when the index goes past the last element), we’ve formed one
     * complete subset. At that point, we add it to our answer list.
     *
     * Important: after we "pick" an element, we need to backtrack by removing it before exploring
     * the "not-pick" case. This ensures the element doesn’t incorrectly carry over into the next
     * subset. By repeating this process for all elements, we eventually generate every possible
     * subset of the given array.
     */
    /**
     * Time Complexity: O(N * 2^N), 2^n is for all the subsets, and for each subset to store in the
     * array we crete a list that would take another 'n' at the worst case.
     * Space Complexity: O(N * 2^N), s^n subsets will generate and for each subset 'n' can be the
     * length at the worst case. recursive stack space is O(n).
     */
    public void dfs(int idx, int[] nums, List<Integer> list,
                       List<List<Integer>> ans) {
        // Base Case:
        if (idx == nums.length) {
            ans.add(new ArrayList<>(list));
            return;
        }
        // Add the current element to the list, since we are picking the element
        list.add(nums[idx]);
        dfs(idx+1, nums, list, ans); // pick
        list.remove(list.size()-1); // remove picked element while backtracking
        dfs(idx+1, nums, list, ans); // non-pick
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        // parameters: index, nums, list, ans
        dfs(0, nums, new ArrayList<>(), ans);
        return ans;
    }

    static void main() {
        var obj = new Subsets();

        int[] nums = {1, 2, 3};
        List<List<Integer>> allSubsets = obj.subsets(nums);

        allSubsets.forEach(System.out::println);
    }
}
