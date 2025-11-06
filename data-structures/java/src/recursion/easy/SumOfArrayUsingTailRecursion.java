package recursion.easy;

/**
 * @author Ripan Baidya
 * @date 06/11/25
 * 
 * Given an array arr, we need to find the sum of its elements using Tail Recursion Method.
 *
 * Example:
 *
 * Input: arr = [1, 8, 9]
 * Output: 18
 * Explanation: The sum of the elements in the array [1, 8, 9] is 18.
 */
class SumOfArrayUsingTailRecursion {

    /**
     * calculating sum of all array elements using tail recursion
     *
     * <p>
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * @return sum of all array elements
     */
    public int arrSum(int[] arr, int n, int sum) {
        // base
        if (n == 0) return sum;
        
        // recursive call
        return arrSum(arr, n - 1, sum + arr[n - 1]);
    }

    static void main(String[] args) {
        var obj = new SumOfArrayUsingTailRecursion();

        int []arr = { 2, 55, 1, 7 };
        int sum = obj.arrSum(arr, arr.length, 0);

        System.out.println("Sum of array elements are: " + sum);
    }
}