package recursion.easy;

/**
 * @author Ripan Baidya
 * @date 24/09/25
 *
 * You are given a string s. Your task is to determine if the string is a palindrome. A string is
 * considered a palindrome if it reads the same forwards and backwards.
 *
 * Examples :
 *
 * Input: s = "abba"
 * Output: true
 * Explanation: "abba" reads the same forwards and backwards, so it is a palindrome.
 */
public class PalindromeString {
    // Helper function to check if a string is a palindrome. Recursive implementation.
    private boolean palindromeHelper(int l, int r, String s) {
        // Base case: when the range of indices is empty, return true
        if (l > r) return true;

        // If the first and last characters are not the same, return false
        if (s.charAt(l) != s.charAt(r)) return false;

        // Recursively check the next range of the string
        return palindromeHelper(l+1, r-1, s);
    }

    // Check if a string is a palindrome.
    boolean isPalindrome(String s) {
        return palindromeHelper(0, s.length()-1, s);
    }

    static void main() {
        var obj = new PalindromeString();

        String s1 = "abba";
        String s2 = "abca";

        System.out.println("is 'abba' palindrome ? " + obj.isPalindrome(s1));
        System.out.println("is 'abca' palindrome ? " + obj.isPalindrome(s2));
    }
}
