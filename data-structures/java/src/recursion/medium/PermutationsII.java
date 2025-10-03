package recursion.medium;

import java.util.*;

/**
 * @author Ripan Baidya
 * @date 03/10/25
 * 
 * Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations
 * in any order.

 * Example:
 * Input: nums = [1,1,2]
 * Output: [[1,1,2], [1,2,1], [2,1,1]]
 */
public class PermutationsII {
    // Pre-requisite: Permutations
    /**
     * Approach: Backtracking
     * We did the same as we did in Permutations, but with a small modification. We sort the array first and skip
     * the choice if it is same as previous and previous is not used. This is to avoid duplicates.
     *
     * Time Complexity: O(n * n!),  n is the length of the array. There are n! permutations, and each permutation
     * requires O(n) time to build.
     * Space Complexity: O(n), where n is the length of the input array. The space is used for the recursion stack
     */
    private void backtrack(int[] nums, List<Integer> perm, List<List<Integer>> result, boolean[] used) {
        // base case
        // when we reach the end of the array, we add current permutation to the result
        if (perm.size() == nums.length) {
            result.add(new ArrayList<>(perm));
            return;
        }

        // explore all possible choices
        for (int i = 0; i < nums.length; i ++) {
            // since we sort the array, we skip the choice if it is same as previous and previous is not used
            if (i > 0 && nums[i] == nums[i-1] && !used[i-1]) continue;

            // if the current element is not used, we use it
            if (!used[i]) {
                used[i] = true; // mark it as used
                perm.add(nums[i]); // add it to the current permutation
                backtrack(nums, perm, result, used); // recursive call
                perm.remove(perm.size()-1); // remove it from the current permutation
                used[i] = false; // mark it as unused
            }
        }
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums); // make sure sort the arary
        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[nums.length];

        backtrack(nums, new ArrayList<>(), result, used);
        return result;
    }

    static void main() {
        var obj = new PermutationsII();

        int[] nums = {1, 1, 2};
        List<List<Integer>> result = obj.permuteUnique(nums);
        System.out.println(result);
    }
}
