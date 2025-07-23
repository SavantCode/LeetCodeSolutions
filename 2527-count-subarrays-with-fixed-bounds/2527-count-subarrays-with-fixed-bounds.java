class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int n = nums.length;
        int lastmin = -1;
        int lastmax = -1;
        int lastInvalid = -1;
        long count = 0; // long to avoid overflow

        for (int i = 0; i < n; i++) {
            if (nums[i] < minK || nums[i] > maxK) {
                lastInvalid = i;
            }

            if (nums[i] == minK) {
                lastmin = i;
            }

            if (nums[i] == maxK) {
                lastmax = i;
            }

            int validPos = Math.min(lastmin, lastmax);
            count += Math.max(0, validPos - lastInvalid);
        }

        return count;
    }
}
