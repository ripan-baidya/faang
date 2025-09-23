package recursion.easy;

/**
 * @author Ripan Baidya
 * @date 23/09/25
 *
 * You are given a string s, and your task is to reverse the string.
 *
 * Examples:
 * Input: s = "Hello"
 * Output: "olleH"
 */
public class ReverseString {
    /**
     * We use a helper function to reverse a string. We pass the string, its size, and a
     * StringBuilder object. We stop when there are no elements. At each iteration, we
     * append the last element to the StringBuilder object to form the reverse string.
     * time: O(n), space: O(n)
     */
    private void revStrHelper(String s, int n, StringBuilder sb) {
        if (n == 0) return;
        sb.append(s.charAt(n-1));
        revStrHelper(s, n-1, sb);
    }

    public String reverseString(String s) {
        StringBuilder sb = new StringBuilder();
        revStrHelper(s, s.length(), sb);
        return sb.toString();
    }

    static void main() {
        var obj = new ReverseString();

        String s = "Hello";
        String revString = obj.reverseString(s);

        System.out.println("Reverse String = " + revString);
    }
}
