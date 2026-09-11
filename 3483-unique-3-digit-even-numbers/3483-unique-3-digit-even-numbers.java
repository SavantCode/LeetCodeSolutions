class Solution {
    public int totalNumbers(int[] digits) {

        int[] freq = new int[10];

        // Count how many times each digit occurs
        for (int digit : digits) {
            freq[digit]++;
        }

        int count = 0;

        // Check every 3-digit number
        for (int num = 100; num <= 999; num++) {

            // Must be even
            if (num % 2 != 0) {
                continue;
            }

            int n = num;

            int last = n % 10;
            n /= 10;

            int middle = n % 10;
            n /= 10;

            int first = n;

            // Check whether we have enough copies
            int[] used = new int[10];

            used[first]++;
            used[middle]++;
            used[last]++;

            boolean possible = true;

            for (int d = 0; d <= 9; d++) {
                if (used[d] > freq[d]) {
                    possible = false;
                    break;
                }
            }

            if (possible) {
                count++;
            }
        }

        return count;
    }
}
