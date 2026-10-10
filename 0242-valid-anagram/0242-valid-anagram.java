class Solution {
    public boolean isAnagram(String s, String t) {
        // If lengths differ, they can't be anagrams
        if (s.length() != t.length()) {
            return false;
        }

        int[] letters = new int[26];

        // Increment count for string s
        char[] str = s.toCharArray();
        for (int i = 0; i < str.length; i++) {
            int curr = str[i] - 'a';
            letters[curr]++;
        }

        // Decrement count for string t
        for (int i = 0; i < t.length(); i++) {
            int curr = t.charAt(i) - 'a';
            letters[curr]--;
        }

        // Verify all character frequency counts are zero
        for (int count : letters) {
            if (count != 0) {
                return false;
            }
        }

        return true;
    }
}