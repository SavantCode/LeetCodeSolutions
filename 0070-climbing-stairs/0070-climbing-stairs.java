//optimised using DP memoisation
class Solution {
    int[] memo = new int[46];

    public int climbStairs(int n) {
        Arrays.fill(memo, -1); // Now this is inside a method
        return solve(n);
    }

    private int solve(int n) {
        if (n == 0 || n == 1 || n == 2) {
            return n;
        }

        if (memo[n] != -1) {
            return memo[n];
        }

        int a = solve(n - 1); // taking one step
        int b = solve(n - 2); // taking two steps

        return memo[n] = a + b;
    }
}
