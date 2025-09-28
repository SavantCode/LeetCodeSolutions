// Time Complexity: O(n log n) due to sorting
// Space Complexity: O(1) as sorting is done in-place and uses constant extra space


class Solution {
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;

        // Reverse array to get descending order
        for (int i = 0; i < n / 2; i++) {
            int temp = nums[i];
            nums[i] = nums[n - 1 - i];
            nums[n - 1 - i] = temp;
        }

        // Check triples from largest to smaller
        for (int i = 0; i < n - 2; i++) {
            int a = nums[i];
            int b = nums[i + 1];
            int c = nums[i + 2];
            // Check triangle inequality
            if (b + c > a) {
                return a + b + c;  
            }
        }

        return 0;  // no valid triangle found
    }
}
