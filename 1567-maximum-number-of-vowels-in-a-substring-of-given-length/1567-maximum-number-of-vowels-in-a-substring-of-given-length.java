class Solution {
    public int maxVowels(String s, int k) {
        int count = 0;   // Current count of vowels in the window
        int maxVo = 0;   // Maximum vowels found in any window
        int n = s.length();

        // First, count vowels in the initial window of size k
        for (int i = 0; i < k; i++) {
            if ("aeiou".indexOf(s.charAt(i)) != -1) {
                count++;
            }
        }
        maxVo = count;

        // Slide the window from i = k to end of string
        for (int i = k; i < n; i++) {
            // Remove the vowel going out of the window
            if ("aeiou".indexOf(s.charAt(i - k)) != -1) {
                count--;
            }
            // Add the vowel coming into the window
            if ("aeiou".indexOf(s.charAt(i)) != -1) {
                count++;
            }
            // Update max vowels count
            maxVo = Math.max(maxVo, count);
        }

        return maxVo;
    }
}
// | **Complexity**       | **Explanation**                                      | **Value** |
// | -------------------- | ---------------------------------------------------- | --------- |
// | **Time Complexity**  | Single pass over the string, constant time checks    | O(n)      |
// | **Space Complexity** | Only uses fixed number of variables (counters, etc.) | O(1)      |
