package recursion.easy;

/**
 * @author Ripan Baidya
 * @date 23/09/25
 *
 * Given a positive number n. Find the sum of all the digits of n.
 *
 * Examples:
 * Input: n = 687
 * Output: 21
 * Explanation: Sum of 687's digits: 6 + 8 + 7 = 21
 */
public class SumOfDigits {
    /**
     * Helper method that recursively calculates the sum of digits of a number.
     * Uses an array of size 1 to maintain the running sum across recursive calls
     *
     * Time Complexity: O(log₁₀ n) - We process each digit once, and number of digits is log₁₀ n
     * Space Complexity: O(log₁₀ n) - Recursion stack space proportional to number of digits
     */
    void sumHelper(int n, int[] sum) {
        if (n == 0) return;
        sum[0] += n%10;
        sumHelper(n/10, sum);
    }

    int sumOfDigits(int n) {
        int[] sum = new int[1];
        sumHelper(n, sum);
        return sum[0];
    }

    static void main() {
        var obj = new SumOfDigits();

        int n = 689;
        int sumOfDigits = obj.sumOfDigits(n);

        System.out.println("sum of digits = " + sumOfDigits);
    }
}
