class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;

        int maxSoFar = nums[0];
        int minSoFar = nums[0];
        int result = maxSoFar;

        for (int i = 1; i < n; i++) {
            int curr = nums[i];

            // If current number is negative, swapping max and min 
            // accounts for sign reversal
            if (curr < 0) {
                int temp = maxSoFar;
                maxSoFar = minSoFar;
                minSoFar = temp;
            }

            // Either extend the previous subarray or start a new subarray at current element
            maxSoFar = Math.max(curr, maxSoFar * curr);
            minSoFar = Math.min(curr, minSoFar * curr);

            // Keep track of global maximum product seen so far
            result = Math.max(result, maxSoFar);
        }

        return result;
    }
}