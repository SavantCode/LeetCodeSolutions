//optimised DP constant space
// Time: O(n)
// Space: O(1)
class Solution {
     public int climbStairs(int n) {
        // Step 1: Handle small inputs
        if (n == 1 || n == 2)
            return n;

        // Step 2: Create a DP array to store the number of ways for each step
        int[] dp = new int[n + 1]; // dp[i] = number of ways to reach step i

        // Step 3: Initialize the base cases
        dp[0] = 0; // Not really used
        dp[1] = 1; // Only 1 way to climb 1 stair
        dp[2] = 2; // Two ways to climb 2 stairs (1+1 or 2)

        // Step 4: Fill the table iteratively
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2]; // Ways to reach step i
        }

        // Step 5: Return the result for step n
        return dp[n];
    }
}