package recursion.medium;

import java.util.Arrays;

/**
 * @author Ripan Baidya
 * @date 09/10/25
 *
 * You are given an integer array matchsticks where matchsticks[i] is the length of the ith matchstick. You want
 * to use all the matchsticks to make one square. You should not break any stick, but you can link them up,  and
 * each matchstick must be used exactly one time.
 * Return true if you can make this square and false otherwise.
 *
 * Input: matchsticks = [1,1,2,2,2]
 * Output: true
 * Explanation: You can form a square with length 2, one side of the square came two sticks with length 1.
 */
public class MatchsticksToSquare {
    /**
     * Approach: ***** Backtracking *****
     * We will Try to place each matchstick into one of the 4 sides(top, right, down, left), If placing leads to a
     * valid square, return true, If not, backtrack (undo the choice) and try a different placement.
     *
     * Time Complexity: O(4^N) where N is the number of matchsticks
     * Space Comlexity: O(n) due to the recursion stack
     */
    public boolean makesquare(int[] matchsticks) {
        if (matchsticks == null || matchsticks.length < 4) return false;

        int total = 0;
        for (int stick : matchsticks) total += stick;

        if (total % 4 != 0) return false;
        int target = total / 4;

        // Sort in descending order to help pruning
        Arrays.sort(matchsticks);
        reverse(matchsticks); // descending order

        int[] sides = new int[4];

        return backtrack(matchsticks, 0, sides, target);
    }

    private boolean backtrack(int[] matchsticks, int index, int[] sides, int target) {
        if (index == matchsticks.length) {
            // All matchsticks used, check if all sides equal target
            return sides[0] == target && sides[1] == target &&
                    sides[2] == target && sides[3] == target;
        }

        int stick = matchsticks[index];

        for (int i = 0; i < 4; i++) {
            if (sides[i] + stick <= target) {
                sides[i] += stick;
                if (backtrack(matchsticks, index + 1, sides, target)) {
                    return true;
                }
                sides[i] -= stick; // backtrack
            }

            // Optimization: If this side is 0 and failed, no need to try others
            if (sides[i] == 0) break;
        }

        return false;
    }

    // Helper to reverse array in place
    private void reverse(int[] arr) {
        int i = 0, j = arr.length - 1;
        while (i < j) {
            int tmp = arr[i];
            arr[i++] = arr[j];
            arr[j--] = tmp;
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        MatchsticksToSquare solver = new MatchsticksToSquare();
        int[] matchsticks = {1, 1, 2, 2, 2};
        System.out.println(solver.makesquare(matchsticks)); // true
    }
}
