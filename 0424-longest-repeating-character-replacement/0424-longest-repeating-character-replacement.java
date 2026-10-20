class Solution {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int left = 0;
        int maxCount = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);
            count[currentChar - 'A']++;
            
            // Track the frequency of the most frequent character seen so far in the current window
            maxCount = Math.max(maxCount, count[currentChar - 'A']);

            // If the number of characters we need to replace (window length - maxCount) exceeds k,
            // shrink the window from the left
            if ((right - left + 1) - maxCount > k) {
                count[s.charAt(left) - 'A']--;
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}