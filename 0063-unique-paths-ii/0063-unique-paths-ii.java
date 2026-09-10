class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        
        // Create a memoization table initialized with -1
        int[][] dp = new int[m][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        // Start the recursive computation from the top-left cell
        return solve(0, 0, m, n, obstacleGrid, dp);
    }

    public int solve(int i , int j, int m , int n,int[][] obstacleGrid, int[][] dp){


        if(i >= m || i < 0 || j >= n || j < 0 || obstacleGrid[i][j] == 1 ){
            return 0;
        }

        //if already computed

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        if(i == m-1 && j == n-1){
            return 1;
        }

        //check directions
        int right = solve(i + 1, j, m, n, obstacleGrid, dp);
        int down  = solve(i, j + 1, m, n, obstacleGrid, dp);

        return dp[i][j] = right + down;

    }
}