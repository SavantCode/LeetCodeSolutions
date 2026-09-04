class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n = graph.length;

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currPath = new ArrayList<>();

        currPath.add(0);

        dfs(graph, 0, n - 1, result, currPath);

        return result;
    }

    public static void dfs(int[][] graph, int source, int dest, List<List<Integer>> result, List<Integer> currPath) {

        // If destination is reached, current path is one valid answer
        if (source == dest) {
            // ❌ Mistake in original: result.add(currPath);
            // We need to add a COPY because currPath will be modified during backtracking.
            result.add(new ArrayList<>(currPath));
            return;
        }

        // ❌ Mistake in original: adj.get(source)
        // There is no 'adj'. graph[source] contains all neighbours.
        for (int neighbour : graph[source]) {

            // Add neighbour to current path
            currPath.add(neighbour);

            // Explore this neighbour
            dfs(graph, neighbour, dest, result, currPath);

            // Backtrack: remove neighbour before trying the next one
            currPath.remove(currPath.size() - 1);
        }
    }
}
