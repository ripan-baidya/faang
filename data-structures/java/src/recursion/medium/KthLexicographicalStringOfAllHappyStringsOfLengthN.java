package recursion.medium;

/**
 * @author Ripan Baidya
 * @date 08/10/25
 *
 * A happy string is a string that:
 * - consists only of letters of the set ['a', 'b', 'c'].
 * - s[i] != s[i + 1] for all values of i from 1 to s.length - 1 (string is 1-indexed).
 *
 * For example, strings "abc", "ac", "b" and "abcbabcbcb" are all happy strings and strings "aa", "baa" and "ababbc"
 * are not happy strings.
 * Given two integers n and k, consider a list of all happy strings of length n sorted in lexicographical order.
 * Return the kth string of this list or return an empty string if there are less than k happy strings of length n.
 *
 * Example:
 *
 * Input: n = 1, k = 3
 * Output: "c"
 * Explanation: The list ["a", "b", "c"] contains all happy strings of length 1. The third string is "c".
 */
public class KthLexicographicalStringOfAllHappyStringsOfLengthN {
    /**
     * Approach: ******* Backtracking ********
     * The idea is we will build all happy strings of length n and will keep track of the count of happy strings
     * and will return the kth happy string of length n.
     *
     * @paramList: n, k, prevChar, lettersAllowed, curCombination, count, ans
     */
    private void dfs(int n, int k, char prevChar, String letters,
                     StringBuilder curComb, int[] count, String[] ans) {
        // base case: when the current combination length is equal to n,
        // means happy string of length n is found
        if (curComb.length() == n) {
            count[0]++; // count valid happy string

            // if the happy string count is also same as k
            // means, we found the kth happy string of length n
            if (count[0] == k) ans[0] = curComb.toString();
            return;
        }

        /**
         * We have allowed characters 'a', 'b', 'c', and we can't use the same character twice, so the idea
         * is to keep track of the character that we have already taken at the previous iteration and ignore
         * it at the current iteration. We will take the character that is not equal to the previous character
         * and add it to the current combination and make a recursive call. After the recursive call, we will
         * remove the character from the current combination.
         */
        for (int i = 0; i < 3; i++) {
            char curChar = letters.charAt(i);
            if (curChar != prevChar && ans[0].equals("")) {
                curComb.append(curChar);
                dfs(n, k, curChar, letters, curComb, count, ans);
                curComb.deleteCharAt(curComb.length() - 1);
            }
        }
    }

    public String getHappyString(int n, int k) {
        int[] count = new int[1];    // counter
        String[] ans = new String[]{""}; //  string container for ans

        // @params: n, k, prevChar, lettersAllowed, curCombination, count, ans
        dfs(n, k, '#', "abc", new StringBuilder(), count, ans);
        return ans[0];
    }
    static void main() {

    }
}
