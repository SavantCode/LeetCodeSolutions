
//Approach-2 (Calculating from Depth)
//T.C : O(n)
//S.C : O(1)
class Solution {
    public int scoreOfParentheses(String s) {
        int score = 0;
        int depth = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                depth++;
            } else {
                depth--;
                if (s.charAt(i - 1) == '(') {
                    score += (1 << depth); // i.e. 2^depth
                }
            }
        }
        return score;
    }
}