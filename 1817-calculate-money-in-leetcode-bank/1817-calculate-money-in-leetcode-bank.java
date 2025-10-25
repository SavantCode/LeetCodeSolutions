// Complexity
// Time: O(n) — single loop through all days.
// Space: O(1) — only uses constant variables.

class Solution {
    public int totalMoney(int n) {
        int leetcodeBank = 0;
        int weekCount = 1;
        int i = 0;

        int dayCount = 1;
        int count = 1;
        while (i < n) {

            if (dayCount > 7) {
                dayCount = 1;
                weekCount++;
                count = weekCount;
            }

            leetcodeBank = leetcodeBank + count;
            dayCount++;
            count++;
            i++;

        }
        return leetcodeBank;

    }
}