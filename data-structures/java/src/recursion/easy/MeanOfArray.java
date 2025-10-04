package recursion.easy;

import java.util.Arrays;

/**
 * @author Ripan Baidya
 * @date 03/10/25
 * 
 * Given an array of numbers, you are required to calculate the mean (average) using recursion.
 * Note: The mean of an array is the sum of its elements divided by the number of elements in
 * the array.
 *
 * Examples:
 *
 * Input: 1 2 3 4 5
 * Output: 3
 * Explanation: The sum of elements (15) divided by the number of elements (5) gives the mean: 3
 */
public class MeanOfArray {
    /**
     * Recursive mean calculation sums array elements, dividing by n.
     * Formula: mean(A,N)= mean(A,N−1)×(N−1)+A[N−1] / N
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * @return double mean of the array
     */
    /*
    public double findMean(int[] arr) {
        int n = arr.length;
        if (n == 1)
            return (double)arr[n-1]; // base case
        else
            return ((findMean(Arrays.copyOf(arr, n-1)) * (n-1) + arr[n-1]) / n);
    }

    */

    /**
     * we first calculated the total sum of array elements and then divide it by array length to get the mean.
     * @return int mean of the array
     */
    // sum of array elements
    public int findSum(int[] arr, int n) {
        if (n == 1) return arr[n-1];
        return findSum(arr, n-1)+arr[n-1];
    }
    // sum of array elements/ array length
    public int findMean(int[] arr) {
        return findSum(arr, arr.length)/arr.length;
    }

    static void main() {
        var obj = new MeanOfArray();
        int[] arr = {1, 2, 3, 4, 5};

        System.out.println(obj.findMean(arr));
    }
}
