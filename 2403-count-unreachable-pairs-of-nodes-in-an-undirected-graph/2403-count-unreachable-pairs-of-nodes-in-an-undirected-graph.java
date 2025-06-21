import java.util.*;

public class Solution {

    int[] parent;
    int[] rank;

    // Find function with path compression
    public int find(int x) {
        if (parent[x] == x)
            return x;
        return parent[x] = find(parent[x]);
    }

    // Union function with union by rank
    public void union(int x, int y) {
        int xParent = find(x);
        int yParent = find(y);

        if (xParent == yParent)
            return;

        if (rank[xParent] > rank[yParent]) {
            parent[yParent] = xParent;
        } else if (rank[xParent] < rank[yParent]) {
            parent[xParent] = yParent;
        } else {
            parent[xParent] = yParent;
            rank[yParent]++;
        }
    }

    public long countPairs(int n, int[][] edges) {
        parent = new int[n];
        rank = new int[n];

        // Initialize DSU
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }

        // Union all connected pairs
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            union(u, v);
        }

        // Count size of each connected component
        Map<Integer, Integer> componentSize = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int root = find(i);
            componentSize.put(root, componentSize.getOrDefault(root, 0) + 1);
        }

        // Calculate the number of unreachable pairs
        long result = 0;
        long remainingNodes = n;

        for (int size : componentSize.values()) {
            result += (long) size * (remainingNodes - size);
            remainingNodes -= size;
        }

        return result;
    }
}
