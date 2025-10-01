package array.easy;

/**
 * @author Ripan Baidya
 * @date 31-07-2025
 *
 * Given an array of integers nums which is sorted in ascending order, and an integer target,
 * write a function to search target in nums. If target exists, then return its index. else,
 * return -1. You must write an algorithm with O(log n) runtime complexity.
 *
 * Example:
 *
 * Input: nums = [-1,0,3,5,9,12], target = 9
 * Output: 4
 * Explanation: 9 exists in nums and its index is 4
 */
public class BinarySearch {
    /**
     * We will take two pointers start and end to keep track of the search space. we will iterate
     * till start <= end. at this point we will calculate mid and check if mid element is equal to
     * target element or not. if element is found return its index else return -1.
     * if mid element is less than target element, we will search in the right half else search in
     * the left half.
     *
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     */
    public int search(int[] arr, int key) {
        int n = arr.length; // array length
        int start = 0, end = n-1; // start and end pointers

        while (start <= end) {
            // calculate mid
            int mid = start + (end-start)/2;

            if (arr[mid] == key) {
                // mid is the target element
                return mid;
            } else if (arr[mid] < key) {
                // search in the right half
                start = mid+1;
            } else {
                // search in the left half
                end = mid-1;
            }
        }
        // target not found
        return -1;
    }

    public static void main(String[] args) {
        var obj = new BinarySearch();

        int[] arr = {-1,0,3,5,9,12};
        int target = 9;

        int index = obj.search(arr, target);
        System.out.println("Index of target: "+ index);
    }
}
