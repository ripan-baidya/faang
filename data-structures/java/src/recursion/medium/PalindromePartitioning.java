package recursion.medium;

import java.util.*;
/**
 * @author Ripan Baidya
 * @date 05/10/25
 * 
 * Given a string s, partition s such that every substring of the partition is a palindrome. Return all possible
 * palindrome partitioning of s.
 *
 * Example:
 * Input: s = "aab"
 * Output: [["a","a","b"],["aa","b"]]
 */
public class PalindromePartitioning {
    /**
     * Approach 1: ************* Backtracking *************
     * This solution uses backtracking to generate all possible palindrome partitions of a string. At each index,
     * we try every substring starting there, and whenever it’s a palindrome, we include it in the current  path
     * and recursively explore further. When we reach the end of the string, the current path represents one valid
     * partition, the Backtracking ensures all combinations are explored by undoing the last choice after each
     * recursive call.
     *
     * Time Complexity: O(n² * 2ⁿ)
     * Space Complexity: O(n * 2ⁿ)
     */
    // helper function to check palindrome
    private boolean isPalindrome(String s, int start, int end) {
        while (start <= end) {
            if (s.charAt(start ++) != s.charAt(end --))
                return false;
        }
        return true;
    }

    // dfs to find all possible partitions
    private void dfs(int idx, String s, List<String> li, List<List<String>> ans) {
        // Base Case:
        if (idx >= s.length()) {
            ans.add(new ArrayList<>(li));
            return;
        }

        for (int j = idx; j < s.length(); j ++) {
            // whenever we find a substring that is palindrome we add it to the list and
            // make a recursive call for the next substring
            if (isPalindrome(s, idx, j)) {
                li.add(s.substring(idx, j+1));
                dfs(j+1, s, li, ans); // recursive call
                li.removeLast(); // remove while backtrack
            }
        }
    }
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();

        // parameter: index, s, list, ans
        dfs(0, s, new ArrayList<>(), ans);
        return ans;
    }

    static void main() {
        var obj = new PalindromePartitioning();

        String s = "aab";
        List<List<String>> ans = obj.partition(s);
        System.out.println(ans);
    }
}
