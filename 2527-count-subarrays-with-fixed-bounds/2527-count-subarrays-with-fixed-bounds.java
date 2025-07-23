class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int n = nums.length;
        long count = 0;

        int lastMin = -1, lastMax = -1;
        int leftBound = -1;

        for (int i = 0; i < n; i++) {
            int num = nums[i];

            if (num < minK || num > maxK) {
                // Reset bounds if invalid element found
                leftBound = i;
                lastMin = -1;
                lastMax = -1;
            }

            if (num == minK) lastMin = i;
            if (num == maxK) lastMax = i;

            // Valid subarray only if both minK and maxK have been seen
            if (lastMin != -1 && lastMax != -1) {
                count += Math.max(0, Math.min(lastMin, lastMax) - leftBound);
            }
        }

        return count;
    }
}
