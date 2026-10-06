//Approach-2 (without using stack)
//T.C : O(n)
//S.C : O(1)
class Solution {
    public int minAddToMakeValid(String s) {
        int size = 0; // Tracks unmatched opening parentheses '('
        int open = 0; // Tracks unmatched closing parentheses ')'

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                size++; // Increment for each unmatched opening parenthesis
            } else if (size > 0) {
                size--; // Match an opening parenthesis if available
            } else {
                open++; // Unmatched closing parenthesis
            }
        }

        return open + size; // Sum of unmatched opening and closing parentheses
    }
}