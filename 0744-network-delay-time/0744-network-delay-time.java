import java.util.*;

class Solution {

    class Pair {
        int distance;
        int node;

        Pair(int distance, int node) {
            this.distance = distance;
            this.node = node;
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();

        // Step 1: Create adjacency list (1-based indexing)
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        //Step 2: Fill adjacency list with edges

        for (int[] time : times) {
            int u = time[0];
            int v = time[1];
            int w = time[2];

            ArrayList<Integer> edge = new ArrayList<>();
            edge.add(v);
            edge.add(w);
            adj.get(u).add(edge);
        }

        //Step 3: Call your Dijkstra function (n+1 because we're using 1-based indexing)
        int[] minDist = dijkstra(n + 1, adj, k);

        // Step 4: Find the maximum distance from source to any node
        int maxTime = 0;
        for (int i = 1; i <= n; i++) {
            if (minDist[i] == Integer.MAX_VALUE) {
                return -1;
            }
            maxTime = Math.max(maxTime, minDist[i]);
        }

        return maxTime;
    }

    public int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.distance));
        int[] result = new int[V];
        Arrays.fill(result, Integer.MAX_VALUE);

        result[S] = 0; // khud k khud se distance zero hi hota hai
        pq.add(new Pair(0, S));

        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            int dist = current.distance;
            int node = current.node;

            for (ArrayList<Integer> edge : adj.get(node)) {
                int adjNode = edge.get(0);
                int weight = edge.get(1);

                if (dist + weight < result[adjNode]) {
                    result[adjNode] = dist + weight;
                    pq.add(new Pair(result[adjNode], adjNode));
                }
            }
        }

        return result;
    }
}
