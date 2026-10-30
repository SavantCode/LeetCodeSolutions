import java.util.*;

class Solution {
    public int shortestPath(int totalNodes, int[][] edges, String nodeLabels, int maxAllowedConsecutiveSameLabels) {
        // Build the adjacency list representation of the graph
        List<int[]>[] adjacencyList = new List[totalNodes];
        Arrays.setAll(adjacencyList, nodeIndex -> new ArrayList<>());
        
        for (int[] edge : edges) {
            int u = edge[0];      // Source node
            int v = edge[1];      // Destination node
            int weight = edge[2]; // Edge weight / distance
            adjacencyList[u].add(new int[]{v, weight});
        }

        // bestRun[node]: stores the minimum consecutive label run count seen when visiting this node
        int[] bestRun = new int[totalNodes];
        Arrays.fill(bestRun, maxAllowedConsecutiveSameLabels + 1);

        // Min-Priority Queue to store path states: [accumulatedDistance, consecutiveRunCount, currentNode]
        // Sorted automatically by accumulatedDistance (index 0)
        PriorityQueue<long[]> minHeap = new PriorityQueue<>(Comparator.comparingLong(state -> state[0]));
        minHeap.add(new long[]{0, 1, 0}); // Start at node 0 with distance 0 and initial run count of 1

        while (!minHeap.isEmpty()) {
            long[] currentState = minHeap.poll();
            long currentDistance = currentState[0];
            int currentRun = (int) currentState[1];
            int currentNode = (int) currentState[2];

            // If we've reached this node before with an equal or smaller run count, skip it (pruning)
            if (currentRun >= bestRun[currentNode]) {
                continue;
            }

            // If we reached the destination node, return the shortest distance
            if (currentNode == totalNodes - 1) {
                return (int) currentDistance;
            }

            // Mark the current node with this run count
            bestRun[currentNode] = currentRun;

            // Explore all neighboring nodes
            for (int[] edge : adjacencyList[currentNode]) {
                int neighborNode = edge[0];
                int edgeWeight = edge[1];

                // If neighbor's label matches current node's label, increment run count; otherwise, reset to 1
                int nextRun = (nodeLabels.charAt(neighborNode) == nodeLabels.charAt(currentNode)) 
                              ? currentRun + 1 
                              : 1;

                // Push to heap only if the new run count is strictly better (smaller) than previous visits
                if (nextRun <= maxAllowedConsecutiveSameLabels && nextRun < bestRun[neighborNode]) {
                    minHeap.add(new long[]{currentDistance + edgeWeight, nextRun, neighborNode});
                }
            }
        }

        // If destination is unreachable, return -1
        return -1;
    }
}