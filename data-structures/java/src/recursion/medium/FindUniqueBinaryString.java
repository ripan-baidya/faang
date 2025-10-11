package recursion.medium;

import java.util.*;
/**
 * @author Ripan Baidya
 * @date 11/10/25
 *
 * Given an array of strings nums containing n unique binary strings each of length n, return a binary
 * string of length n that does not appear in nums. If there are multiple answers, you may return  any
 * of them.
 *
 * Example:
 * Input: nums = ["111","011","001"]
 * Output: "101"
 * Explanation: "101" does not appear in nums. "000", "010", "100", and "110" would also be correct.
 */
public class FindUniqueBinaryString {
    /**
     * Approach: ******** Backtracking ********
     * We use a set to keep track of strings we've seen so far. We try to build strings of length n
     * by adding '0' and '1' to the current string and make a recursive call. If we find  a string
     * that is not in the set, means it is unique, we return it.
     *
     * Time Complexity: O(2ⁿ) where n is the length of the strings
     * Space Complexity: O(n)
     */

    // DFS helper: builds binary strings and returns one not in the given set
    private String dfs(int n, StringBuilder curr, Set<String> seen) {
        // Base case: built a string of length n
        if (curr.length() == n) {
            String s = curr.toString();
            if (!seen.contains(s)) return s;
            return null;
        }

        // Try adding '0'
        curr.append('0');
        String res = dfs(n, curr, seen);
        if (res != null) return res;
        curr.deleteCharAt(curr.length() - 1); // backtrack

        // Try adding '1'
        curr.append('1');
        res = dfs(n, curr, seen);
        if (res != null) return res;
        curr.deleteCharAt(curr.length() - 1); // backtrack

        return null; // no unique string found
    }

    // Entry function
    public String findDifferentBinaryString(String[] nums) {
        Set<String> seen = new HashSet<>(Arrays.asList(nums));
        return dfs(nums.length, new StringBuilder(), seen);
    }

    static void main() {
        var obj = new FindUniqueBinaryString();

        String[] nums = {"111","011","001"};
        String result = obj.findDifferentBinaryString(nums);
        System.out.println(result);
    }
}
