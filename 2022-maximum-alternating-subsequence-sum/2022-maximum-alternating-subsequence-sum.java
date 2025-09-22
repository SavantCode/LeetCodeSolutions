//Approach-1 (Recursion + Memo) (Time Complexity - n*2 : We visit all states of t once)
class Solution {
    int n;
    Long[][] memo;

    public long solve(int idx, int[] nums, boolean isEven) {
        if (idx >= n)
            return 0;

        int evenFlag = isEven ? 1 : 0;

        if (memo[idx][evenFlag] != null)
            return memo[idx][evenFlag];

        long skip = solve(idx + 1, nums, isEven);

        long val = nums[idx];
        if (!isEven) {
            val = -val;
        }

        long take = solve(idx + 1, nums, !isEven) + val;

        return memo[idx][evenFlag] = Math.max(skip, take);
    }

    public long maxAlternatingSum(int[] nums) {
        n = nums.length;
        memo = new Long[n][2];
        return solve(0, nums, true);
    }
}
