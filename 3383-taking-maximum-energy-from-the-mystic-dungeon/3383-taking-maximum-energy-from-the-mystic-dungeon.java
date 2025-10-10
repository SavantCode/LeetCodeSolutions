class Solution {
    public int maximumEnergy(int[] energy, int k) {
        int n = energy.length;
        int[] dp = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            if (i + k < n) {
                dp[i] = energy[i] + dp[i + k];
            } else {
                dp[i] = energy[i];
            }
        }

        int maxEnergy = Integer.MIN_VALUE;
        for (int val : dp) {
            maxEnergy = Math.max(maxEnergy, val);
        }

        return maxEnergy;
    }
}
