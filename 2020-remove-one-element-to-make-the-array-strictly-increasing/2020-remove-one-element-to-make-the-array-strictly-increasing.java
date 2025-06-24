class Solution {
    public boolean canBeIncreasing(int[] nums) {
        int count = 0;

        for (int i = 1; i < nums.length; i++) {
            if ( nums[i - 1] >= nums[i] ) {
                count++;
                if (count > 1) {
                    return false;
                }

                // Check if removing nums[i-1] or nums[i] helps
                if (i > 1 && nums[i] <= nums[i - 2]) {
                    // Can't remove nums[i-1], try removing nums[i]
                    nums[i] = nums[i - 1];
                }
            }
        }

        return true;
    }
}

// | **Metric** | **Value** |
// | ---------- | --------- |
// | Time       | O(n)      |
// | Space      | O(1)      |

