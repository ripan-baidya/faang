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
     * Here, we will print the number from n to 1 using recursion.
     * time: O(n), space: O(n)
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
