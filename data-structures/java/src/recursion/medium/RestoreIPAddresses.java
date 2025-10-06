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
    // Check if the segment is valid
    private static boolean isValid(String segment) {
        // No leading zeros allowed
        if (segment.length() > 1 && segment.charAt(0) == '0') {
            return false;
        }
        int value = Integer.parseInt(segment);
        // segment value should be within 0-255
        return value >= 0 && value <= 255;
    }

    private static void backtrack(int index, int dots, String s, String currentIP, List<String> result) {
        // If we have placed 4 dots and used the entire string, we have a valid IP
        if (dots == 4 && index == s.length()) {
            result.add(currentIP.substring(0, currentIP.length() - 1)); // Remove the last dot
            return;
        }
        // If we exceed 4 segments or use all characters, return
        if (dots > 4 || index >= s.length()) {
            return;
        }
        // Try placing a dot after 1, 2, or 3 digits
        for (int len = index; len < Math.min(index+3, s.length()); len++) {
            String segment = s.substring(index, len+1);

            // Check if the segment is valid
            if (isValid(segment)) {
                // Recur with the new segment added to the current IP
                backtrack(len+1, dots + 1, s, currentIP + segment + ".", result);
            }
        }
    }
    // Main function to restore IP addresses
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();

        // parameters: index, dots, s, currentIP, result
        backtrack(0, 0, s, "",  result);
        return result;
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
