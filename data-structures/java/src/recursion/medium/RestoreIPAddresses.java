package recursion.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ripan Baidya
 * @date 06/10/25
 *
 * A valid IP address consists of exactly four integers separated by single dots. Each integer is between 0 and
 * 255 (inclusive) and cannot have leading zeros.
 * For example, "0.1.2.201" and "192.168.1.1" are valid IP addresses, but "0.011.255.245", "192.168.1.312"  and
 * "192.168@1.1" are invalid IP addresses.Given a string s containing only digits, return all possible valid IP
 * addresses that can be formed by inserting dots into s.You are not allowed to reorder or remove any digits in
 * s. You may return the valid IP addresses in any order.
 *
 * Example:
 * Input: s = "25525511135"
 * Output: ["255.255.11.135","255.255.111.35"]
 */
public class RestoreIPAddresses {
    /**
     * ************ Backtracking Approach ************
     *
     * We need to insert 3 dots into the given string to form a valid IP address. A valid IP address consists of
     * 4 segments (numbers) separated by dots, where each segment:
     *   - is between 0 and 255 (inclusive)
     *   - cannot have leading zeros (e.g., "01" or "00" are invalid)
     *
     * Constraints:
     * - The input string can have a maximum length of 12, because 4 segments × 3 digits = 12.
     * - We must place exactly 3 dots and reach the end of the string to form a valid IP.
     *
     * Approach Summary:
     * - Use backtracking to explore all possible placements of dots.
     * - At each step, try forming a segment of length 1, 2, or 3.
     * - If the segment is valid, add it to the current IP and recurse for the next part.
     * - If 4 segments (dots) are placed and the end of the string is reached → add it to the result.
     * - Prune paths where segments exceed 3 digits, dots > 4, or we go beyond string length.
     *
     * Time Complexity: O(3^4) = O(1), Bounded by a constant factor due to the problem constraints.
     * Space Complexity: O(1), Constant space for the call stack and result storage.
     */

    // helper function to check whether the segment is valid
    private boolean isValid(String s) {
        if (s.length() > 1 && s.charAt(0) == '0'){
            return false; // leading zero is not allowed
        }
        int val = Integer.parseInt(s);
        return val >= 0 && val <= 255; // 0-255 (inclusive)
    }

    private void dfs(int idx, int dots, String s, StringBuilder curIp, List<String> ans) {
        // base case 1: if we have 4 segments and reached the end of the string
        if (dots == 4 && idx == s.length()) {
            // make sure remove the last dot while adding to the answer
            ans.add(curIp.substring(0, curIp.length()-1).toString());
            return;
        }

        // base case 2: if we have 4 segments but not reached the end of the string
        if (dots == 4) return;

        for (int j = idx; j < s.length(); j ++) {
            String segment = s.substring(idx, j+1);

            // if the segment is not valid, break
            if (!isValid(segment)) break;

            int lenBeforeAppend = curIp.length();
            if (isValid(segment)) {
                curIp.append(segment).append(".");
                dfs(j+1, dots+1, s, curIp, ans);
                curIp.delete(lenBeforeAppend, curIp.length());
            }
        }
    }
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        if (s.length() < 4 || s.length() > 12) return ans;

        // @params: index, dots, string, current IP, answer
        dfs(0, 0, s, new StringBuilder(), ans);
        return ans;
    }


    static void main(String[] args) {
        var obj = new RestoreIPAddresses();

        String s = "25525511135";
        List<String> validIPs = obj.restoreIpAddresses(s);
        for (String ip : validIPs) {
            System.out.println(ip);
        }
    }
}
