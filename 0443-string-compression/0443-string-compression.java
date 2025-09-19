// Time Complexity  : 	O(n)	
// Space Complexity :	O(1)

class Solution {
    public int compress(char[] chars) {
        int return_length = 0; // This will act as the 'write' pointer
        int i = 0;             // Read pointer

        while (i < chars.length) {
            char curr_char = chars[i];
            int curr_count = 0;
            int curr_idx = i;

            // Count consecutive occurrences of curr_char
            while (i < chars.length && chars[i] == curr_char) {
                i++;
                curr_count++;
            }

            // Write the current character at return_length
            chars[return_length++] = curr_char;

            // If count > 1, convert count to string and write each digit
            if (curr_count > 1) {
                for (char c : String.valueOf(curr_count).toCharArray()) { //TC: log(count),In worst case, this is O(log n) if one character repeats n times (e.g., ['a','a','a',...,'a']).
                    chars[return_length++] = c;
                }
            }
        }

        return return_length;
    }
}
