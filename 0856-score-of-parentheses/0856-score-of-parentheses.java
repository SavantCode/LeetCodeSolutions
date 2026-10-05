import java.util.Stack;

class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        st.push(0); // Holds the base score at current level

        for (char c : s.toCharArray()) {
            if (c == '(') {
                st.push(0); // Start a new inner score level
            } else {
                int v = st.pop(); // Score inside the current parentheses
                int w = st.pop(); // Score of the outer level before this pair
                
                // If v == 0, it was an empty pair "()", so it contributes 1.
                // Otherwise, it was nested "(A)", so it contributes 2 * v.
                st.push(w + Math.max(2 * v, 1));
            }
        }

        return st.pop();
    }
}