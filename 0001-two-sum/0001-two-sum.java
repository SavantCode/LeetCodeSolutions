class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>(); // value -> index

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }

            map.put(nums[i], i);
        }

        return new int[] { -1, -1 }; // if no solution found
    }
}

// | Metric           | Value    |
// | ---------------- | -------- |
// | Time Complexity  | **O(n)** |
// | Space Complexity | **O(n)** | because we have taxen extra space for map


/*
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
*/