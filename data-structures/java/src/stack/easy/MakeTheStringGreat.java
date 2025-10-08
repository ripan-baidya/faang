package stack.easy;

/**
 * @author Ripan Baidya
 * @date 07/10/25
 * 
 * Given a string s of lower and upper case English letters.
 * A good string is a string which doesn't have two adjacent characters s[i] and s[i + 1] where:
 * - 0 <= i <= s.length - 2
 * - s[i] is a lower-case letter and s[i + 1] is the same letter but in upper-case or vice versa.
 *
 * To make the string good, you can choose two adjacent characters that make the string bad and remove them.
 * You can keep doing this until the string becomes good.
 * Return the string after making it good. The answer is guaranteed to be unique under the given constraints
 * Notice that an empty string is also good.
 */
public class MakeTheStringGreat {
    /**
     * Approach: ********* Stack *********
     * Here we use stack based approach to solve this problem. we use StringBuilder as a stack, and use the
     * same process as we use in stack based approach to solve this problem.
     * Iterate through the input string.For each character, check if the top of the stack is the same as the
     * current character but in uppercase.If so, remove the top element from the stack. Otherwise, add  the
     * current character to the stack. The stack will contain the final, good string. Return the ans.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public String makeGood(String s) {
        StringBuilder ans = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (!ans.isEmpty() && Math.abs(ans.charAt(ans.length() - 1) - c) == 32) {
                ans.deleteCharAt(ans.length() - 1); // pop the "bad" pair
            }
            else {
                ans.append(c); // push
            }
        }
        return ans.toString();
    }

    static void main() {
        var obj = new MakeTheStringGreat();

        String s = "leEeetcode";
        String goodString = obj.makeGood(s);

        System.out.println(goodString);
    }
}
