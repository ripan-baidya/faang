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
    // Pre-requisite: ******** Permutations ********

    /**
     * Approach 1: Backtracking
     * We did the same as we did in Permutations, but with a small modification. We sort the array first and skip
     * the choice if it is same as previous and previous is not used. This is to avoid duplicates.
     *
     * Time Complexity: O(n * n!),  n is the length of the array. There are n! permutations, and each permutation
     * requires O(n) time to build.
     * Space Complexity: O(n * n!), where n is the length of the input array. The space is used for the recursion stack
     */
    /*
    private void backtrack(int[] nums, List<Integer> perm, List<List<Integer>> result, boolean[] used) {
        // Base case
        if (perm.size() == nums.length) {
            result.add(new ArrayList<>(perm));
            return;
        }

        // explore all possible choices
        for (int i = 0; i < nums.length; i ++) {
            // we skip the choice if it is same as previous and previous is not used
            // becuase, if previous were used, it means we have already considered it
            // and we could add the current element to the permutation.
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
    public List<List<Integer>> permuteUnique2(int[] nums) {
        Arrays.sort(nums); // make sure sort the arary
        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[nums.length];

        backtrack(nums, new ArrayList<>(), result, used);
        return result;
    }
    */


    /**
     * Approach 2: Using HashMap
     * Use a HashMap to store element frequencies and apply DFS with backtracking. At each step, pick an element with
     * a positive count, add it to the current permutation, decrement its count, recurse, then backtrack by restoring
     * the count. This ensures all unique permutations are generated without duplicates.
     *
     * Time complexity: O(n! * n)
     * Space complexity: O(n! * n) for the output list.
     */
    private void dfs(int len, Map<Integer, Integer> map, List<Integer> perms,
                     List<List<Integer>> result) {
        // Base Case
        if (perms.size() == len) {
            result.add(new ArrayList<>(perms));
            return;
        }

        for (int key : map.keySet()) {
            int count = map.get(key); // occurrence of the element
            if (count == 0) continue;
            else {
                map.put(key, map.get(key)-1); // reduce count
                perms.add(key); // add current element to the permutation
                dfs(len, map, perms, result); // recursive call

                // backtrack
                perms.remove(perms.size()-1); // remove current element
                map.put(key, map.get(key)+1); // increase count
            }
        }
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        // build frequency map for all elements
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // parameters: len, map, perms, result
        dfs(nums.length, map, new ArrayList<>(), result);
        return result;
    }

    static void main() {
        var obj = new PermutationsII();

        int[] nums = {1, 1, 2};
        List<List<Integer>> result = obj.permuteUnique(nums);
        System.out.println(result);
    }
}
