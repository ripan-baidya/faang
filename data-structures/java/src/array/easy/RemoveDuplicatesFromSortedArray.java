package array.easy;

/**
 * @author Ripan Baidya
 * @date 30-07-2025
 *
 * Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place
 * such that each unique element appears only once. The relative order of the elements should
 * be kept the same. Then return the number of unique elements in nums.
 *
 * Consider the number of unique elements of nums to be k, to get accepted, you need to do the
 * following things:
 * => Change the array nums such that the first k elements of nums contain the unique elements
 * in the order they were present in nums initially. The remaining elements of nums are not
 * important as well as the size of nums.
 * => Return k.
 *
 * The judge will test your solution with the following code:
 *
 * int[] nums = [...]; // Input array
 * int[] expectedNums = [...]; // The expected answer with correct length
 *
 * int k = removeDuplicates(nums); // Calls your implementation
 *
 * assert k == expectedNums.length;
 * for (int i = 0; i < k; i++) {
 *     assert nums[i] == expectedNums[i];
 * }
 * If all assertions pass, then your solution will be accepted.
 *
 * Input: nums = [1,1,2]
 * Output: 2, nums = [1,2,_]
 * Explanation: Your function should return k = 2, with the first two elements of nums being 1 and
 * 2 respectively. It does not matter what you leave beyond the returned k (hence they are underscores).
 */
public class RemoveDuplicatesFromSortedArray {
    /**
     * optimal solution:
     * we know first element is always unique, we use that property here, we skip where current element
     * is same as last unique element, else we place the new unique element at front of last unique element
     * and update the last unique element
     */
    public int removeDuplicates(int[] nums) {
        int n = nums.length; // array length

        // if array has only one element, return 1
        if (n == 1) return 1;

        int k = 1; // index of last unique element
        int last = nums[0]; // last unique element

        for (int i = 1; i < n; i ++){
            // when current element is same as last unique element, skip it
            if (last == nums[i]){
                continue;
            } else {
                // place the new unique element at front of last unique element
                // update the last unique element
                nums[++ k] = nums[i];
                last = nums[i];
            }
        }

        return k;
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArray obj = new RemoveDuplicatesFromSortedArray();

        int[] nums = {1,1,2};
        int k = obj.removeDuplicates(nums);

        System.out.println("Number of unique elements: "+ k);
    }
}
