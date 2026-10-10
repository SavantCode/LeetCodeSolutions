class Solution {
    public int maxSubArray(int[] nums) {
        System.gc();
        int max = Integer.MIN_VALUE;
        int sum = 0;

        for (int num : nums) {
            sum = sum + num;

            max = Math.max(max, sum);
            if (sum < 0) {
                sum = 0;
            }
        }
        return max;
    }
}