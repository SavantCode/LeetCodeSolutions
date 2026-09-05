import java.util.*;

class Solution {

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        // Create adjacency list
        List<List<Integer>> adj = new ArrayList<>();

        // Initialize the adjacency list
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        // Populate the adjacency list
        for (int[] item : prerequisites) {

            int to = item[0];
            int from = item[1];

            // from --> to
            adj.get(from).add(to);
        }

        // If cycle exists, we cannot finish all courses
        return !isCyclic(numCourses, adj);
    }


    // Function to detect cycle using BFS
    boolean isCyclic(int V, List<List<Integer>> adj) {

        // Array to store indegree of every vertex
        int[] indegree = new int[V];

        // Calculate indegree
        for (int i = 0; i < V; i++) {

            for (int neighbor : adj.get(i)) {

                // There is an incoming edge to neighbor
                indegree[neighbor]++;
            }
        }

        // Queue for vertices having indegree 0
        Queue<Integer> q = new LinkedList<>();

        // Add all vertices with indegree 0
        for (int i = 0; i < V; i++) {

            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        // Count how many vertices we process
        int count = 0;

        // BFS
        while (!q.isEmpty()) {

            // Remove the front vertex
            int node = q.poll();

            // We successfully processed this vertex
            count++;

            // Visit all neighbors
            for (int neighbor : adj.get(node)) {

                // Remove the dependency of node
                indegree[neighbor]--;

                // If indegree becomes 0,
                // this vertex can now be processed
                if (indegree[neighbor] == 0) {
                    q.add(neighbor);
                }
            }
        }

        // If all vertices were processed,
        // there is NO cycle.
        if (count == V) {
            return false;
        }

        // If some vertices could not be processed,
        // there IS a cycle.
        return true;
    }
}