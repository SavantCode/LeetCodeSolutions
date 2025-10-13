import java.util.*;

class Solution {
    public List<String> removeAnagrams(String[] words) {
        List<String> result = new ArrayList<>();

        for (String word : words) {
            if (result.isEmpty() || !isAnagram(result.get(result.size() - 1), word)) {
                result.add(word);
            }
            // Else: it's an anagram of the last word, so skip (i.e., remove the word by not adding)
        }

        return result;
    }

    private boolean isAnagram(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;

        int[] count = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            count[s1.charAt(i) - 'a']++;
            count[s2.charAt(i) - 'a']--;
        }

        for (int c : count) {
            if (c != 0)
                return false;
        }

        return true;
    }
}
