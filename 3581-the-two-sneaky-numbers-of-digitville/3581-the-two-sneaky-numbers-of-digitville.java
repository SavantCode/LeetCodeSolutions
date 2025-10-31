// Time Complexity: O(n) — single pass through the array.
// Space Complexity: O(n) — for storing numbers in the HashSet.

class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        HashSet<Integer> seen = new HashSet<>();
        int[] result = new int[2];
        int index = 0;

        for (int num : nums) {
            if (seen.contains(num)) {
                result[index++] = num; // duplicate found
            } else {
                seen.add(num);
            }
        }

        return result;
    }
}
