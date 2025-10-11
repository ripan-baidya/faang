package recursion.medium;

/**
 * @author Ripan Baidya
 * @date 11/10/25
 *
 * You are given a 0-indexed string pattern of length n consisting of the characters 'I' meaning increasing and
 * 'D' meaning decreasing. A 0-indexed string num of length n + 1 is created using the following conditions:
 * - num consists of the digits '1' to '9', where each digit is used at most once.
 * - If pattern[i] == 'I', then num[i] < num[i + 1].
 * - If pattern[i] == 'D', then num[i] > num[i + 1].
 * Return the lexicographically smallest possible string num that meets the conditions.
 *
 * Example:
 *
 * Input: pattern = "IIIDIDDD"
 * Output: "123549876"
 * Explanation:
 * At indices 0, 1, 2, and 4 we must have that num[i] < num[i+1].
 * At indices 3, 5, 6, and 7 we must have that num[i] > num[i+1].
 * Some possible values of num are "245639871", "135749862", and "123849765".
 * It can be proven that "123549876" is the smallest possible num that meets the conditions.
 * Note that "123414321" is not possible because the digit '1' is used more than once.
 */
public class ConstructSmallestNumberFromDIString {
    /**
     * Approach: ******** Backtracking ********
     * We need to construct the smallest numerical string (using digits 1–9 without repetition) that follows the
     * given 'I' (increasing) and 'D' (decreasing) pattern.
     * The key idea is, We use backtracking (DFS) to try building all possible valid numbers digit by digit.  At
     * each position, we check whether adding the next digit maintains the pattern rule.
     *
     * Algorithm:
     * 1. Use DFS to build the smallest number following the 'I' (increase) / 'D' (decrease) pattern.
     * 2. Base case: when curr.length() == pattern.length() + 1, return the number.
     * 3. For each digit 1–9:
     *  - Skip if already used.
     *  - If not the first digit, ensure pattern rule holds: 'I' → prev < curr, 'D' → prev > curr.
     *  - Choose the digit, recurse for next position.
     *  - If recursion succeeds, return the result; else backtrack.
     * 4. If no valid sequence found, return null.
     *
     * Time Complexity: O(9!)
     * Space Complexity: O(n)
     */

    // DFS helper to construct the smallest number matching the pattern
    private String dfs(int pos, String pattern, StringBuilder curr, boolean[] used) {
        // Base case: all digits placed
        if (pos == pattern.length() + 1) {
            return curr.toString();
        }

        // Try all digits 1-9
        for (int d = 1; d <= 9; d++) {
            if (used[d]) continue;

            int len = curr.length();
            if (len > 0) {
                char lastPattern = pattern.charAt(len - 1);
                int prevDigit = curr.charAt(len - 1) - '0';

                // Check pattern constraints
                // 'I' -> previous < current
                // 'D' -> previous > current
                if ((lastPattern == 'I' && prevDigit >= d) || (lastPattern == 'D' && prevDigit <= d))
                    continue;
            }

            // Choose digit
            used[d] = true;
            curr.append(d);

            // Recurse
            String res = dfs(pos + 1, pattern, curr, used);
            if (res != null) return res;

            // Backtrack
            used[d] = false;
            curr.deleteCharAt(curr.length() - 1);
        }

        // No valid number found
        return null;
    }

    // Entry function
    public String smallestNumber(String pattern) {
        // for tracking used digits 1-9
        boolean[] used = new boolean[10];
        return dfs(0, pattern, new StringBuilder(), used);
    }

    static void main() {
        var obj = new ConstructSmallestNumberFromDIString();

        String pattern = "IIIDIDDD";
        String result = obj.smallestNumber(pattern);
        System.out.println("Smallest DI String: " + result);
    }
}