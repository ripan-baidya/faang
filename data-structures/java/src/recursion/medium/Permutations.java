package recursion.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Ripan Baidya
 * @date 26/09/25
 *
 * Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
 *
 * Example:
 * Input: nums = [1,2,3]
 * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 */
public class Permutations {
    // ************ Better Approach ************
    /**
     * Approach 1: Backtracking
     * Use backtracking to build permutations incrementally. Maintain a used array to track which elements are already in
     * the current permutation. At each step, choose an unused element, recurse, and backtrack by removing the element and
     * marking it unused.
     *
     * Time Complexity: O(n * n!), where n is the length of the input array. There are n! permutations, and each permutation
     * requires O(n) time to build.
     * Space Complexity: O(n), where n is the length of the input array. The space is used for the recursion stack and the
     * used array. we could reduce the space required for "used" array.
     */
    /**
    private void backtrack(int[] nums, List<Integer> current, List<List<Integer>> result, boolean[] used) {
        // if current permutation is complete, add it to result
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i = 0; i < nums.length; i ++) {
            if (used[i] == false) {
                used[i] = true; // mark element as used
                current.add(nums[i]); // choose element
                backtrack(nums, current, result, used);
                current.remove(current.size()-1); // undo choice while backtract
                used[i] = false; // unmark element
            }
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>(); // permutations
        boolean[] used = new boolean[nums.length]; // track used element

        backtrack(nums, new ArrayList<>(), result, used);
        return result;
    }
    */


    // ******************** Optimized Solution ********************
    /**
     * The idea is to fix one element at a time and recursively generate permutations for the rest. At each step,
     * we swap the current element with another, explore further recursively, and then backtrack by swapping back.
     *
     * We simply start at the first index, swap it with each possible choice, and recurse for the next index. After
     * each recursive call, we backtrack by swapping back, so the array is restored for the next possibility.
     * Repeating this until the end ensures every permutation is covered exactly once.
     *
     * Time Complexity: O(n * n!), where n is the length of the input array. There are n! permutations, and each permutation
     * requires O(n) time to build.
     * Space Complexity: O(n), where n is the length of the input array. The space is used for the recursion stack.
     */
    // swap elements in array
    private void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void backtrack(int idx, int[] nums, List<List<Integer>> ans) {
        // Base Case:
        // Whenever we reach the end of the array, we add the current permutation to the result and return
        if (idx == nums.length) {
            // current permutation
            List<Integer> perm = new ArrayList<>();
            for (int num : nums) {
                perm.add(num);
            }
            ans.add(perm);
            return;
        }

        // Explore all possible choices
        for (int i = idx; i < nums.length; i ++) {
            swap(idx, i, nums); // swap
            backtrack(idx+1, nums, ans); // recursive call
            swap(idx, i, nums); // backtrack
        }
    }
    // function to get all permutations
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>(); // all permutations
        backtrack(0, nums, ans);
        return ans;
    }


    static void main() {
        var obj = new Permutations();
        int[] nums = {1, 2, 3};

        List<List<Integer>> permutation = obj.permute(nums);
        System.out.println(permutation);
    }
}
