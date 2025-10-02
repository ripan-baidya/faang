package array.medium;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author Ripan Baidya
 * @date 02/10/25
 *
 * Given two sorted arrays a[] and b[], where each array may contain duplicate elements , the task is to return
 * the elements in the union of the two arrays in sorted order.
 * Union of two arrays can be defined as the set containing distinct common elements that are present in either
 * of the arrays.
 *
 * Examples:
 *
 * Input: a[] = [1, 2, 3, 4, 5], b[] = [1, 2, 3, 6, 7]
 * Output: [1, 2, 3, 4, 5, 6, 7]
 * Explanation: Distinct elements including both the arrays are: 1 2 3 4 5 6 7.
 */
public class UnionOfTwoSortedArrays {
    /**
     * Naive Approach:
     * We use two loops to traverse through both the arrays and add the elements to the result, before
     * adding result to the result we check if the element is already in the result to avoid duplicates.
     *
     * Time Complexity: O(n² + n * m + m²)
     * Space Complexity: O(n + m), if we consider the space to store the result, otherwise O(1)
     */
    /**
    public ArrayList<Integer> findUnion(int[] a, int[] b) {
        ArrayList<Integer> ans = new ArrayList<>();

        // Traverse through a[] and search every element a[i] in result
        for (int i = 0; i < a.length; i++) {
            // check if the element is already in the result to avoid duplicates
            if (!ans.contains(a[i])) {
                ans.add(a[i]);
            }
        }
        // Traverse through b[] and search every element b[i] in result
        for (int i = 0; i < b.length; i++) {
            // check if the element is already in the result to avoid duplicates
            if (!ans.contains(b[i])) {
                ans.add(b[i]);
            }
        }

        Collections.sort(ans);
        return ans;
    }

    */

    /**
     * Expected Approach: Using Merge Step of Merge Sort
     *
     * Time Complexity: O(n + m)
     * Space Complexity: O(n + m), if we consider the space to store the result, otherwise O(1)
     */
    public ArrayList<Integer> findUnion(int[] a, int[] b) {
        ArrayList<Integer> res = new ArrayList<>();
        int n = a.length; // first array length
        int m = b.length; // second array length

        // This is similar to merge of merge sort
        int i = 0, j = 0;
        while(i < n && j < m) {
            // Skip duplicate elements in the first array
            if(i > 0 && a[i - 1] == a[i]) {
                i++;
                continue;
            }
            // Skip duplicate elements in the second array
            if(j > 0 && b[j - 1] == b[j]) {
                j++;
                continue;
            }

            // select and add the smaller element and move
            if(a[i] < b[j]) {
                res.add(a[i]);
                i++;
            }
            else if(a[i] > b[j]) {
                res.add(b[j]);
                j++;
            }
            // If equal, then add to result and move both
            else {
                res.add(a[i]);
                i++;
                j++;
            }
        }

        // Add the remaining elements of a[]
        while (i < n) {
            // Skip duplicate elements in the first array
            if(i > 0 && a[i - 1] == a[i]) {
                i++;
                continue;
            }
            res.add(a[i]);
            i++;
        }

        // Add the remaining elements of b[]
        while (j < m) {
            // Skip duplicate elements in the second array
            if(j > 0 && b[j - 1] == b[j]) {
                j++;
                continue;
            }
            res.add(b[j]);
            j++;
        }
        return res;
    }
    static void main() {
        var obj = new UnionOfTwoSortedArrays();
        int[] a = {1, 2, 3, 4, 5};
        int[] b = {1, 2, 3, 6, 7};

        var res = obj.findUnion(a, b);
        System.out.println(res);
    }
}
