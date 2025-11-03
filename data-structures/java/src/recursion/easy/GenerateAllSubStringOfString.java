package recursion.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ripan Baidya
 * @date 03/11/25
 *
 * Given a string s, containing lowercase alphabetical characters. The task is to print all non-empty substrings of
 * the given string.
 *
 * Examples :
 *
 * Input :  s = "abc"
 * Output :  "a", "ab", "abc", "b", "bc", "c"
 */
public class GenerateAllSubStringOfString {
    // *************** Iterative Approach: Efficient ***************
    /**
     * We use two nested loops, the outer loop picks the starting index(0, len-1) and the inner loop picks the ending
     * index(j, len-1). We use the substring method to generate the substrings and add them to the result list.
     * @param s an string
     * @return list of substrings
     *
     * Time complexity: O(n^3)
     * Space Complexity: O(n), to store the substrings.
     */
    private List<String> generateSubstrings(String s) {
        int len  = s.length();
        List<String> res = new ArrayList<>();

        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                String substr = s.substring(i, j + 1); // O(n)
                res.add(substr);
            }
        }
        return res;
    }

    // *************** Recursive Approach ***************
    /**
     * We use backtracking to generate all substrings of a string.
     * @param s an string
     * @return list of substrings
     *
     * Time complexity: O(n²)
     * Space Complexity: O(n), to store the substrings.
     */
    private List<String> generateSubstringsRecursively(String s) {
        // Base Case: if the string is null or empty return an empty list
        if (s == null || s.isEmpty()) {
            return new ArrayList<>();
        }

        List<String> res = new ArrayList<>(); // to store substrings
        StringBuilder cur = new StringBuilder(); // to store current substring

        dfs(s, s.length(), 0, cur, res); // call dfs

        return res;
    }

    // Helper methods to generate all substring of a string
    private void dfs(String s, int len, int index, StringBuilder cur, List<String> res) {
        // Base case: index equals to length of the string
        if (index == len) {
            return;
        }

        // add character to the current string and add it to the result list
        cur.append(s.charAt(index));
        res.add(cur.toString());

        // call the dfs for next index
        dfs(s, len, index+1, cur, res);

        // remove the last added character from the current string
        cur.deleteCharAt(cur.length()-1);

        // Whenever our current string is empty, call the dfs for next index
        if (cur.isEmpty()) {
            dfs(s, len, index+1, cur, res);
        }
    }

    // Main
    static void main() {
        var obj = new GenerateAllSubStringOfString();

        String s = "abc";
        List<String> allSubstrings = obj.generateSubstrings(s);
        List<String> allSubstringsRecursively = obj.generateSubstringsRecursively(s);

        System.out.println("Iterative: " + allSubstrings);
        System.out.println("Recursive: " + allSubstringsRecursively);
    }
}
