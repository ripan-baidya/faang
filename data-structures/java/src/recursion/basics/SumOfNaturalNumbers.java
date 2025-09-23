package recursion.basics;

/**
 * @author Ripan Baidya
 * @date 22/09/25
 *
 * Given an integer 'n', your task is to find the sum of 'n' natural number.
 * Example:
 * n = 5
 * result: 15, Explanation: (1 + 2 + 3 + 4 + 5) = 15
 */
public class SumOfNaturalNumbers {
    /**
     * Here, I will solve the problem using iterative approach, and later we will solve the
     * exact same problem using recursion.
     * Time: O(n), Space: O(1)
     */
    int fun(int n) {
        int sumN = 0;
        for (int i = 1; i <= n; i ++) {
            sumN += i;
        }
        return sumN;
    }

    /**
     * Now, Solving the sum of N using recursion.
     * time: O(n), space: O(n) for recursive stack space
     */
    int fun2(int n) {
        // base case
        if (n == 1) return 1;

        /**
         * assume n = 5
         *              f(5)     -> n + f(n-1) => 5 + f(4) => 5 + 10 => return 15 (ans)
         *              /
         *           f(4)        -> n + f(n-1) => 4 + f(3) => 4 + 6 => return 10
         *            /
         *          f(3)         -> n + f(n-1) => 3 + f(2) => 3 + 3 => return 6
         *          /
         *        f(2)           -> n + f(n-1) => 2 + f(1) => 2 + 1 => return 3
         *        /
         *      f(1)             -> return 1
         */
        return n + fun2(n-1);
    }
    static void main() {
        var obj = new SumOfNaturalNumbers();

        int n = 5;
        int sum1 = obj.fun(n); // Iterative
        int sum2 = obj.fun2(n); // Recursive

        System.out.println("Iterative: " + sum1);
        System.out.println("Recursive: " + sum2);
    }
}
