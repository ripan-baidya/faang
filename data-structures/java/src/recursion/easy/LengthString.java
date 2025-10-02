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
    private void lenStrHelper(String s, int n, int[] len) {
        if (n == 0) return; // base case
        len[0] ++; // count length
        lenStrHelper(s, n-1, len);
    }
    public int lengthString(String s) {
        int[] len = new int[1];
        lenStrHelper(s, s.length(), len);
        return len[0];
    }

    static void main() {
        var obj = new LengthString();
        String s = "helloWorld";
        int length = obj.lengthString(s);

        System.out.println(length);
    }
}
