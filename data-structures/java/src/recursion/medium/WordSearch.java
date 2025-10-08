package recursion.medium;

/**
 * @author Ripan Baidya
 * @date 08/10/25
 *
 * Given an m x n grid of characters board and a string word, return true if word exists in the grid.
 * The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally
 * or vertically neighboring. The same letter cell may not be used more than once.
 *
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * Output: true
 */
public class WordSearch {
    /**
     * Approach: ******* Backtracking *******
     * In the main function,we iterate over the board and for each cell, we check if the current character matches
     * the first character of the word. If it does, we call the dfs function. If dfs returns true,  we return true
     * indicating that the word exists in the grid. If dfs returns false for all choices, we return false.
     *
     * We use backtracking to explore all possible paths in the grid. For each cell, we have four choices(up, right,
     * down, left). We recursively call the dfs function for each choice. If we find a match at any level, we return
     * true. We maintain a visited array to avoid exploring the same cell again.
     *
     * Time Complexity: O(m * n * 4ⁿ)
     * Space Complexity: O(m * n)
     */

    // helper function to check if the current cell is valid
    private boolean isValid(int m, int n, int row, int col) {
        return row >= 0 && row <= m-1 && col >= 0 && col <= n-1;
    }

    private boolean dfs(int curRow, int curCol, int idx, String word, char[][] board, boolean[][] vis) {
        // row and column of the board
        int m = board.length;
        int n = board[0].length;

        // base case 1: word found
        if (idx == word.length()) return true;

        // base case 2: invalid cell or cell already visited or current cell
        // does not match the current character of the word
        if (!isValid(m, n, curRow, curCol) || vis[curRow][curCol] == true
                || board[curRow][curCol] != word.charAt(idx)) {
            return false;
        }

        vis[curRow][curCol] = true  ; // mark current cell visited

        // directions: up, right, down, left
        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};

        // each cell we have 4 choices [up, right, down, left]
        for (int i = 0; i < 4; i ++) {
            // get the adjacent row and column
            int adjRow = curRow + delRow[i];
            int adjCol = curCol + delCol[i];

            // recursively call dfs, incrementing the index to explore the next
            // character of the word
            if (dfs(adjRow, adjCol, idx+1, word, board, vis))
                return true;
        }

        // while backtracking, we unmark the current cell
        vis[curRow][curCol] = false;

        // word never found
        return false;
    }

    public boolean exist(char[][] board, String word) {
        // row and column of the board
        int m = board.length;
        int n = board[0].length;

        // visited array
        boolean[][] vis = new boolean[m][n];

        // Iterate over the board and when we find the first character of the word, that matches the current cell,
        // we call dfs to check if the word exists in the board.
        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j ++) {
                // first character of word matches the current cell
                if (board[i][j] == word.charAt(0)) {
                    // if dfs returns true, we return true, we found the word
                    if(dfs(i, j, 0, word, board, vis))
                        return true;
                }
            }
        }
        // word never found
        return false;
    }

    static void main() {
        var obj = new WordSearch();

        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        String word = "ABCCED";

        boolean isWordFound = obj.exist(board, word);
        System.out.println("Does word exist in the board: " + isWordFound);
    }
}
