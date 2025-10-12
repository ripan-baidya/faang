package recursion.hard;

import java.util.ArrayList;
import java.util.List;

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
public class NQueensII {
    /**
     * Approach: ***** Backtracking *****
     * We use backtracking to find all possible solutions to the n-queens puzzle. We start by placing a queen
     * in the first row and try to place it in all possible columns. If a column is safe, we place a queen in
     * that column and move to the next row. If a column is not safe, we move to the next column. We repeat this
     * process until we have placed a queen in all rows. If we have placed a queen in all rows, we have found a
     * solution. We count the solution and return.
     *
     * Time Complexity: O(n!)
     * Space Complexity: O(n²)
     */

    // Entry point
    public int totalNQueens(int n) {
        int[] ans = new int[1];
        char[][] board = new char[n][n]; // board of size n x n
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < n; j ++) {
                board[i][j] = '.';
            }
        }

        dfs(0, n, board, ans);
        return ans[0];
    }

    // Helper function to find all possible solutions
    private void dfs(int r, int n, char[][] board, int[] ans) {
        // when we have reached the end of the board, we have found a solution
        if (r == n) {
            // count the solution
            ans[0] ++;
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

    // Helper function to check if the current position is safe to place a queen
    private boolean isSafe(int curRow, int curCol, int n, char[][] board) {
        // bottom
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
        var obj = new NQueensII();

        int n = 4;
        int ans = obj.totalNQueens(n);

        System.out.println(ans); // 2
    }
}
