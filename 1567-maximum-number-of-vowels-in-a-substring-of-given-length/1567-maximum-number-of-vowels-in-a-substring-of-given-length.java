class Solution {
    public boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }

    public int maxVowels(String s, int k) {
        int n = s.length();
        int maxV = 0;
        int count = 0;
        int i = 0, j = 0;

        while (j < n) {
            if (isVowel(s.charAt(j))) {
                count++;
            }

            if (j - i + 1 == k) {
                maxV = Math.max(maxV, count);
                if (isVowel(s.charAt(i))) {
                    count--;
                }
                i++;
            }

            j++;
        }

        return maxV;
    }
}

// Time Complexity: O(n)
// Space Complexity: O(1)