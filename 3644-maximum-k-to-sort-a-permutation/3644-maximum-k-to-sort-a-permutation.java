class Solution {
    public int sortPermutation(int[] nums) {
        int ans = -1; // Initialize with all bits set to 1
        
        for (int i = 0; i < nums.length; i++) {
            // If the element is out of place, it must participate in swaps
            if (nums[i] != i) {
                ans &= nums[i];
            }
        }
        
        // If array is already sorted, ans remains -1, so we return 0
        return Math.max(ans, 0);
    }
}