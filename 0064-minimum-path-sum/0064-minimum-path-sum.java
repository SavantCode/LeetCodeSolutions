class Solution {

    public int minPathSum(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        int[][] dp = new int[n][m];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return solve(0, 0, grid, dp, n, m);
    }

    public int solve(int i, int j, int[][] grid, int[][] dp, int n, int m) {

        // Out of bounds
        if (i >= n || j >= m) {
            return Integer.MAX_VALUE;
        }

        // Destination
        if (i == n - 1 && j == m - 1) {
            return grid[i][j];
        }

        // Already calculated
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int right = solve(i, j + 1, grid, dp, n, m);
        int down = solve(i + 1, j, grid, dp, n, m);

        return dp[i][j] = grid[i][j] + Math.min(right, down);
    }
}
