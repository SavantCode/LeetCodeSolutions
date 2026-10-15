import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        
        // Step 1: Sort the array so we can use two pointers
        Arrays.sort(nums);

        for (int i = 0; i < n - 2; i++) {
            // Skip duplicate values for 'i' to avoid duplicate triplets
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = n - 1;
            int target = -nums[i];

            while (left < right) {
                int currSum = nums[left] + nums[right];

                if (currSum == target) {
                    // Found a valid triplet!
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // Skip duplicates for 'left'
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    // Skip duplicates for 'right'
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }

                    // Move both pointers inward to look for new pairs
                    left++;
                    right--;
                } else if (currSum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }
}