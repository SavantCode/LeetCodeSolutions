class Solution {
    public String makeFancyString(String s) {
        StringBuilder result = new StringBuilder();

        int i = 0;
        while (i < s.length()) {
            int len = result.length();
            if (len >= 2 && result.charAt(len - 1) == s.charAt(i) && result.charAt(len - 2) == s.charAt(i)) {
                i++;
                continue;
            }
            result.append(s.charAt(i));
            i++;
        }

        return result.toString();
    }
}

/*

| Resource      | Complexity      |
| ------------- | --------------- |
| Time          |  O(n)           |
| Space (extra) |  O(k)  ≤  O(n)  |

k is length of "result"
n is length of string s

*/