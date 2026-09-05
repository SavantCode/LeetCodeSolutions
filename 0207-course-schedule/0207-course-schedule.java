class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        List<List<Integer>> adj = new ArrayList<>();
        int n = numCourses;

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // Build directed graph
        // [a, b] means: b -> a
        for (int[] prerequisite : prerequisites) {
            int pre = prerequisite[1];
            int post = prerequisite[0];

            adj.get(pre).add(post);
        }

        // MISTAKE 1:
        // A single visited[] array is NOT enough for directed cycle detection.
        //
        // Example:
        // 0 -> 1 -> 2
        //
        // After DFS(0), nodes 0,1,2 are visited.
        // Later, if another node points to 1, seeing visited[1] does NOT
        // necessarily mean there is a cycle.
        //
        // We need:
        // visited[] = has this node ever been visited?
        // path[]    = is this node currently in the DFS recursion path?
        boolean[] visited = new boolean[n];
        boolean[] path = new boolean[n];

        for (int i = 0; i < n; i++) {

            // If a cycle exists anywhere, we cannot finish all courses.
            if (!dfs(i, adj, visited, path)) {
                return false;
            }
        }

        return true; // MISTAKE 2: Your canFinish() was missing a return statement.
    }

    public boolean dfs(
            int source,
            List<List<Integer>> adj,
            boolean[] visited,
            boolean[] path) {

        // If source is already in the CURRENT DFS path,
        // we found a cycle.
        if (path[source]) {
            return false;
        }

        // If already completely explored, no need to explore again.
        if (visited[source]) {
            return true;
        }

        visited[source] = true;
        path[source] = true;

        for (int neighbour : adj.get(source)) {

            if (!dfs(neighbour, adj, visited, path)) {
                return false;
            }
        }

        // We are leaving this node's DFS path.
        path[source] = false;

        return true; // MISTAKE 3: Your dfs() was missing a return statement.
    }
}
