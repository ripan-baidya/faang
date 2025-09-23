package recursion.easy;

/**
 * @author Ripan Baidya
 * @date 23/09/25
 * 
 * Given an positive integer n, print numbers from 1 to n without using loops.
 * Implement the function printTillN() to print the numbers from 1 to n as space-separated integers.
 *
 * Example:
 * Input: n = 5
 * Output: 1 2 3 4 5
 * Explanation: We have to print numbers from 1 to 5.
 */
public class Print1TillN {

    /**
     * Here, we will print the number from 1 to n using recursion.
     * time: O(n), space: O(n)
     */
    void printTillN(int n) {
        if (n == 0) return;

        // Recursively print numbers till n-1, then print 'n'.
        // This ensures numbers are printed in the order 1 2 3 ... n.
        printTillN(n-1);
        System.out.print(n + " ");
    }

    static void main() {
        var obj = new Print1TillN();

        int n = 5;
        obj.printTillN(n);
    }
}
