package recursion.medium;

/**
 * @author Ripan Baidya
 * @date 11/10/25
 *
 * You are given a string s that consists of only digits.
 * Check if we can split s into two or more non-empty substrings such that: The numerical values of the substrings
 * are in strictly descending order. The difference between the numerical values of every two adjacent  substrings
 * is exactly 1. Return true if such a split is possible, otherwise return false.
 * A substring is a contiguous sequence of characters in a string.
 *
 * Example 1:
 * Input: s = "1234"
 * Output: false
 * Explanation: There is no valid way to split s.
 *
 * Example 2:
 * Input: s = "050043"
 * Output: true
 */
public class SplittingStringIntoDescendingConsecutiveValues {
    /**
     * Approach: ******** Backtracking ********
     * We use backtracking to explore all possible ways to split the string into descending consecutive numbers.
     * At each recursive step, we track:
     *  - the previous number (`prev`)
     *  - the number of parts formed so far (`parts`)
     * For each position, we try to form the next number by extending digits. If it's the first number, or if the
     * current number is exactly one less than the previous number, we recurse further.
     * When we reach the end of the string, if at least two valid parts have been formed, we return true.
     *
     * Time Complexity: O(2ⁿ) where n is the length of the string.
     * Space Complexity: O(n) due to the recursion stack.
     */

    // DFS helper: checks if the string can be split into descending consecutive numbers
    private boolean dfs(int pos, String str, long prev, int parts) {
        // Base case: reached end of string
        if (pos >= str.length()) {
            return parts >= 2;
        }

        long val = 0L;
        // Try forming numbers starting from current position
        for (int i = pos; i < str.length(); i++) {
            val = val * 10 + (str.charAt(i) - '0');

            // If it's the first number or difference is exactly 1
            if (prev == -1 || (prev - val) == 1) {
                if (dfs(i + 1, str, val, parts + 1))
                    return true;
            }
        }

        // No valid split found
        return false;
    }

    // Entry point
    public boolean splitString(String s) {
        return dfs(0, s, -1, 0);
    }

    static void main() {
        var obj = new SplittingStringIntoDescendingConsecutiveValues();

        String s = "050043";
        boolean result = obj.splitString(s);
        System.out.println(result);
    }
}
