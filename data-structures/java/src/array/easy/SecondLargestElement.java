package array.easy;

import java.util.Arrays;

/**
 * @author Ripan Baidya
 * @date 30-07-2025
 *
 * Given an array of positive integers arr[], return the second-largest element from the array.
 * If the second-largest element doesn't exist then return -1.
 * Note: The second-largest element should not be equal to the largest element.
 *
 * Example:
 *
 * Input: arr[] = [12, 35, 1, 10, 34, 1]
 * Output: 34
 * Explanation: The largest element of the array is 35 and the second-largest element is 34.
 */
public class SecondLargestElement {
    /**
     * Naive Approach:
     * We will sort the array in ascending order. since the largest element will be at the last
     * index. and the second-largest element will be the first element (from the end) that  is
     * strictly smaller than the largest element. If all elements are the same, there is no valid
     * second largest.
     *
     * Time Complexity: O(n log n) due to sorting.
     * Space Complexity: O(1) (in-place sorting, ignoring sort's recursion stack).
     */
    /**
     * public int getSecondLargest(int[] arr) {
     *         // validate input
     *         if (arr == null || arr.length < 2) return -1;
     *
     *         // sort the array in ascending order
     *         Arrays.sort(arr);
     *         // initialize largest by last element
     *         int largest = arr[arr.length-1];
     *
     *         for (int i = arr.length-2; i >= 0; i --) {
     *             if (arr[i] < largest) {
     *                 // second largest
     *                 return arr[i];
     *             }
     *         }
     *
     *         // no second-largest element found
     *         return -1;
     *     }
     */

    /**
     * Optimal Approach:
     * Iterate through the array and check if current element is greater than the maximum then
     * update the maximum and second maximum. If current element is greater than the second maximum
     * and this is not equivalent to the maximum then update the second maximum.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public int getSecondLargest(int[] arr) {
        int n = arr.length;
        int maxi = Integer.MIN_VALUE, secMaxi = Integer.MIN_VALUE;

        for (int i = 0; i < n; i ++){
            // when current element is greater than the maximum
            if (arr[i] > maxi){
                // update the maximum and second maximum
                secMaxi = maxi;
                maxi = arr[i];
            }
            // when current is greater tha the second maximum
            // and this is not equivalent to the maximum
            else if (arr[i] > secMaxi && arr[i] != maxi){
                secMaxi = arr[i];
            }
        }

        return secMaxi;
    }

    static void main(String[] args) {
        var obj = new SecondLargestElement();

        int[] arr = {12, 35, 1, 10, 34, 1};
        int secondLargest = obj.getSecondLargest(arr);

        System.out.println("Second largest element: "+ secondLargest);
    }
}
