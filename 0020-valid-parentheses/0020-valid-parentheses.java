import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // Push opening brackets onto the stack
            if (ch == '(' || ch == '[' || ch == '{') {
                st.push(ch);
            } else {
                // If stack is empty, there is no matching opening bracket
                if (st.isEmpty()) {
                    return false;
                }

                char top = st.pop();

                // Check for matching pair mismatch
                if ((ch == ')' && top != '(') ||
                    (ch == ']' && top != '[') ||
                    (ch == '}' && top != '{')) {
                    return false;
                }
            }
        }

        // Valid only if all opening brackets have been matched and popped
        return st.isEmpty();
    }
}