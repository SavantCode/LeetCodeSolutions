    //     0
    //     ↓
    //     1
    //    / \
    //   ↓   ↓
    //   2   3
    //      /|\
    //     ↓ ↓ ↓
    //     4 5 6
    //     ↑
    //     7


class Solution {

    int dfs(List<Integer>[] adj, int[] quiet, int[] ans, int node) {

        // Initially assume current person is the quietest
        int x = node;

        for (int neighbour : adj[node]) {

            // If answer for this richer person
            // is not calculated yet
            if (ans[neighbour] == -1) {
                dfs(adj, quiet, ans, neighbour);
            }

            // Compare the quietest person found through "neighbour"
            // with the current best person
            if (quiet[ans[neighbour]] < quiet[x]) {
                x = ans[neighbour];
            }
        }

        // Store the answer for this person
        ans[node] = x;

        return x;
    }

    public int[] loudAndRich(int[][] richer, int[] quiet) {

        int n = quiet.length;

        // Graph: poorer -> richer
        List<Integer>[] adj = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        // Build graph
        for (int i = 0; i < richer.length; i++) {

            int rich = richer[i][0];
            int poor = richer[i][1];

            adj[poor].add(rich);
        }

        // ans[i] = quietest person among
        // i and everyone definitely richer than i
        int[] ans = new int[n];

        // -1 means answer has not been calculated
        Arrays.fill(ans, -1);

        // DFS for every person
        for (int i = 0; i < n; i++) {

            if (ans[i] == -1) {
                dfs(adj, quiet, ans, i);
            }
        }

        return ans;
    }
}