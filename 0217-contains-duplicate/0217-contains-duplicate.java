class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        // Step 1: Count frequency of each number
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Step 2: Directly iterate over map values
        for (int count : map.values()) {
            if (count >= 2) {
                return true; // Found a duplicate
            }
        }

        return false; // No duplicates found after checking all counts
    }
}