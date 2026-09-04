import java.util.*;

class Solution {

    void dfs(HashMap<String, ArrayList<Pair>> adj, String src, String dst, HashSet<String> visited, double product, double[] ans) {
        if (visited.contains(src)) {
            return;
        }

        visited.add(src);

        if (src.equals(dst)) {
            ans[0] = product;
            return;
        }

        for (Pair p : adj.getOrDefault(src, new ArrayList<>())) {
            String v = p.node;
            double val = p.value;

            dfs(adj, v, dst, visited, product * val, ans);
        }
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        HashMap<String, ArrayList<Pair>> adj = new HashMap<>();

        // Build graph
        for (int i = 0; i < equations.size(); i++) {

            String u = equations.get(i).get(0);
            String v = equations.get(i).get(1);
            double val = values[i];

            // To handle u / v
            adj.computeIfAbsent(u, k -> new ArrayList<>())
               .add(new Pair(v, val));

            // To handle v / u
            adj.computeIfAbsent(v, k -> new ArrayList<>())
               .add(new Pair(u, 1.0 / val));
        }

        double[] result = new double[queries.size()];

        // Process queries
        for (int i = 0; i < queries.size(); i++) {

            String src = queries.get(i).get(0);
            String dst = queries.get(i).get(1);

            double[] ans = {-1.0};
            double product = 1.0;

            if (adj.containsKey(src)) {
                HashSet<String> visited = new HashSet<>();

                dfs(adj, src, dst, visited, product, ans);
            }

            result[i] = ans[0];
        }

        return result;
    }

    // Pair class to store (node, value)
    class Pair {
        String node;
        double value;

        Pair(String node, double value) {
            this.node = node;
            this.value = value;
        }
    }
}
