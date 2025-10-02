package recursion.easy;

/**
 * @author Ripan Baidya
 * @date 23/09/25
 *
 * You are given an integer array arr[]. The task is to find the sum of it.
 *
 * Examples:
 * Input: arr[] = [1, 2, 3, 4]
 * Output: 10
 * Explanation: 1 + 2 + 3 + 4 = 10.
 */
public class SumOfArray {
    /**
     * To solve this problem we will use a helper function, which will take the array and its size.
     * We will stop whenever there is a single element in the array. And while backtracking, we will
     * add the 'n-1'-th element to get the total sum of the array.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    int arySumHelper(int[] arr, int n) {
        if (n == 1) return arr[0]; // base case
        return arySumHelper(arr, n-1) + arr[n-1];
    }

    int arraySum(int[] arr) {
        return arySumHelper(arr, arr.length);
    }

    static void main() {
        var obj = new SumOfArray();

        int[] arr = {1, 2, 3};
        int arraySum = obj.arraySum(arr);

        System.out.println("sum of all array elements: " + arraySum);
    }
}
