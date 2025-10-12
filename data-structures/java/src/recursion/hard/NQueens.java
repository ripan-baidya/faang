package recursion.hard;

import java.util.*;
/**
 * @author Ripan Baidya
 * @date 12/10/25
 * 
 * The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens
 * attack each other.
 * Given an integer n,return all distinct solutions to the n-queens puzzle. You may return the answer in
 * any order.
 * Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and   '.'
 * both indicate a queen and an empty space, respectively.
 *
 * Input: n = 4
 * Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
 */
public class NQueens {
    /**
     * Approach: ***** Backtracking *****
     * We use backtracking to find all possible solutions to the n-queens puzzle. We start by placing a queen
     * in the first row and try to place it in all possible columns. If a column is safe, we place a queen in
     * that column and move to the next row. If a column is not safe, we move to the next column. We repeat this
     * process until we have placed a queen in all rows. If we have placed a queen in all rows, we have found a
     * solution. We add the current board to the answer and return.
     *
     * Time Complexity: O(n!)
     * Space Complexity: O(n²)
     */

    // Entry point
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n]; // board of size n x n
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < n; j ++) {
                board[i][j] = '.';
            }
        }

        dfs(0, n, board, ans);
        return ans;
    }

    // Helper function to find all possible solutions
    private void dfs(int r, int n, char[][] board, List<List<String>> ans) {
        // when we have reached the end of the board, we have found a solution
        if (r == n) {
            // add the current board to the answer
            List<String> copy = new ArrayList<>();
            for (char[] row : board) {
                copy.add(new String(row));
            }
            ans.add(copy);
            return;
        }

        // try all possible columns
        for (int c = 0; c < n; c ++) {
            if (isSafe(r, c, n, board)) {
                board[r][c] = 'Q';
                dfs(r+1, n, board, ans);
                board[r][c] = '.';
            }
        }
    }

    /**
     *  n=4, board of size 4 x 4 with a valid solution.
     *  The below board and there corresponding indices[x][y] are shown. refer them to write the function
     *  "isSafe(row, col, n, board)"
     *
     *  .   Q   .   .       => 00   01   02   03
     *  .   .   .   Q       => 10   11   12   13
     *  Q   .   .   .       => 20   21   22   23
     *  .   .   Q   .       => 30   31   32   33
     *
     *  same column above   : [00 10 20 30], [01 11 21 31], ....
     *  upper left diagonal : [30], [31, 20], [32, 21, 10], [33, 22, 11, 00], [23, 12, 01], [13, 02], [03]
     *  upper right diagonal: [00], [10, 01], [20, 11, 02], [30, 21, 12, 03], [31, 22, 13], [31, 23], [33]
     */
    // Helper function to check if the current position is safe to place a queen
    private boolean isSafe(int curRow, int curCol, int n, char[][] board) {
        // same column above
        for (int row = 0; row < curRow; row ++) {
            if (board[row][curCol] == 'Q')
                return false;
        }

        // upper left diagonal
        for (int row = curRow-1, col = curCol-1; row >= 0 && col >=0; row --, col --) {
            if (board[row][col] == 'Q')
                return false;
        }

        // upper right diagonal
        for (int row = curRow-1, col = curCol+1; row >= 0 && col < n; row --, col ++) {
            if (board[row][col] == 'Q')
                return false;
        }

        return true;
    }

    static void main() {
        var obj = new NQueens();

        int n = 4;
        List<List<String>> ans = obj.solveNQueens(n);

        System.out.println(ans); // [[.Q.., ...Q, Q..., ..Q.], [..Q., Q..., ...Q, .Q..]]
    }
}
