import java.util.*;

class Solution {

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        // Create adjacency list storing pairs of {neighbor, weight}
        List<List<int[]>> adj = createAdj(n, edges);

        int smallestCount = Integer.MAX_VALUE;
        int resultCity = -1;

        for (int i = 0; i < n; i++) {
            int[] dist = dijkstra(i, n, adj);

            // Count reachable cities within distanceThreshold
            int reachableCount = 0;
            for (int j = 0; j < n; j++) {
                if (i != j && dist[j] <= distanceThreshold) {
                    reachableCount++;
                }
            }

            // Pick smaller count, or higher city index on a tie
            if (reachableCount <= smallestCount) {
                smallestCount = reachableCount;
                resultCity = i;
            }
        }

        return resultCity;
    }

    private List<List<int[]>> createAdj(int n, int[][] edges) {
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // Add both directions because edges are undirected
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            adj.get(u).add(new int[] { v, w });
            adj.get(v).add(new int[] { u, w });
        }

        return adj;
    }

    private int[] dijkstra(int src, int n, List<List<int[]>> adj) {
        // PriorityQueue ordered by distance: {node, current_distance}
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) ->
            Integer.compare(a[1], b[1])
        );
        pq.offer(new int[] { src, 0 });

        int[] distArray = new int[n];
        Arrays.fill(distArray, Integer.MAX_VALUE);
        distArray[src] = 0;

        while (!pq.isEmpty()) {
            int[] data = pq.poll();
            int u = data[0];
            int d = data[1];

            if (d > distArray[u]) continue;

            for (int[] neighbor : adj.get(u)) {
                int v = neighbor[0];
                int weight = neighbor[1];

                if (distArray[u] + weight < distArray[v]) {
                    distArray[v] = distArray[u] + weight;
                    pq.offer(new int[] { v, distArray[v] });
                }
            }
        }

        return distArray;
    }
}