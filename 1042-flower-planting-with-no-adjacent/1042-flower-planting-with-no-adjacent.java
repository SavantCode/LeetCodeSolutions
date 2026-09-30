import java.util.*;

class Solution {
    public int[] gardenNoAdj(int n, int[][] paths) {
        // FIXED: Passed total vertices `n` instead of `paths.length` so memory is allocated for all gardens
        List<List<Integer>> adj = getAdj(paths, n);
        
        // FIXED: Added missing semicolon `;` after 4
        int m = 4; 
        
        int[] color = new int[n];
        
        solve(0, adj, m, color, n);
        return color;
    }

    private static boolean solve(int node, List<List<Integer>> adj, int m, int[] color, int n) {
        if (node == n) return true;

        for (int c = 1; c <= m; c++) {
            if (isSafe(node, adj, color, c)) {
                color[node] = c;

                if (solve(node + 1, adj, m, color, n)) return true;

                color[node] = 0; // Backtrack
            }
        }
        return false;
    }

    private static boolean isSafe(int node, List<List<Integer>> adj, int[] color, int c) {
        for (int neighbor : adj.get(node)) {
            if (color[neighbor] == c) {
                return false;
            }
        }
        return true;
    }

    // FIXED: Changed parameter from `r` (paths length) to `n` (number of gardens)
    private static List<List<Integer>> getAdj(int[][] paths, int n) {
        List<List<Integer>> adj = new ArrayList<>();

        // FIXED: Loop goes up to `n` so every garden node (0 to n-1) gets its own list
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] path : paths) {
            // FIXED: Subtracted 1 from input node values to convert 1-based indexing (1 to n) to 0-based indexing (0 to n-1)
            int from = path[0] - 1;
            int to = path[1] - 1;

            adj.get(from).add(to);
            adj.get(to).add(from);
        }
        return adj;
    }
}
// FIXED: Removed the extra trailing closing brace `}` at the bottom