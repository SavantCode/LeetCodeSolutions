import java.util.Arrays;

class Solution {
    private int[] dp;

    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        dp = new int[n];
        Arrays.fill(dp, -1);
        
        // You can start from step 0 or step 1
        return Math.min(solve(0, cost, n), solve(1, cost, n));
    }

    private int solve(int idx, int[] cost, int n) {
        // Base case: reached top of the floor
        if (idx >= n) {
            return 0;
        }

        // Return memoized result if already calculated
        if (dp[idx] != -1) {
            return dp[idx];
        }

        // Option 1: Pay cost[idx] and take 1 step
        int stepOne = cost[idx] + solve(idx + 1, cost, n);

        // Option 2: Pay cost[idx] and take 2 steps
        int stepTwo = cost[idx] + solve(idx + 2, cost, n);

        return dp[idx] = Math.min(stepOne, stepTwo);
    }
}