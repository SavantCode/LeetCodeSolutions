class Solution {
    public int findCenter(int[][] edges) {

        // MISTAKE 1:
        // adj is initially empty.
        // We need to create a list for every node before using adj.get(u).
        int n = edges.length + 1;

        List<List<Integer>> adj = new ArrayList<>();

        // Initialize adjacency list
        // Node numbers start from 1, so we use <= n.
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            // MISTAKE 2:
            // You only had:
            // adj.get(u).add(v);
            //
            // But this is an UNDIRECTED graph.
            // So we need to add both directions.
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int max = Integer.MIN_VALUE;

        // MISTAKE 3:
        // n = adj.size() would work here because we created n + 1 lists,
        // but node 0 is not an actual node.
        // So we iterate from 1 to n.
        int center = -1;

        for (int i = 1; i <= n; i++) {

            int currLen = adj.get(i).size();

            // MISTAKE 4:
            // You were only storing the maximum degree:
            // max = Math.max(currLen, max);
            //
            // But we need to RETURN THE NODE having maximum degree,
            // not the degree itself.
            if (currLen > max) {
                max = currLen;
                center = i;
            }
        }

        // MISTAKE 5:
        // return max;
        // This would return the maximum degree.
        //
        // We need to return the node with maximum degree.
        return center;
    }
}
