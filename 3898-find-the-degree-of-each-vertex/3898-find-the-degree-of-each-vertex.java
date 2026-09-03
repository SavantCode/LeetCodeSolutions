import java.util.*;

class Solution {
    public int[] findDegrees(int[][] matrix) {
        
        int n = matrix.length;
        int m = matrix[0].length;

        List<List<Integer>> adj = new ArrayList<>();

        for (int x = 0; x < n; x++) {
            // Each iteration adds one new list to adj
            //adj = [ [], [], [] ]


            // ❌ Mistake: adj.get(x) tries to access an existing list.
            // Since adj is empty, this causes IndexOutOfBoundsException.
            // ✅ Correction: use add() to create and add a new list.
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                // ❌ Mistake: You were adding an edge for every matrix cell.
                // We should only add an edge when matrix[i][j] == 1.
                // ❌ Also, for a directed adjacency matrix, don't add
                // the reverse edge here.
                // ✅ Correction:
                if (matrix[i][j] == 1) {
                    adj.get(i).add(j);
                }
            }
        }

        int[] result = new int[n];

        for (int i = 0; i < n; i++) {

            // ❌ Mistake: You wrote list.size(), but the variable
            // was named lis.
            // ❌ Also, idx was never incremented.
            // ✅ Correction: directly use i as the index.
            result[i] = adj.get(i).size();
        }

        return result;
    }
}
