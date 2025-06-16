class Solution {
    public boolean isBipartite(int[][] graph) {
        int V = graph.length;
        int[] color = new int[V];
        Arrays.fill(color, -1); // no node colored in the start

        // red = 1
        // green = 0

        for (int i = 0; i < V; i++) {
            if (color[i] == -1) {
                if (!dfs(graph, i, color, 1))
                    return false;
            }
        }

        return true;
    }

    private boolean dfs(int[][] graph, int curr, int[] color, int currColor) {
        color[curr] = currColor; // color kardiya curr node ko

        // ab jaate hain adjacent nodes par
        for (int v : graph[curr]) {

            if (color[v] == color[curr])
                return false;

            if (color[v] == -1) { // never colored (never visited)
                int colorOfV = 1 - currColor;

                if (!dfs(graph, v, color, colorOfV))
                    return false;
            }
        }

        return true;
    }
}
