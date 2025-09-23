// | Complexity Type  | Value  |
// | ---------------- | ------ |
// | Time Complexity  | `O(n)` |
// | Space Complexity | `O(1)` |

class Solution {
    public boolean detectCapitalUse(String word) {
        int capitalCount = 0;
        int n = word.length();

        for (int i = 0; i < n; i++) {
            if (Character.isUpperCase(word.charAt(i))) {
                capitalCount++;
            }
        }

        // Case 1: All letters are uppercase
        // Case 2: All letters are lowercase
        // Case 3: Only the first letter is uppercase
        return capitalCount == n || 
               capitalCount == 0 || 
               (capitalCount == 1 && Character.isUpperCase(word.charAt(0)));
    }
}
