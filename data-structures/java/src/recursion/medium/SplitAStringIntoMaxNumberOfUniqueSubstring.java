package recursion.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Ripan Baidya
 * @date 06/11/25
 * 
 * Given a string s, return the maximum number of unique substrings that the given string can be split into.
 * You can split string s into any list of non-empty substrings, where the concatenation of the substrings forms the
 * original string. However, you must split the substrings such that all of them are unique.
 * A substring is a contiguous sequence of characters within a string.
 *
 * Example:
 *
 * Input: s = "ababccc"
 * Output: 5
 * Explanation: One way to split maximally is ['a', 'b', 'ab', 'c', 'cc'].
 * Splitting like ['a', 'b', 'a', 'b', 'c', 'cc'] is not valid as you have 'a' and 'b' multiple times.
 */
public class SplitAStringIntoMaxNumberOfUniqueSubstring {

    // *************** Approach 1: Using Set  ***************
    /**
     * Using backtracking to generate all possible substrings and keep track of the maximum number of unique
     * substrings.
     *
     * <p>
     * Time complexity: O(n * 2^n)
     * Space Complexity: O(n)
     *
     * @param s a string
     * @return max number of unique substrings
     */
    public int maxUniqueSplit(String s) {
        // set to store unique substrings
        Set<String> hs = new HashSet<>();
        // result
        int[] mxCount = new int[1];

        dfs(s, 0, mxCount, hs);
        return mxCount[0];
    }

    // helper function to perform dfs
    private void dfs(String s, int pos, int[] mxCount, Set<String> hs) {
        if (pos == s.length()) {
            mxCount[0] = Math.max(mxCount[0], hs.size());
            return;
        }

        StringBuilder sub = new StringBuilder();
        for (int i = pos; i < s.length(); i++) {
            sub.append(s.charAt(i));
            String current = sub.toString();
            if (!hs.contains(current)) {
                hs.add(current);
                dfs(s, i + 1, mxCount, hs);
                hs.remove(current);
            }
        }
    }

    // main
    static void main() {
        var obj = new SplitAStringIntoMaxNumberOfUniqueSubstring();

        String s = "ababccc";
        int result = obj.maxUniqueSplit(s);

        System.out.println("Maximum unique substring: " + result);
    }
}
