// Time Complexity: O(n^2)
// Space Complexity: O(n)


class Solution {
    public boolean hasSameDigits(String s) {
        while (s.length() > 2) {
            StringBuilder newS = new StringBuilder();
            for (int i = 0; i < s.length() - 1; i++) {
                int a = s.charAt(i) - '0';
                int b = s.charAt(i + 1) - '0';
                newS.append((a + b) % 10);
            }
            s = newS.toString();
        }

        return s.charAt(0) == s.charAt(1);
    }
}
