package array.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
 * Given an integer array nums, return true if any value appears at least twice in the array,
 * and return false if every element is distinct.
 *
 * Example:
 *
 * Input: nums = [1,2,3,1]
 * Output: true
 * Explanation: The element 1 occurs at the indices 0 and 3.
 *
 * @author Ripan Baidya
 * @date 02/01/26
 */
public class ContainsDuplicate {

    /*
     * Brute Force: Using helper method
     * This approach checks all possible pair of elements in the array.
     *
     * Time Complexity: O(n^2)
     * Space Complexity: O(1)
     */
    private boolean containsDuplicate(int[] nums) {
        for (int i = 1; i < nums.length; i ++) {
            if (!isFound(i, nums)) {
                return true;
            }
        }
        return false;
    }
    // Helper method to check if an element exists in the array
    private boolean isFound(int idx, int[] nums) {
        for (int i = 0; i < nums.length; i ++) {
            if (i != idx && nums[i] == nums[idx]) {
                return true;
            }
        }
        return false;
    }

    /*
     * Better Approach: Using Hashing or Set
     * Store elements in a set and check if the element is already present in the set.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    private boolean containsDuplicate2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            }
            set.add(num);
        }
        return false;
    }

    // Main
    public static void main(String[] args) {
        var obj = new ContainsDuplicate();

        int[] nums = {1, 2, 3, 1};
        int[] nums2 = {1, 2, 3, 4};

        System.out.println(obj.containsDuplicate(nums));    // true
        System.out.println(obj.containsDuplicate2(nums2));  // false
    }
}
