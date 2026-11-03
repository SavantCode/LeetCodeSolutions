class Solution {
    public int minMoves(int[] nums) {
        Arrays.sort(nums);
        int median = nums[nums.length / 2];

        int operations = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }
        for (int i = 0; i < nums.length; i++) {
            operations += Math.abs(nums[i] - max);
        }

        return operations;
    }
}