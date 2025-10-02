package array.hard;

import java.util.Arrays;

/**
 * @author Ripan Baidya
 * @date 02-10-2025
 *
 * Given two sorted arrays a[] and b[] of size n and m respectively, the task is to merge them in sorted order
 * without using any extra space. Modify a[] so that it contains the first n elements and modify b[] so that it
 * contains the last m elements.
 *
 * Example:
 *
 * Input: a[] = [2, 4, 7, 10], b[] = [2, 3]
 * Output: a[] = [2, 2, 3, 4], b[] = [7, 10]
 * Explanation: After merging the two non-decreasing arrays, we get, [2, 2, 3, 4, 7, 10]
 */
public class MergeSortedArrayWithoutExtraSpace {
    /**
     * Naive Approach 1: Using extra space
     * We use the idea of merge sort to merge two sorted arrays. We create a new array and merge the two arrays
     * into the new array. Then we copy the new array back to the first array.
     *
     * Time Complexity: O(n*log n)
     * Space Complexity: O(n)
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // resultant merged array
        int[] merged = new int[m + n];
        // i and j are the pointers for nums1 and nums2
        int i = 0, j = 0;
        // the pointer for merged array
        int index = 0;

        // Merge the arrays
        while (i < m && j < n) {
            if (nums1[i] <= nums2[j]) {
                merged[index++] = nums1[i++];
            } else {
                merged[index++] = nums2[j++];
            }
        }

        // Add the remaining elements of nums1
        while (i < m) {
            merged[index++] = nums1[i++];
        }

        // Add the remaining elements of nums2
        while (j < n) {
            merged[index++] = nums2[j++];
        }

        // Copy the merged array back to nums1
        for (i = 0; i < m + n; ++i) {
            nums1[i] = merged[i];
        }
    }

    /**
     * Naive Approach 2: Using Insert of Insertion Sort
     * We’re going to take b[] and reverse it from the back. Then, we’ll compare each element in b[] with
     * the last element in a[]. If b[i] is smaller than the last element of a[], we’ll swap b[i] with the
     * last element of a[] and use the insertion sort algorithm to find the right spot for b[i] in a[].
     *
     * Now, how do we keep a[] sorted? Well, every time we add an element from b[] to a[], we use the
     * insertion sort algorithm to find the correct index.
     * And how do we keep b[] sorted? That’s because we start from the back of b[] and only add elements
     * when the current element in b[] is smaller than the last element in a[].
     *
     * Time Complexity: O(n * m), where n is the length of a[] and m is the length of b[]
     * Space Complexity: O(1)
     */
    /**
    public void mergeArrays(int[] a, int[] b) {
        // Traverse b[] starting from the last element
        for (int i = b.length - 1; i >= 0; i --) {
            // If b[i] is smaller than the largest element of a[]
            if (a[a.length - 1] > b[i]) {
                // Place b[i] in the correct position in a[],
                // and move last element of a[] to b[]
                int last = a[a.length - 1];
                int j = a.length - 2;
                while (j >= 0 && a[j] > b[i]) {
                    a[j + 1] = a[j];
                    j--;
                }
                a[j + 1] = b[i];
                b[i] = last;
            }
        }
    }

    */

    /**
     * Better Approach: Using Swap & Sort
     * We can actually use the same approach without having to find the pivot index. All we need to do is swap
     * the rightmost element in a[] with the leftmost element in b[], then the second rightmost element in a[]
     * with the second leftmost element in b[], and so on. This process will keep going until the selected
     * element from a[] is bigger than the selected element from b[].
     *
     * Once we reach the pivot index, this condition automatically fails, and we stop here. After that, we just
     * sort both arrays to keep the order.
     *
     * Time Complexity: O((m+n) + m*log(m) + n*log(n)), where n and m are sizes of a[] and b[] respectively.
     * Space Complexity: O(1)
     */
    private void mergeArrays(int[] a, int[] b) {
        int i = a.length - 1, j = 0;

        // Swap smaller elements from b[] with
        // larger elements from a[]
        while (i >= 0 && j < b.length) {
            if (a[i] < b[j]) {
                i--;
            } else {
                int temp = b[j];
                b[j] = a[i];
                a[i] = temp;
                i--;
                j++;
            }
        }

        // Sort both arrays
        Arrays.sort(a);
        Arrays.sort(b);
    }



    static void main(String[] args) {
        var obj = new MergeSortedArrayWithoutExtraSpace();

        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};

        obj.merge(nums1, 3, nums2, 3);
    }
}
