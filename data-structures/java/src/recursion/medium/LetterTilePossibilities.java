package recursion.medium;

import java.util.*;

/**
 * @author Ripan Baidya
 * @date 06/10/25
 *
 * You have n  tiles, where each tile has one letter tiles[i] printed on it. Return the number of possible
 * non-empty sequences of letters you can make using the letters printed on those tiles.
 *
 * Exampl:
 * Input: tiles = "AAB"
 * Output: 8
 * Explanation: The possible sequences are "A", "B", "AA", "AB", "BA", "AAB", "ABA", "BAA".
 */
public class LetterTilePossibilities {
    /**
     * Approach: ******** Backtracking ********
     * We use a backtracking approach to generate all possible sequences of letters from the tiles. We iterate
     * over the tiles, and for each tile, we consider two possibilities: either we include it in the current
     * sequence or we exclude it. We use a boolean array `used` to keep track of which tiles have been used
     * earlier. If we encounter a duplicate tile, we skip it and move on to the next tile. If we include the
     * current tile in the sequence, we increment the count of possibilities, mark it as used, and recursively
     * explore the remaining tiles. If we exclude the current tile, we simply move on to the next tile. In the
     * end, we return the count of possibilities.
     *
     *
     * Time complexity: O(n log n) + O(P(n,k)), to sort the string and P(n,k) where P(n,k)=n!/(n-k)!
     * Space complexity: O(n).
     */
    private void dfs(StringBuilder curTile, String tiles, boolean[] used, int[] ans) {
        // Base Case: current tile length is equal to the length of the original tiles
        if (curTile.length() == tiles.length()) {
            return;
        }

        // explore all possibilities
        for (int i = 0; i < tiles.length(); i ++) {
            // Skip duplicates
            if (i > 0 && tiles.charAt(i) == tiles.charAt(i-1) && !used[i-1]) continue;

            if (!used[i]) {
                ans[0] ++; // Increase the count of possibilities
                used[i] = true; // Mark the current tile as used
                curTile.append(tiles.charAt(i));
                dfs(curTile, tiles, used, ans); // recursive call

                // backtrack
                curTile.deleteCharAt(curTile.length()-1); // remove the last character
                used[i] = false; // unmark the current tile as used
            }
        }
    }
    public int numTilePossibilities(String tiles) {
        // sort the tiles to handle duplicates
        char[] charArray = tiles.toCharArray();
        Arrays.sort(charArray);
        String sortedString = new String(charArray);

        int[] ans = new int[1]; // total no. of possibilities
        boolean[] used = new boolean[tiles.length()];

        // parameters: currentTile, sortedOriginalTile, used, ans
        dfs(new StringBuilder(), sortedString, used, ans);
        return ans[0];
    }

    static void main() {
        var obj = new LetterTilePossibilities();

        String tiles = "AAB";
        int totalPossibilities = obj.numTilePossibilities(tiles);
        System.out.println("Total number of tiles possible: " + totalPossibilities);
    }
}
