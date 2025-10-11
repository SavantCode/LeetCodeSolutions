import java.util.*;

class Solution {
    public long maximumTotalDamage(int[] power) {
        // Step 1: Count frequency of each power value
        Map<Integer, Integer> freq = new HashMap<>();
        for (int p : power) {
            freq.put(p, freq.getOrDefault(p, 0) + 1);
        }

        // Step 2: Extract and sort unique damage values
        List<Integer> unique = new ArrayList<>(freq.keySet());
        Collections.sort(unique);

        // Step 3: Dynamic Programming
        int n = unique.size();
        long[] dp = new long[n];

        for (int i = 0; i < n; i++) {
            int val = unique.get(i);
            long totalDamage = (long) val * freq.get(val);

            // Binary search for previous index j where unique.get(j) <= val - 3
            int j = i - 1;
            while (j >= 0 && unique.get(j) >= val - 2) {
                j--;
            }

            if (j >= 0) {
                totalDamage += dp[j];
            }

            dp[i] = Math.max(i > 0 ? dp[i - 1] : 0, totalDamage);
        }

        return dp[n - 1];
    }
}
