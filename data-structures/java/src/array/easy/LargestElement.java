package array.easy;

/**
 * @author Ripan Baidya
 * @date 30-07-2025
 *
 * Given an array arr[]. The task is to find the largest element and return it.
 *
 * Example:
 *
 * Input: arr[] = [1, 8, 7, 56, 90]
 * Output: 90
 * Explanation: The largest element of the given array is 90.
 */
public class LargestElement {
    /**
     * Recursive Approach:
     * The idea is similar to the iterative approach. Here the traversal of the array is done recursively
     * instead of an iterative loop.
     */
    /**
     private int findMax(int[] arr, int i) {
         // Last index returns the element
         if (i == arr.length - 1) return arr[i];

         // Find the maximum from the rest of the array
         int recMax = findMax(arr, i + 1);

         // Compare with i-th element and return
         return Math.max(recMax, arr[i]);
     }
     public int largest(int[] arr) {
        return findMax(arr, 0);
     }
     */

    /**
     * Iterative Approach:
     * Iterate through array and check if current element is greater than maxi or not.
     * while maintaining the maximum element. Return the maximum element.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public int largest(int[] arr) {
        int maxi = Integer.MIN_VALUE; // maximum element

        // iterate through array
        for (int val : arr){
            if (val > maxi) {
                // update maximum element
                maxi = val;
            }
        }
        // return maximum element
        return maxi;
    }

    static void main(String[] args) {
        var obj = new LargestElement();

        int[] arr = {1, 8, 7, 56, 90};
        System.out.println(obj.largest(arr));
    }
}
