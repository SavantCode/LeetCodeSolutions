//T.C : O(n)
//S.C : O(1)
class Solution {
    public String makeFancyString(String s) {
        int n = s.length();
        StringBuilder result = new StringBuilder();

        // Start with the first character
        result.append(s.charAt(0));
        int freq = 1;

        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == result.charAt(result.length() - 1)) {
                freq++;
                if (freq < 3) {
                    result.append(s.charAt(i));
                }
            } else {
                result.append(s.charAt(i));
                freq = 1;
            }
        }

        return result.toString();
    }
}


/*
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


| Resource      | Complexity      |
| ------------- | --------------- |
| Time          |  O(n)           |
| Space (extra) |  O(k)  ≤  O(n)  |

k is length of "result"
n is length of string s

*/