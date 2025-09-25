# Reverse Vowels of a String

- Problem Link: [Click Here](https://leetcode.com/problems/reverse-vowels-of-a-string/?envType=study-plan-v2&envId=leetcode-75)

## Solutions:

### Java Solution

```java
class Solution {
    private boolean isVowel(char c) {
      return "AEIOUaeiou".indexOf(c) != -1;
    }
    private void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public String reverseVowels(String s) {
      char[] ca = s.toCharArray();
      int l = 0, r = ca.length-1;

      while (l < r) {
        while (l < r && !isVowel(ca[l])) l ++;
        while (l < r && !isVowel(ca[r])) r --;

        // swap
        if (l < r) {
          swap(ca, l, r);
          l ++;
          r --;
        }
      }  
      return new String(ca);
    }
}
```