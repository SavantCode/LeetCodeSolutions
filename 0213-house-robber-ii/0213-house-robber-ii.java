public class Solution {
        private int[] t;

        /**
         * Solves the problem from index 'i' to 'end' using recursion + memoization
         */
        private int solve(int[] nums, int i, int end) {
            if (i > end)
                return 0; // base case: no house to rob

            if (t[i] != -1)
                return t[i]; // already computed

            // Choose to take or skip the current house
            int take = nums[i] + solve(nums, i + 2, end); // take current house
            int skip = solve(nums, i + 1, end);           // skip current house

            return t[i] = Math.max(take, skip); // memoize and return the max
        }

        public int rob(int[] nums) {
            int n = nums.length;

            if (n == 1)
                return nums[0]; // only one house

            if (n == 2)
                return Math.max(nums[0], nums[1]); // two houses: pick max

            // Case 1: Include first house, exclude last (0 to n-2)
            t = new int[n];
            Arrays.fill(t, -1);
            int takeFirst = solve(nums, 0, n - 2);

            // Case 2: Exclude first house, include last (1 to n-1)
            t = new int[n];
            Arrays.fill(t, -1);
            int skipFirst = solve(nums, 1, n - 1);

            // Take the max of both cases
            return Math.max(takeFirst, skipFirst);
        }
    }