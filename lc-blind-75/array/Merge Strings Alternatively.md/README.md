# Merge Strings Alternatively

## Solutions:

### Java Solution

```java
class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder result = new StringBuilder();
        int n = word1.length(), m = word2.length();
        int i = 0, j = 0;
        int it = 0;

        while (i < n && j < m) {
            if (it % 2 == 0) result.append(word1.charAt(i ++));
            else result.append(word2.charAt(j ++));
            it ++;
        }

        while (i < n) {
            result.append(word1.substring(i));
            break;
        }
        while (j < m) {
            result.append(word2.substring(j));
            break;
        }

        return result.toString();
    }
}
```