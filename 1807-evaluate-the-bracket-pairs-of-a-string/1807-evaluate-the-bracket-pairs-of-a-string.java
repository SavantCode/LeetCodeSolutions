import java.util.*;

class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        // 1. Pre-size HashMap to avoid expensive rehashing
        Map<String, String> map = new HashMap<>(knowledge.size() * 2);
        for (List<String> pair : knowledge) {
            map.put(pair.get(0), pair.get(1));
        }

        char[] arr = s.toCharArray();
        int n = arr.length;
        StringBuilder result = new StringBuilder(n); // Pre-allocate capacity

        int i = 0;
        while (i < n) {
            if (arr[i] == '(') {
                int start = i + 1;
                // Move pointer directly to closing bracket
                while (arr[i] != ')') {
                    i++;
                }
                
                // Construct string key only when closing bracket is reached
                String key = new String(arr, start, i - start);
                result.append(map.getOrDefault(key, "?"));
            } else {
                result.append(arr[i]);
            }
            i++;
        }

        return result.toString();
    }
}