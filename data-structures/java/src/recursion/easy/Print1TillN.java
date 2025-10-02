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
     * Iterative Approach:
     * Here we are using for loop to print numbers from 1 till n.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    void print1TillN(int n) {
        for (int i = 1; i <= n; i ++) {
            System.out.print(i + " ");
        }
    }

    /**
     * Recursive Approach:
     * Here, we will print the number from 1 to n using recursion.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
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
        obj.printTillN(n); // recursive
        obj.print1TillN(n); // iterative
    }
}
