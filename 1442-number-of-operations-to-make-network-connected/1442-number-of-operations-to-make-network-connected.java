class Solution {
    
    int[] parent;
    int[] rank;

    public int find(int x) {
        if (parent[x] == x)
            return x;
        return parent[x] = find(parent[x]);  // Path compression
    }

    public void union(int x, int y) {
        int x_parent = find(x);
        int y_parent = find(y);

        if (x_parent == y_parent)
            return;

        if (rank[x_parent] > rank[y_parent]) {
            parent[y_parent] = x_parent;
        } else if (rank[x_parent] < rank[y_parent]) {
            parent[x_parent] = y_parent;
        } else {
            parent[x_parent] = y_parent;
            rank[y_parent]++;
        }
    }

    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1)
            return -1;

        parent = new int[n];
        rank = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        int components = n;
        for (int[] conn : connections) {
            if (find(conn[0]) != find(conn[1])) {
                components--;
                union(conn[0], conn[1]);
            }
        }

        return components - 1;
    }
}
