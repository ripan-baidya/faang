package array.easy;

import java.util.HashMap;
import java.util.Map;

/*
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 * anagram: An anagram is a word or phrase formed by rearranging the letters of a different word
 * or phrase, using all the original letters exactly once.
 *
 * Example 1:
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 *
 * Example 2:
 * Input: s = "rat", t = "car"
 * Output: false
 *
 * @author Ripan Baidya
 * @date 02-01-2026
 */
public class ValidAnagram {
    /*
     * Better approach: Using Map
     * Use a map to count the frequency of each char in s. If the frequency of any char in 't'
     * becomes less than 0, it means that char is not present in s, hence t is not an anagram
     * of 's'.
     * If the map is empty at the end, it means that t is an anagram of s.
     *
     * Time complexity: O(n)
     * Space complexity: O(n)
     */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> mp = new HashMap<>();

        // Count frequency of each letter in s
        for (char c : s.toCharArray()) {
            mp.put(c, mp.getOrDefault(c, 0) + 1);
        }

        // Check if t is an anagram of s
        for (char c : t.toCharArray()) {
            // If t contains a new letter that's not present in s, return false
            if (!mp.containsKey(c)) {
                return false;
            } else {
                int count = mp.get(c) - 1;
                // If the frequency of any letter becomes 0, remove it from the map
                if (count == 0) {
                    mp.remove(c);
                } else {
                    mp.put(c, count);
                }
            }
        }

        return mp.isEmpty();
    }

    /*
     * Optimal approach: Space Optimization using frequency array.
     *
     * Instead of using a map to store the frequency of each letter, we use an array of size 26 to
     * store the frequency of each letter. This reduces the space complexity to O(1).
     * For string 't', we decrement the frequency of each letter. If at any point the frequency of
     * any letter becomes less than 0, it means that letter is not present in 's', hence 't' is not
     * an anagram of 's'.
     *
     * Time complexity: O(n)
     * Space complexity: O(1)
     */
    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        // Frequency array to count the frequency of each letter
        int[] freq = new int[26];

        // Count frequency of each letter in s
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        // Check if t is an anagram of s
        for (char c : t.toCharArray()) {
            // Decrementing the frequency of each letter in t
            freq[c - 'a']--;

            // If the frequency of any letter is less than 0, means that's a new letter
            // that's not present in s, so t is not an anagram of s
            if (freq[c - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

    // Main
    public static void main(String[] args) {
        var ref = new ValidAnagram();

        String s = "anagram", t = "nagaram";
        String s2 = "rat", t2 = "car";

        System.out.println(ref.isAnagram(s, t));    // true
        System.out.println(ref.isAnagram2(s2, t2)); // false
    }
}
