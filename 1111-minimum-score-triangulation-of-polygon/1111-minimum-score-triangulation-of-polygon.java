class Solution {

    int n;
    int[] values;
    Map<Integer, Integer> memo = new HashMap<>();

    public int minScoreTriangulation(int[] values) {
        this.n = values.length;
        this.values = values;
        return dp(0, n - 1);
    }

    private int dp(int i, int j) {
        if (i + 2 > j) return 0; // Less than 3 points — no triangle

        if (i + 2 == j) // Exactly 3 points — one triangle
            return values[i] * values[i + 1] * values[j];

        int key = i * n + j;

        if (!memo.containsKey(key)) {
            int minScore = Integer.MAX_VALUE;
            for (int k = i + 1; k < j; k++) {
                int score = values[i] * values[k] * values[j] + dp(i, k) + dp(k, j);
                minScore = Math.min(minScore, score);
            }
            memo.put(key, minScore);
        }

        return memo.get(key);
    }
}
