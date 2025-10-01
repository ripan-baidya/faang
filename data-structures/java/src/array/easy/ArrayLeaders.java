package array.easy;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author Ripan Baidya
 * @date 01/10/25
 * 
 * You are given an array arr of positive integers. Your task is to find all the leaders in the array.
 * An element is considered a leader if it is greater than or equal to all elements to its right. The
 * rightmost element is always a leader.
 *
 * Example:
 *
 * Input: arr = [16, 17, 4, 3, 5, 2]
 * Output: [17, 5, 2]
 * Explanation: Note that there is nothing greater on the right side of 17, 5 and, 2.
 */
public class ArrayLeaders {
    /**
     * Using Suffix Maximum:
     * The idea is to scan all the elements from right to left in an array and keep track of the maximum
     * till now. When the maximum changes its value, add it to the result. Finally reverse the result.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public ArrayList<Integer> leaders(int arr[]) {
        int n = arr.length; // array length
        int lastMx = arr[n-1]; // right max

        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = n-1; i >= 0; i --) {
            // last element is always leader
            if (i == n-1) {
                ans.add(lastMx);
            }
            else {
                if (arr[i] >= lastMx) {
                    ans.add(arr[i]); // add to ans
                    lastMx = arr[i]; // update lastMx
                }
            }
        }

        // reverse the ans, but it depends on problem statement
        Collections.reverse(ans);
        return ans;
    }

    static void main() {
        var obj = new ArrayLeaders();
        int arr[] = {16, 17, 4, 3, 5, 2};

        System.out.println(obj.leaders(arr));
    }
}
