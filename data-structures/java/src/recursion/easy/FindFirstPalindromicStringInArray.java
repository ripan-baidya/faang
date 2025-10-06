package recursion.easy;

/**
 * @author Ripan Baidya
 * @date 06/10/25
 * 
 * Given an array of strings words, return the first palindromic string in the array. If there is no such string,
 * return an empty string "". A string is palindromic if it reads the same forward and backward.
 *
 * Example:
 * Input: words = ["abc","car","ada","racecar","cool"]
 * Output: "ada"
 */
public class FindFirstPalindromicStringInArray {
    /**
     * Approach: Linear Search
     * The idea is very simple, we will iterate over the words array, and for each word, we will check if the word
     * (current) is a palindrome or not. If it is a palindrome, we will return it. If not, we will continue to the
     * next word. If we don't find any palindromic string, we will return an empty string.
     *
     * Time Complexity: O(n * m), n is the length of the array and m is the average length of the string
     * Space Complexity: O(1)
     */

    // Helper function to check if a string is a palindrome
    private boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l <= r) {
            if (s.charAt(l ++) != s.charAt(r --))
                return false;
        }
        return true;
    }
    public String firstPalindrome(String[] words) {
        for (String word : words) {
            // when current word is palindrome, return it
            // this would be the first palindromic string in the array
            if (isPalindrome(word))
                return word;
        }
        return "";
    }

    static void main() {
        var obj = new FindFirstPalindromicStringInArray();

        String[] words = {"abc", "car", "ada", "racecar", "cool"};
        String firstPalindromicString = obj.firstPalindrome(words);

        System.out.println("First Palindromic String: " + firstPalindromicString);
    }
}
