// Time Complexity: O(n²) – each zero can trigger an O(n) simulation.
// Space Complexity: O(n) – due to cloning the array.

class Solution {
    public int countValidSelections(int[] nums) {
        int n = nums.length;
        int result = 0;

        // Try each position where nums[i] == 0
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                // Try starting left and right
                if (canMakeZero(nums.clone(), i, -1)) result++;
                if (canMakeZero(nums.clone(), i, 1)) result++;
            }
        }
        return result;
    }

    // direction: -1 = left, +1 = right
    private boolean canMakeZero(int[] nums, int curr, int direction) {
        int n = nums.length;

        while (curr >= 0 && curr < n) {
            if (nums[curr] == 0) {
                // keep moving in same direction
                curr += direction;
            } else {
                // decrement and reverse direction
                nums[curr]--;
                direction *= -1; // reverse
                curr += direction;
            }
        }

        // Check if all elements are 0
        for (int val : nums) {
            if (val != 0) return false;
        }
        return true;
    }
}
