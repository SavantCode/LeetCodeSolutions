
// visited[node] = 0; // Not visited
// visited[node] = 1; // Currently in DFS path
// visited[node] = 2; // Completely processed

class Solution {
    
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        // Create adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        // Create directed graph
        // [course, prerequisite] => prerequisite -> course
        for (int i = 0; i < prerequisites.length; i++) {

            int course = prerequisites[i][0];
            int prerequisite = prerequisites[i][1];

            adj.get(prerequisite).add(course);
        }

        // 0 = not visited
        // 1 = currently visiting
        // 2 = completely processed
        int[] visited = new int[numCourses];

        // Stores nodes according to finishing time
        Stack<Integer> stack = new Stack<>();

        // Run DFS for every node
        // This also handles disconnected graphs
        for (int i = 0; i < numCourses; i++) {

            if (visited[i] == 0) {

                // If cycle is found, impossible to finish courses
                if (dfs(i, adj, visited, stack)) {
                    return new int[0];
                }
            }
        }

        // Pop stack to get topological ordering
        int[] result = new int[numCourses];

        int index = 0;

        while (!stack.isEmpty()) {
            result[index] = stack.pop();
            index++;
        }

        return result;
    }


    // DFS function
    // Returns true if cycle is detected
    public boolean dfs(
        int node,
        ArrayList<ArrayList<Integer>> adj,
        int[] visited,
        Stack<Integer> stack
    ) {

        // Mark node as currently visiting
        visited[node] = 1;

        // Visit all neighbours
        for (int neighbour : adj.get(node)) {

            // If neighbour is currently being visited,
            // we found a cycle.
            if (visited[neighbour] == 1) {
                return true;
            }

            // If neighbour has not been visited,
            // continue DFS.
            if (visited[neighbour] == 0) {

                if (dfs(neighbour, adj, visited, stack)) {
                    return true;
                }
            }
        }

        // Mark node as completely processed
        visited[node] = 2;

        // Push only after all neighbours are processed
        stack.push(node);

        return false;
    }
}
