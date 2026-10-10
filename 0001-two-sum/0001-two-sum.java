import java.util.HashMap;

// Time Complexity: O(N) — We traverse the array of size N only once. Hash Map lookups take O(1) average time.

// Space Complexity: O(N) — In the worst case, we store all elements in the hash map.

class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Map to store {number: original_index}
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            // If the complement exists in our map, we found our pair!
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }

            // Otherwise, store the current number and its index
            map.put(nums[i], i);
        }

        return new int[] { -1, -1 }; // Fallback if no solution exists
    }
}