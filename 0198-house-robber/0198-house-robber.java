class Solution {
    public int rob(int[] nums) {
        int dp[] = new int[101];

        Arrays.fill(dp, -1);
        int n = nums.length;
        return solve(0, n, nums, dp);
    }

    public int solve(int house, int n, int[] nums, int[] dp) {
        if (house >= n) {
            return 0;
        }
        if(dp[house] != -1){
            return dp[house];
        };

        int take = nums[house] + solve(house + 2, n, nums, dp);

        int notTake = solve(house + 1, n, nums, dp);

        return dp[house] =  Math.max(take, notTake);
    }
}