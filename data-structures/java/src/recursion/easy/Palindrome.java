package recursion.easy;

/**
 * @author Ripan Baidya
 * @date 23/09/25
 * 
 * You are given an integer n. Your task is to determine whether it is a palindrome.
 * A number is considered a palindrome if it reads the same backward as forward, like
 * the string examples "MADAM" or "MOM".
 *
 * Examples:
 *
 * Input: n = 555
 * Output: true
 * Explanation: The number 555 reads the same backward as forward, so it is a palindrome.
 */
public class Palindrome {
    /**
     * Here, we have reversed the number n using recursion and at the time of returning
     * from the main 'isPalindrome' we compare the original 'n' with the reverse 'num'.
     * time: O(log 10 n), space: O(log 10 n)
     */
    private void reverse(int n, int[] rev) {
        if (n == 0) return;
        rev[0] = rev[0] * 10 + n%10;
        reverse(n/10, rev);
    }

    public boolean isPalindrome(int n) {
        int[] rev = new int[1];
        reverse(n, rev);
        return n == rev[0];
    }

    static void main() {
        var obj = new Palindrome();

        int n = 123;
        boolean isPalindrome = obj.isPalindrome(n);
        System.out.println(isPalindrome);
    }
}
