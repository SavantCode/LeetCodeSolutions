class Solution {

    public int minimumTotal(List<List<Integer>> triangle) {

        int n = triangle.size();

        int[][] dp = new int[n][];

        for (int i = 0; i < n; i++) {
            dp[i] = new int[triangle.get(i).size()];
            Arrays.fill(dp[i], Integer.MIN_VALUE);
        }

        return solve(0, 0, triangle, dp);
    }

    public int solve(int i, int j, List<List<Integer>> triangle, int[][] dp) {

        // Last row
        if (i == triangle.size() - 1) {
            return triangle.get(i).get(j);
        }

        // Already calculated
        if (dp[i][j] != Integer.MIN_VALUE) {
            return dp[i][j];
        }

        int take_currIdx = solve(i + 1, j, triangle, dp);

        int take_nextIdx  = solve(i + 1, j + 1, triangle, dp);

        dp[i][j] = triangle.get(i).get(j)
                 + Math.min(take_currIdx, take_nextIdx);

        return dp[i][j];
    }
}
