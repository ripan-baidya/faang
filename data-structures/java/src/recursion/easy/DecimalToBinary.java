package recursion.easy;

/**
 * @author Ripan Baidya
 * @date 23/09/25
 * 
 * Given a decimal number n, return its binary equivalent.
 *
 * Example:
 * Input: n = 12
 * Output: 1100
 * Explanation: The binary representation of 12 is "1100", since 12 = 1×23 + 1×22 + 0×21 + 0×20
 */
public class DecimalToBinary {
    /**
     * We recursively divide the decimal number by 2 and keep track of the remainders.
     * The remainders are the binary digits of the number. We combine these remainders
     * into a string to form the binary representation of the decimal number.
     * time: O(log n), space: O(log n)
     */
    String decToBinary(int n) {
        if (n == 1) return "1";
        return (decToBinary(n/2)+" "+Integer.toString(n%2));
    }

    static void main() {
        var obj = new DecimalToBinary();

        int n = 12;
        String binary = obj.decToBinary(n);
        System.out.println("Binary: " + binary);
    }
}
