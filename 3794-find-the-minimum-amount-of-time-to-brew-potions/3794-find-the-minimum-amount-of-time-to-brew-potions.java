class Solution {
    public long minTime(int[] skill, int[] mana) {
        int n = skill.length;
        int m = mana.length;
        
        // finishTime[i] = time when wizard i finishes current potion
        long[] finishTime = new long[n];

        // For each potion
        for (int j = 0; j < m; ++j) {
            // First wizard starts immediately after previous potion
            finishTime[0] += (long) mana[j] * skill[0];

            // Forward pass: ensure each wizard starts after the previous one finishes
            for (int i = 1; i < n; ++i) {
                finishTime[i] = Math.max(finishTime[i], finishTime[i - 1]) + (long) mana[j] * skill[i];
            }

            // Backward pass: allow earlier wizards to update based on next one's completion
            for (int i = n - 1; i > 0; --i) {
                finishTime[i - 1] = finishTime[i] - (long) mana[j] * skill[i];
            }
        }

        // Return the time when the last wizard finishes the last potion
        return finishTime[n - 1];
    }
}
