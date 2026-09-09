//Approach-2 (using Bottom Up)
//T.C : O(m*n)
//S.C : O(m*n)

class Solution {
    public int uniquePaths(int m, int n) {
        // Create a 2D array for storing the number of ways to reach each cell
        int[][] t = new int[m][n];

        // Initialize the first row
        for (int col = 0; col < n; col++) {
            t[0][col] = 1; // Only one way to reach any cell in the first row
        }

        // Initialize the first column
        for (int row = 0; row < m; row++) {
            t[row][0] = 1; // Only one way to reach any cell in the first column
        }

        // Fill the rest of the table using the relation:
        // t[i][j] = t[i-1][j] + t[i][j-1]
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                t[i][j] = t[i - 1][j] + t[i][j - 1];
            }
        }

        // The bottom-right cell contains the total number of unique paths
        return t[m - 1][n - 1];
    }
}