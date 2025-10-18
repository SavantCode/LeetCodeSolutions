// Time Complexity: O(n log n) due to sorting  
// Space Complexity: O(1) extra space

class Solution {
    public int maxDistinctElements(int[] nums, int k) {
        Arrays.sort(nums);
        int ans = 0;
        long prev = Long.MIN_VALUE;

        for (int x : nums) {
            if (prev < (long)x + k) {
                long cur = Math.max(prev + 1, (long)x - k);
                cur = Math.min(cur, (long)x + k);
                prev = cur;
                ans++;
            }
            // else: skip this x because it cannot help increase distinct count
        }
        return ans;
    }
}
