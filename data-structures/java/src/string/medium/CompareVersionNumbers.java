package string.medium;

/**
 * @author Ripan Baidya
 * @date 24/09/25
 *
 * Given two version strings, version1 and version2, compare them. A version string consists of revisions
 * separated by dots '.'. The value of the revision is its integer conversion ignoring leading zeros.
 *
 * To compare version strings, compare their revision values in left-to-right order. If one of the version
 * strings has fewer revisions, treat the missing revision values as 0.
 *
 * Return the following:
 * If version1 < version2, return -1, If version1 > version2, return 1. Otherwise, return 0.
 *
 * Example 1:
 * Input: version1 = "1.2", version2 = "1.10"
 * Output: -1
 * Explanation: version1's second revision is "2" and version2's second revision is "10": 2 < 10, so v1 < v2.
 *
 * Example 2:
 * Input: version1 = "1.01", version2 = "1.001"
 * Output: 0
 * Explanation: Ignoring leading zeroes, both "01" and "001" represent the same integer "1".
 */
public class CompareVersionNumbers {
    /**
     * The idea is simple: we keep iterating through both version strings until both are fully scanned.
     * In each iteration, I extract the next version number from v1 and v2 (by reading digits until  I
     * hit a dot or the end). Once I have both numbers, I compare them:
     *  - If they are different, I immediately return 1 or -1 depending on which one is bigger.
     *  - If they are equal, I skip the dot (if present) and continue to the next part.
     *
     * If we finish the loop without finding any difference, that means all parts were equal and return 0.
     *
     * Time Complexity: O(max(v1.length, v2.length))  // each character is processed once
     * Space Complexity: O(1)  // only a few integer variables are used
     */
    public int compareVersion(String v1, String v2) {
        // Get the length of the version strings.
        int n1 = v1.length(), n2 = v2.length();
        // Initialize indices for the version strings.
        int i1 = 0, i2 = 0;

        // Traverse the version strings.
        while (i1 < n1 || i2 < n2) {
            // Initialize revision numbers.
            int vn1 = 0, vn2 = 0;

            // Get the revision number from v1.
            while (i1 < n1 && v1.charAt(i1) != '.') {
                vn1 = 10*vn1+v1.charAt(i1)-'0';
                i1 ++;
            }

            // Get the revision number from v2.
            while(i2 < n2 && v2.charAt(i2) != '.'){
                vn2 = 10*vn2+v2.charAt(i2)-'0';
                i2 ++;
            }

            // Compare the revision numbers.
            if (vn1 != vn2) {
                return vn1 > vn2 ? 1 : -1;
            }

            // Skip the dot if it exists.
            if (i1 < n1 && v1.charAt(i1) == '.') i1 ++;
            if (i2 < n2 && v2.charAt(i2) == '.') i2 ++;
        }
        // Both version strings are equal.
        return 0;
    }

    static void main() {
        var obj = new CompareVersionNumbers();

        String v1 = "1.01";
        String v2 = "1.10";
        int result = obj.compareVersion(v1, v2);

        System.out.println("result = " + result);
    }
}
