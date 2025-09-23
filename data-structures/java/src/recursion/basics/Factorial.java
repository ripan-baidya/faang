package recursion.basics;

/**
 * @author Ripan Baidya
 * @date 22/09/25
 *
 * Given an integer 'n', your task is to find the factorial of 'n'.
 * Example:
 * n = 5
 * result: 120, 1 * 2 * 3 * 4 * 5 = 120
 */
public class Factorial {
    /**
     * Here, I will solve the problem using iterative approach, and later we will solve the
     * exact same problem using recursion.
     * Time: O(n), Space: O(1)
     */
    int fact(int n) {
        int fact = 1;
        for (int i = 1; i <= n; i ++) {
            fact *= i;
        }
        return fact;
    }

    /**
     * Now, Solving the factorial of N using recursion.
     * time: O(n), space: O(n) for recursive stack space
     */
    int fact2(int n) {
        // base case
        if (n == 0) return 1;

        /**
         * assume n = 5
         *              f(5)     -> n * f(n-1) => 5 * f(4) => 5 * 24 => return 120 (ans)
         *              /
         *           f(4)        -> n * f(n-1) => 4 * f(3) => 4 * 6 => return 24
         *            /
         *          f(3)         -> n * f(n-1) => 3 * f(2) => 3 * 2  => return 6
         *          /
         *        f(2)           -> n * f(n-1) => 2 * f(1) => 2 * 1 => return 2
         *        /
         *      f(1)             -> n * f(n-1) => 1 * f(0) => 1 * 1 => return 1
         *      /
         *    f(0)               -> return 1
         */
        return n * fact2(n-1);
    }
    static void main() {
        var obj = new Factorial();

        int n = 5;
        int f1 = obj.fact(n); // Iterative
        int f2 = obj.fact(n); // Recursive

        System.out.println("Iterative: " + f1);
        System.out.println("Recursive: " + f2);
    }
}
