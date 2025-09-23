package recursion.easy;

/**
 * @author Ripan Baidya
 * @date 23/09/25
 *
 * You are given a string s. You need to find the length of the string and return it.
 *
 * Example:
 * Input: s = "Hello"
 * Output: 5
 */
public class LengthString {
    /**
     * We use a helper function to calculate the length of a string. We pass the string,
     * its size, and an array with length 1. We stop when there are no elements. At each
     * iteration, we increase the count of the element to the 'len' array to calculate the
     * length of the string.
     * time: O(n), space: O(n)
     */
    private static void lenStrHelper(String s, int n, int[] len) {
        // Base
        if (n == 0) return;
        // Count the length of String
        len[0] ++;
        lenStrHelper(s, n-1, len);
    }
    public static int lengthString(String s) {
        int[] len = new int[1];
        lenStrHelper(s, s.length(), len);
        return len[0];
    }
}
