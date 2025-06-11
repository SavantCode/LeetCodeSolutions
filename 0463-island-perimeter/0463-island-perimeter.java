class Solution {
    int m;
    int n;
    int perimeter;

    void dfs(int[][] grid, int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 0) {
            perimeter++;
            return;

        }
        if (grid[i][j] == -1) {
            return;
        }
        grid[i][j] = -1; // mark visited

        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }

    public int islandPerimeter(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        perimeter = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j);
                    return perimeter;
                }
            }
        }
        return -1;
    }

}