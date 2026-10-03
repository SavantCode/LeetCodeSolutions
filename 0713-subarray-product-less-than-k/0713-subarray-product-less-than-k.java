class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        // Base case: positive integers multiplied together can never be < 1 or < 0
        if (k <= 1) return 0;

        int n = nums.length;
        int totalSubarrays = 0;

        for (int i = 0; i < n; i++) {
            // Fix: If single element itself is >= k, it forms 0 valid subarrays starting at i
            if (nums[i] >= k) {
                continue;
            }

            int currProd = nums[i];
            int count = 1; // nums[i] itself is valid since nums[i] < k

            for (int j = i + 1; j < n; j++) {
                currProd *= nums[j];

                if (currProd >= k) {
                    break;
                }
                count++;
            }

            totalSubarrays += count;
        }

        return totalSubarrays;
    }
}