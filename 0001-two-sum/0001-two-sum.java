class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }

        // If no pair found (though the problem usually guarantees a solution)
        return new int[]{-1, -1};
    }
}


// | Complexity   | Value |
// | ------------ | ----- |
// | Time (Worst) | O(n²) |
// | Space        | O(1)  |
