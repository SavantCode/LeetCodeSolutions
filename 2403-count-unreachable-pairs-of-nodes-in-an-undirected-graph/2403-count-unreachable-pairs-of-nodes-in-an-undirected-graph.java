class Solution {
    // Step -1: Copy and paste DSU code
    int[] parent;
    int[] rank;

    int find(int x) {
        if (x == parent[x])
            return x;
        return parent[x] = find(parent[x]);
    }

    void union(int x, int y) {
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

    public long countPairs(int n, int[][] edges) {
        parent = new int[n];
        rank = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        // Step -2: Making components
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            union(u, v); // You missed this in C++ version originally
        }

        // Step -3: Map for storing "parent(component)" ---> size of component
        Map<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int papaji = find(i); // parent or representative
            mp.put(papaji, mp.getOrDefault(papaji, 0) + 1);
        }

        // Step -4: Find result from map
        long result = 0;
        long remainingNodes = n;

        for (int size : mp.values()) {
            result += size * (remainingNodes - size);
            remainingNodes -= size;
        }

        return result;
    }
}
