import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        if (heights == null || heights.length == 0 || heights[0].length == 0) {
            return result;
        }

        int m = heights.length;
        int n = heights[0].length;

        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        // 1. Run DFS for top (Pacific) and bottom (Atlantic) rows
        for (int c = 0; c < n; c++) {
            dfs(0, c, heights, pacific, heights[0][c]);       // Top row -> Pacific
            dfs(m - 1, c, heights, atlantic, heights[m - 1][c]); // Bottom row -> Atlantic
        }

        // 2. Run DFS for left (Pacific) and right (Atlantic) columns
        for (int r = 0; r < m; r++) {
            dfs(r, 0, heights, pacific, heights[r][0]);       // Left col -> Pacific
            dfs(r, n - 1, heights, atlantic, heights[r][n - 1]); // Right col -> Atlantic
        }

        // 3. Find cells reachable by both oceans
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (pacific[r][c] && atlantic[r][c]) { // if it is possible to reach both oceans
                    result.add(Arrays.asList(r, c));
                }
            }
        }

        return result;
    }

    private void dfs(int r, int c, int[][] heights, boolean[][] ocean, int prevHeight) {
        int m = heights.length;
        int n = heights[0].length;

        // Base cases: Out of bounds, already visited, or height is lower than previous cell
        if (r < 0 || r >= m || c < 0 || c >= n || ocean[r][c] || heights[r][c] < prevHeight) {
            return;
        }

        ocean[r][c] = true; // Mark as visited

        // Explore 4 directions
        dfs(r + 1, c, heights, ocean, heights[r][c]);
        dfs(r - 1, c, heights, ocean, heights[r][c]);
        dfs(r, c + 1, heights, ocean, heights[r][c]);
        dfs(r, c - 1, heights, ocean, heights[r][c]);
    }
}