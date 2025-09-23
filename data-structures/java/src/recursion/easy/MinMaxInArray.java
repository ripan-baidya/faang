package recursion.easy;

import java.util.Arrays;
import java.util.List;

/**
 * @author Ripan Baidya
 * @date 23/09/25
 *
 * Given an array arr. Your task is to find the minimum and maximum elements in the array.
 * Note: Return a List that contains two elements the first one will be a minimum element
 * and the second will be a maximum.
 *
 * Example:
 * Input: arr[] = [3, 2, 1, 56, 10000, 167]
 * Output: 1 10000
 * Explanation: minimum and maximum elements of array are 1 and 10000.
 */
public class MinMaxInArray {
    // getting the maximum
    // time: O(N), space: O(N)
    private int getMax(int[] arr, int n, int maxi) {
        if (n == 0) return maxi;
        maxi = Math.max(maxi, arr[n-1]);
        return getMax(arr, n-1, maxi);
    }

    // getting the minimum
    // time: O(N), space: O(N)
    private int getMin(int[] arr, int n, int mini) {
        if (n == 0) return mini;
        mini = Math.min(mini, arr[n-1]);
        return getMin(arr, n-1, mini);
    }

    public List<Integer> getMinMax(int[] arr) {
        int n = arr.length;
        int maxi = getMax(arr, n, Integer.MIN_VALUE);
        int mini = getMin(arr, n, Integer.MAX_VALUE);

        return List.of(mini, maxi);
    }

    static void main() {
        var obj = new MinMaxInArray();

        int[] arr = {3, 2, 1, 56, 10000, 167};
        List<Integer> minMax = obj.getMinMax(arr);

        System.out.println("Array: "+ Arrays.toString(arr));
        System.out.println("Minimum: " + minMax.get(0) + " Maximum: " + minMax.get(1));
    }
}
