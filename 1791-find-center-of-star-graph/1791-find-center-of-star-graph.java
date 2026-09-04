//Approach-1 (Using map)
//T.C : O(n)
//S.C : O(n)
class Solution {
    public int findCenter(int[][] edges) {
        Map<Integer, Integer> degree = new HashMap<>();

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            degree.put(u, degree.getOrDefault(u, 0) + 1);
            degree.put(v, degree.getOrDefault(v, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : degree.entrySet()) {
            if (entry.getValue() == edges.length) {
                return entry.getKey(); // star graph center node
            }
        }

        return -1;
    }
}