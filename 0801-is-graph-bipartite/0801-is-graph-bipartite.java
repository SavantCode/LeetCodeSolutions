// 1 red color, 0 blue color

class Solution {
    public boolean isBipartite(int[][] graph) {
        int V = graph.length;
        int[] color = new int[V];
        Arrays.fill(color, -1);

        for (int i = 0; i < V; i++) {
            if (color[i] == -1) {
                if (!checkBipartiteDFS(graph, i, color, 1)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean checkBipartiteDFS(int[][] graph, int node, int[] color, int currColor) {
        color[node] = currColor;

        for (int neighbor : graph[node]) {
            if (color[neighbor] == color[node]) {
                return false;
            }

            if (color[neighbor] == -1) {
                if (!checkBipartiteDFS(graph, neighbor, color, 1 - currColor)) {
                    return false;
                }
            }
        }

        return true;
    }
}

// | Complexity | Value    |
// | ---------- | -------- |
// | **Time**   | O(V + E) |
// | **Space**  | O(V)     |

// V is the number of vertices (nodes) = graph.length
// E is the total number of edges (sum of all neighbor lists' sizes)