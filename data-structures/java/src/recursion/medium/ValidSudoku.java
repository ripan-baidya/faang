package recursion.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Ripan Baidya
 * @date 30/10/25
 *
 * <p>
 * Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the
 * following rules:
 * </p>
 * <ul>
 *      <li> Each row must contain the digits 1-9 without repetition. </li>
 *      <li> Each column must contain the digits 1-9 without repetition. </li>
 *      <li> Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.</li>
 * </ul>
 * Note:
 * <ul>
 *      <li> A Sudoku board (partially filled) could be valid but is not necessarily solvable. </li>
 *      <li> Only the filled cells need to be validated according to the mentioned rules. </li>
 * </ul>
 */

public class ValidSudoku {
    // *************** Approach 1: Brute Force ***************

    /**
     * Every number between 1 to 9 appears only once in every row, column and 3X3 sub-matrix of the sudoku.
     * Check for every cell that it's value is appearing only once in it's row, column and 3X3 sub-matrix.
     * <ul>
     *     <li>Time Complexity: O(1) or O(n²) for generalized nxn sudoku </li>
     *     <li>Space Complexity: O(1)</li>
     * </ul>
     */
    // Entry point
    public boolean isValidSudoku(char[][] board) {
        // check for every row and column
        for (int i = 0; i < 9; i++) {
            if (!isRowValid(board, i) || !isColValid(board, i))
                return false;
        }
        // check for every 3x3 sub matrix
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                if (!isSub3x3Valid(board, i, j))
                    return false;
            }
        }

        return true;
    }
    
    // *************** Helpers methods ***************

    // checking whether a row is satisfies the conditions
    private boolean isRowValid(char[][] board, int row) {
        boolean[] vis = new boolean[10];
        for (int col = 0; col < 9; col++) {
            if (board[row][col] != '.') {
                int val = board[row][col] - '0';
                if (vis[val]) return false;
                vis[val] = true;
            }
        }
        return true;
    }
    // checking whether a column is satisfies the conditions
    private boolean isColValid(char[][] board, int col) {
        boolean[] vis = new boolean[10];
        for (int row = 0; row < 9; row++) {
            if (board[row][col] != '.') {
                int val = board[row][col] - '0';
                if (vis[val]) return false;
                vis[val] = true;
            }
        }
        return true;
    }

    // checking whether a 3x3 sub matrix satisfies the conditions
    private boolean isSub3x3Valid(char[][] board, int startRow, int startCol) {
        boolean[] vis = new boolean[10];
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                char curr = board[startRow + row][startCol + col];
                if (curr != '.') {
                    int val = curr - '0';
                    if (vis[val]) return false;
                    vis[val] = true;
                }
            }
        }
        return true;
    }

    // *************** Approach 2: Using HashSet ***************

    /**
     * Instead of checking rows, columns, and subgrids separately, we can do everything in one traversal of the
     * board.
     * <ul>
     *      <li>Time Complexity: O(1) or O(n²) for generalized nxn sudoku </li>
     *      <li>Space Complexity: O(1)</li>
     * </ul>
     */
    public boolean isValidSudoku2(char[][] board) {
        Set<String> seen = new HashSet<>();

        for (int i = 0; i < 9; i ++) {
            for (int j = 0; j < 9; j ++) {
                char curr = board[i][j];
                // when the current cell is empty, simply skip it
                if (curr == '.') continue;

                /**
                 * if the current cell is not empty, we check if it's value is already seen in the row, column
                 * or 3x3 sub matrix if it is, we return false
                 */
                if (!seen.add(curr + " in row " + i) ||
                        !seen.add(curr + " in col " + j) ||
                        !seen.add(curr + " in box " + (i / 3) + "-" + (j / 3))) {
                    return false;
                }
            }
        }

        return false;
    }
    // Main method
    static void main() {
        var obj = new ValidSudoku();
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        boolean isValid = obj.isValidSudoku(board);
        System.out.println("Is valid: " + isValid);
    }
}
