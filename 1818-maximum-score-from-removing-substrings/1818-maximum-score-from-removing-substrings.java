class Solution {
    public int maximumGain(String s, int x, int y) {
        // Determine which substring removal yields more points
        if (x > y) {
            // Remove "ab" first, then "ba"
            return removeAndCount(s, 'a', 'b', x, y);
        } else {
            // Remove "ba" first, then "ab"
            return removeAndCount(s, 'b', 'a', y, x);
        }
    }

    private int removeAndCount(String s, char first, char second, int firstPoints, int secondPoints) {
        int total = 0;
        StringBuilder stack1 = new StringBuilder();

        // First pass: remove first substring (either "ab" or "ba")
        for (char c : s.toCharArray()) {
            if (stack1.length() > 0 && stack1.charAt(stack1.length() - 1) == first && c == second) {
                stack1.deleteCharAt(stack1.length() - 1);
                total += firstPoints;
            } else {
                stack1.append(c);
            }
        }

        // Second pass: remove second substring from remaining string
        StringBuilder stack2 = new StringBuilder();
        for (int i = 0; i < stack1.length(); i++) {
            char c = stack1.charAt(i);
            if (stack2.length() > 0 && stack2.charAt(stack2.length() - 1) == second && c == first) {
                stack2.deleteCharAt(stack2.length() - 1);
                total += secondPoints;
            } else {
                stack2.append(c);
            }
        }

        return total;
    }
}
