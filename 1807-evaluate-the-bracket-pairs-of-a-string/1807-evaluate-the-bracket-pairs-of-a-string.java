import java.util.*;

class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        // 1. Populate the hash map
        Map<String, String> map = new HashMap<>();
        for (List<String> pair : knowledge) {
            map.put(pair.get(0), pair.get(1));
        }

        StringBuilder result = new StringBuilder();
        StringBuilder key = new StringBuilder();
        boolean isInsideKey = false;

        // 2. Process string character by character
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                isInsideKey = true;
            } else if (c == ')') {
                isInsideKey = false;
                // Replace key with mapped value or "?"
                result.append(map.getOrDefault(key.toString(), "?"));
                key.setLength(0); // Reset key buffer
            } else {
                if (isInsideKey) {
                    key.append(c);
                } else {
                    result.append(c);
                }
            }
        }

        return result.toString();
    }
}