package recursion.easy;

/**
 * @author Ripan Baidya
 * @date 23/09/25
 * 
 * Print numbers from N to 1 (space separated) without the help of loops.
 * Implement the function printNTill1() to print the numbers from n to 1 as space-separated integers.
 *
 * Example:
 * Input: n = 5
 * Output: 5 4 3 2 1
 * Explanation: We have to print numbers from 5 to 1.
 */
public class PrintNTill1 {
    /**
     * Iterative Approach:
     * Here we are using for loop to print numbers from n till 1.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    /**
    void printNTill1(int n) {
        for (int i = n; i >= 1; i --) {
            System.out.print(i + " ");
        }
    }

    */

    /**
     * Here, we will print the number from n to 1 using recursion.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    void printNTill1(int n) {
        if (n == 0) return;

        // First print 'n', then print numbers from n-1 to 1.
        System.out.print(n + " ");
        printNTill1(n-1);
    }

    static void main() {
        var obj = new PrintNTill1();

        int n = 5;
        obj.printNTill1(n);
    }
}
