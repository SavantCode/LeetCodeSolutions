class Solution {
    private Map<String, Double> memo = new HashMap<>();

    public double soupServings(int n) {
        if (n >= 5000) return 1.0; // Optimization for large n
        int units = (n + 24) / 25; // Convert to 25mL units, rounding up
        return helper(units, units);
    }

    private double helper(int a, int b) {
        if (a <= 0 && b <= 0) return 0.5;
        if (a <= 0) return 1.0;
        if (b <= 0) return 0.0;

        String key = a + "," + b;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        double prob = 0.25 * (
            helper(a - 4, b) +
            helper(a - 3, b - 1) +
            helper(a - 2, b - 2) +
            helper(a - 1, b - 3)
        );

        memo.put(key, prob);
        return prob;
    }
}
