package recursion.medium;

import java.util.*;
/**
 * @author Ripan Baidya
 * @date 05/10/25
 * 
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number
 * could represent. Return the answer in any order.
 * A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map
 * to any letters.
 *
 * Example:
 * Input: digits = "23"
 * Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
 */
public class LetterCombinationsOfAPhoneNumber {
    /**
     * Approach 1: ********** Backtracking **********
     * This solution uses backtracking to generate all possible letter combinations for a given digit string (like a
     * phone keypad). At each recursive call, we map the current digit to its corresponding letters and try adding
     * each one to the current combination. Once the length of the current string matches the input digits, we add it
     * to the result. Backtracking ensures all possible letter sequences are explored efficiently.
     *
     * Time Complexity: O(4ⁿ * n)
     * Space Complexity: O(n)
     */
    private void backtrack(int idx, String digits, StringBuilder curStr,
                           String[] digitToChar, List<String> ans) {
        // Base Case: when the length of the current string equals the length of digits
        // we have found a valid combination, add it to the answer list and return
        if (curStr.length() == digits.length()) {
            ans.add(curStr.toString());
            return;
        }

        // get the characters for the current digit, i.e: 2 = "abc"
        String chars = digitToChar[digits.charAt(idx)-'0'];

        // explore all possible choices
        for (char c : chars.toCharArray()) {
            curStr.append(c);
            backtrack(idx+1, digits, curStr, digitToChar, ans);
            curStr.deleteCharAt(curStr.length()-1);
        }
    }
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits.isEmpty()) return ans;

        String[] digitToChar = {
                "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
        };

        backtrack(0, digits, new StringBuilder(), digitToChar, ans);
        return ans;
    }

    static void main() {
        var obj = new LetterCombinationsOfAPhoneNumber();

        String digits = "234";
        List<String> ans = obj.letterCombinations(digits);
        System.out.println(ans);
    }
}
