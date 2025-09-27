public class Solution {

    // Memoization array to store results of subproblems
    private int[] memo;

    // Recursive function to calculate max amount
    private int solve(int[] nums, int i, int n) {
        // Base case: if index goes out of bounds, return 0
        if (i >= n) {
            return 0;
        }

        // If we've already solved this subproblem, return stored result
        if (memo[i] != -1) {
            return memo[i];
        }

        // Option 1: Rob current house and move to i + 2
        int take = nums[i] + solve(nums, i + 2, n);

        // Option 2: Skip current house and move to i + 1
        int skip = solve(nums, i + 1, n);

        // Store the maximum of the two options in memo and return it
        return memo[i] = Math.max(take, skip);
    }

    // Main rob function that initializes memo and starts recursion
    public int rob(int[] nums) {
        int n = nums.length;

        // Initialize memo array with -1 to indicate uncomputed values
        memo = new int[101]; // Problem says 1 <= nums.length <= 100
        Arrays.fill(memo, -1);

        // Start solving from index 0
        return solve(nums, 0, n);
    }


}