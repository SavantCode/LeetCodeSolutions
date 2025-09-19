//Time Complexity: O(n)
// Space Complexity: O(n)
class Solution{
    public int rob(int[] nums) {
        int n = nums.length;

        if (n == 0)
            return 0;

        if (n == 1)
            return nums[0];

        // t[i] = max profit till house i
        int[] t = new int[n + 1];

        t[0] = 0;          // No house robbed
        t[1] = nums[0];    // First house robbed

        for (int i = 2; i <= n; i++) {
            int skip = t[i - 1];               // Skip current house
            int steal = nums[i - 1] + t[i - 2]; // Rob current house

            t[i] = Math.max(skip, steal);
            /*
                SKIP  : Take max money till previous house
                STEAL : Take current money + money from (i-2)th house
            */
        }

        return t[n]; // Final answer
    }
}