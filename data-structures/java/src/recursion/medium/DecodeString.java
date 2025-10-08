package recursion.medium;

import java.util.*;
/**
 * @author Ripan Baidya
 * @date 07/10/25
 *
 * Given an encoded string, return its decoded string.
 * The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated
 * exactly k times. Note that k is guaranteed to be a positive integer.
 *
 * You may assume that the input string is always valid; there are no extra white spaces, square brackets are well
 * -formed, etc.Furthermore, you may assume that the original data does not contain any digits and that digits are
 * only for those repeat numbers, k. For example, there will not be input like 3a or 2[4].
 * The test cases are generated so that the length of the output will never exceed 105.
 *
 * Example 1:
 * Input: s = "3[a]2[bc]"
 * Output: "aaabcbc"
 *
 * Example 2:
 * Input: s = "3[a2[c]]"
 * Output: "accaccacc"
 */
public class DecodeString {
    /**
     * Approach: ***** Stack *****
     * We use a stack-based approach. We iterate over the string and handle two cases: either we encounter a closing
     * bracket (']') or other characters. Since the problem guarantees that the string is always valid, we can ensure
     * that for every '[' there is a corresponding closing bracket.
     * Whenever we encounter any other character, other than ']', we push it onto the stack. Otherwise, we will perform
     * some operations:
     *
     * 1. We retrieve the string inside the brackets.
     * 2. We remove the '[' bracket from the top of the stack.
     * 3. We determine the number of times the string inside the brackets needs to be repeated. If there is no number,
     *    it means it is 1.
     * 4. We build a string by repeating the string inside the brackets the determined number of times and push it into
     *    the stack.
     * 5. Finally, we construct the decoded string by removing all the elements from the stack and return it.
     *
     * Time Complexity: O(n * m), where 'n' is the length of the string and 'm' is the maximum number of repeatitions(k)
     * for any encoded substring.
     * Space Complexity: O(n), du to stack space and string builder.
     */
    public String decodeString(String encodedString) {
        Stack<String> stk = new Stack<>();

        for (char ch : encodedString.toCharArray()) {
            // whenever we encounter an closing ']' bracket, we need to do someoperation
            if (ch == ']') {
                // step 1: get the string inside the brackets
                StringBuilder decodedSubstring = new StringBuilder();
                while (!stk.peek().equals("[")) {
                    decodedSubstring.insert(0, stk.pop());
                }
                stk.pop(); // make sure remove the '['

                // Step 2: get the number before '['
                StringBuilder digitBuilder = new StringBuilder();
                while (!stk.isEmpty() && stk.peek().matches("\\d")) {
                    digitBuilder.insert(0, stk.pop());
                }

                int repeatCount = digitBuilder.length() == 0 ? 1 : Integer.parseInt(digitBuilder.toString());

                // Step 3: repeat the substring and push back
                String repeatedSubstring = decodedSubstring.toString().repeat(repeatCount);
                stk.push(repeatedSubstring);

            } else {
                // whenever we encounter any other character, other than ']', we will push it into the stack.
                stk.push(String.valueOf(ch));
            }
        }

        // finally, we will get the decoded string
        StringBuilder decodedString = new StringBuilder();
        while (!stk.isEmpty()) {
            decodedString.insert(0, stk.pop());
        }

        return decodedString.toString();
    }

    static void main() {
        var obj = new DecodeString();

        String s = "3[a]2[bc]";
        String decodedString = obj.decodeString(s);
        System.out.println(decodedString);
    }
}
