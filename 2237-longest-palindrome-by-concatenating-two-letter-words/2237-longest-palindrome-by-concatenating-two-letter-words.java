//Approach - Using map
//T.C : O(n), where n = number of words
//S.C : O(n)
class Solution {
    public int longestPalindrome(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        int result = 0;

        for (String word : words) {
            String reversed = new StringBuilder(word).reverse().toString();

            if (map.getOrDefault(reversed, 0) > 0) {
                result += 4;
                map.put(reversed, map.get(reversed) - 1);
            } else {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }

        // Check for a word with both characters same to use in the center
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String word = entry.getKey();
            int count = entry.getValue();

            if (word.charAt(0) == word.charAt(1) && count > 0) {
                result += 2;
                break;
            }
        }

        return result;
    }
}