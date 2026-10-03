import java.util.Arrays;

class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n];
        Arrays.fill(dp, -1);

        return solve(0, nums, n, dp);
    }

    int solve(int idx, int[] nums, int n, int dp[]) {
        if (idx >= n) {
            return 0; // No more houses to rob, so 0 money added
        }

        if (dp[idx] != -1) {
            return dp[idx];
        }

        // Take: rob current house + solve for idx + 2
        int take = nums[idx] + solve(idx + 2, nums, n, dp);

        // Not take: skip current house + solve for idx + 1
        int notTake = solve(idx + 1, nums, n, dp);

        return dp[idx] = Math.max(take, notTake);
    }
}