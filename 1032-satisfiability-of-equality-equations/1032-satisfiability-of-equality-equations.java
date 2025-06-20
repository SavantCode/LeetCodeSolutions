public class Solution {

    int[] parent;
    int[] rank;

    public int find(int i) {
        if (parent[i] != i) {
            parent[i] = find(parent[i]); // Path compression
        }
        return parent[i];
    }

    public void union(int x, int y) {
        int p_x = find(x);
        int p_y = find(y);

        if (p_x != p_y) {
            if (rank[p_x] > rank[p_y]) {
                parent[p_y] = p_x;
            } else if (rank[p_y] > rank[p_x]) {
                parent[p_x] = p_y;
            } else {
                parent[p_x] = p_y;
                rank[p_y]++;
            }
        }
    }

    public boolean equationsPossible(String[] equations) {
        parent = new int[26];
        rank = new int[26];

        for (int i = 0; i < 26; i++) {
            parent[i] = i;
            rank[i] = 1;
        }

        // First, process all equations with '=='
        for (String eq : equations) {
            if (eq.charAt(1) == '=') {
                union(eq.charAt(0) - 'a', eq.charAt(3) - 'a');
            }
        }

        // Then check for any contradictions in '!=' equations
        for (String eq : equations) {
            if (eq.charAt(1) == '!') {
                if (find(eq.charAt(0) - 'a') == find(eq.charAt(3) - 'a')) {
                    return false;
                }
            }
        }

        return true;
    }
}
