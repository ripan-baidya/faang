package recursion.basics;

/**
 * @author Ripan Baidya
 * @date 22/09/25
 *
 * Give 'n' print the n'th fibonacci number.
 * Fibonacci series: Series which starts from number 0 and 1, where each succeeding number is the sum
 * of the two preceding numbers.
 * Example:
 * n = 6
 * result: 8
 */
public class Fibonacci {
    /**
     * Recurrence relation is: ans = fibo(n-1) + fibo(n-2)
     * time: O(n^2), because each function call branches into two more calls, creating a rapidly expanding
     * tree of repeated calculations. The space complexity is O(n) due to the maximum depth of the recursion
     * stack.
     */
    int nthFibonacciNumber(int n) {
        if (n == 0) return 0;
        if (n > 0 && n <= 2) return 1;

        return nthFibonacciNumber(n-1) + nthFibonacciNumber(n-2);
    }
    static void main() {
        var obj = new Fibonacci();

        int n = 8;
        int nthFibonacciResult = obj.nthFibonacciNumber(n);

        System.out.println("Nth fibonacci number: " + nthFibonacciResult);
    }
}