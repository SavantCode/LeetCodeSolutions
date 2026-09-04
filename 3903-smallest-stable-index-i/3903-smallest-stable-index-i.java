class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;

        int[] leftMax = new int[n];
        int[] rightMin = new int[n];

        int currentLeftMax = Integer.MIN_VALUE;
        int currentRightMin = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            currentLeftMax = Math.max(nums[i], currentLeftMax);
            leftMax[i] = currentLeftMax;
        }

        for (int i = n - 1; i >= 0; i--) {
            currentRightMin = Math.min(nums[i], currentRightMin);
            rightMin[i] = currentRightMin;
        }

        for (int i = 0; i < n; i++) {
            int diff = Math.abs(leftMax[i] - rightMin[i]);

            if (diff <= k) {
                return i;
            }
        }

        return -1;
    }
}
