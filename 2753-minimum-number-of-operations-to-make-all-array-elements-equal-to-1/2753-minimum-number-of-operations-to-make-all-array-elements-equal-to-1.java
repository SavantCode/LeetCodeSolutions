class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int ones = 0;
        
        // Count number of 1s
        for (int num : nums) {
            if (num == 1) ones++;
        }
        
        if (ones > 0) {
            // If there are 1s, just spread them
            return n - ones;
        }
        
        int minLen = Integer.MAX_VALUE;
        
        // Find shortest subarray with gcd = 1
        for (int i = 0; i < n; i++) {
            int gcd = nums[i];
            for (int j = i; j < n; j++) {
                gcd = gcd(gcd, nums[j]);
                if (gcd == 1) {
                    minLen = Math.min(minLen, j - i + 1);
                    break;  // no need to extend further
                }
            }
        }
        
        // If no subarray has gcd 1, impossible
        if (minLen == Integer.MAX_VALUE) return -1;
        
        // Operations = (length of subarray - 1) + (spread 1 to rest)
        return minLen - 1 + n - 1;
    }
    
    // Helper function to calculate gcd
    private int gcd(int a, int b) {
        while (b != 0) {
            int tmp = b;
            b = a % b;
            a = tmp;
        }
        return a;
    }
}
