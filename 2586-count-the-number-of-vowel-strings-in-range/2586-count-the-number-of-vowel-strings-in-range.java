import java.util.Set;

class Solution {
    public int vowelStrings(String[] words, int left, int right) {

        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');

        int count = 0;

        for (int i = left; i <= right; i++) {

            char firstChar = words[i].charAt(0);
            char lastChar = words[i].charAt(words[i].length() - 1);

            if (vowels.contains(firstChar) && vowels.contains(lastChar)) {
                count++;
            }
        }

        return count;
    }
}
