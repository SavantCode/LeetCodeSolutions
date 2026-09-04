// Time:  O(n)
// Space: O(n)

class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {

        // Special case
        if (n == 1) {
            return new ArrayList<>(Arrays.asList(0));
        }

        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // Build graph
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        // Store degree of every node
        int[] degree = new int[n];

        for (int i = 0; i < n; i++) {
            degree[i] = adj.get(i).size();
        }

        // Put all leaves into queue
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (degree[i] == 1) {
                q.offer(i);
            }
        }

        // Keep removing leaves until only 1 or 2 nodes remain
        int remainingNodes = n;

        while (remainingNodes > 2) {

            int size = q.size();

            remainingNodes -= size;

            for (int i = 0; i < size; i++) {

                int leaf = q.poll();

                // Remove this leaf from its neighbors
                for (int neighbour : adj.get(leaf)) {

                    degree[neighbour]--;

                    // Neighbor has now become a leaf
                    if (degree[neighbour] == 1) {
                        q.offer(neighbour);
                    }
                }
            }
        }

        // The remaining nodes are the MHT roots
        return new ArrayList<>(q);
    }
}
