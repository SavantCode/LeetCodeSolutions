import java.util.Stack;

class Solution {
    public char findTheDifference(String s, String t) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            stack.push(c);
        }

        for (char c : t.toCharArray()) {
            if (stack.contains(c)) {
                stack.remove(Character.valueOf(c));
            } else {
                return c;
            }
        }

        return '\0'; // fallback; t should always contain one extra character
    }
}
