package recursion.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Ripan Baidya
 * @date 06/11/25
 * 
 * Given an m x n board of characters and a list of strings words, return all words on the board.
 * Each word must be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally
 * or vertically neighboring. The same letter cell may not be used more than once in a word.
 *
 * Example:
 *
 * Input: board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]],
 *        words = ["oath","pea","eat","rain"]
 * Output: ["eat","oath"]
 */
public class WordSearchII {

    // *************** Naive Approach: Using Map ***************
    /**
     * We build a map of character -> list of positions and then for each word, we check if the first character
     * of the word exists in the map. If it does, we call dfs to check if the word exists in the board. If it does,
     * we add it to the result list. We stop searching this word once found.
     *
     * Note: This approach is not optimal as it has a high time complexity. and you might get TLE.
     * We will implement the optimal solution using Trie.
     *
     * Time complexity: O(m * n * 4 * 3^(L-1))
     * Space complexity: O(m * n)
     * @param board
     * @param words
     * @return
     */
    public List<String> findWords(char[][] board, String[] words) {
        int m = board.length;
        int n = board[0].length;
        List<String> res = new ArrayList<>(); // result

        // character -> list of positions, eg: a -> [ [1, 2], [3, 4] ]
        Map<Character, List<int[]>> map = new HashMap<>();

        // build map of character -> list of positions
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char cur = board[i][j];
                map.computeIfAbsent(cur, k -> new ArrayList<>()).add(new int[]{i, j});
            }
        }

        for (String word : words) {
            // quickly check if the first character of the word exists in the board
            // by utilizing the map we built earlier to avoid unnecessary computation
            if (!map.containsKey(word.charAt(0))) continue;

            for (int[] loc : map.get(word.charAt(0))) {
                // if word exists in the board, add it to the result list
                if (exist(board, word, loc[0], loc[1])) {
                    res.add(word);
                    break; // stop searching this word once found
                }
            }
        }

        return res;
    }

    // helper function to check if the given word exists in the board
    private boolean exist(char[][] board, String word, int row, int col) {
        int m = board.length;
        int n = board[0].length;

        boolean[][] vis = new boolean[m][n];
        return dfs(row, col, 0, word, board, vis);
    }

    // helper function to check if the given row and column are valid
    private boolean isValid(int m, int n, int row, int col) {
        return row >= 0 && row < m && col >= 0 && col < n;
    }

    // helper function to perform dfs
    private boolean dfs(int row, int col, int idx, String word, char[][] board, boolean[][] vis) {
        int m = board.length;
        int n = board[0].length;

        if (!isValid(m, n, row, col) || vis[row][col] || board[row][col] != word.charAt(idx))
            return false;

        if (idx == word.length() - 1) return true;

        vis[row][col] = true;
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        for (int i = 0; i < 4; i++) {
            if (dfs(row + dr[i], col + dc[i], idx + 1, word, board, vis)) {
                vis[row][col] = false;
                return true;
            }
        }

        vis[row][col] = false;
        return false;
    }

    // main
    static void main() {
        var obj = new WordSearchII();

        char[][] board = {
            { 'o', 'a', 'a', 'n' },
            { 'e', 't', 'a', 'e' },
            { 'i', 'h', 'k', 'r' },
            { 'i', 'f', 'l', 'v' }
        };
        String[] words = { "oath", "pea", "eat", "rain" };

        var res = obj.findWords(board, words);
        System.out.println(res);
    }
}
