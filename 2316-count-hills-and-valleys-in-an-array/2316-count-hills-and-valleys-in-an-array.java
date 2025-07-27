class Solution {
    public int countHillValley(int[] nums) {
        int count = 0;

        for (int i = 1; i < nums.length - 1; i++) {
            // Skip duplicate values — they are part of the same hill/valley
            if (nums[i] == nums[i - 1]) continue;

            // Find closest non-equal left neighbor
            int left = i - 1;
            while (left >= 0 && nums[left] == nums[i]) {
                left--;
            }

            // Find closest non-equal right neighbor
            int right = i + 1;
            while (right < nums.length && nums[right] == nums[i]) {
                right++;
            }

            // Only proceed if valid left and right non-equal neighbors exist
            if (left >= 0 && right < nums.length) {
                if (nums[i] > nums[left] && nums[i] > nums[right]) {
                    count++; // Hill
                } else if (nums[i] < nums[left] && nums[i] < nums[right]) {
                    count++; // Valley
                }
            }
        }

        return count;
    }
}
