// TC : O(n)
// SC : O(n)

class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;

        int maxLeft_val = Integer.MIN_VALUE;
        int minRight_val = Integer.MAX_VALUE;

        int[] maxLeft = new int[n];
        int[] minRight = new int[n];

        // calculate max(nums[0..i])
        for(int i = 0; i < n; i++) {

            if(maxLeft_val < nums[i]) {
                maxLeft_val = nums[i];
            }

            maxLeft[i] = maxLeft_val;
        }

        // calculate min(nums[i..n-1])
        for(int i = n - 1; i >= 0; i--) {

            if(nums[i] < minRight_val) {
                minRight_val = nums[i];
            }

            minRight[i] = minRight_val;
        }

        // instability score =
        // |max(nums[0..i]) - min(nums[i..n-1])|

        for(int i = 0; i < n; i++) {

            int diff = Math.abs(maxLeft[i] - minRight[i]);

            if(diff <= k) {
                return i;   // likely return index, not diff
            }
        }

        return -1;
    }
}
