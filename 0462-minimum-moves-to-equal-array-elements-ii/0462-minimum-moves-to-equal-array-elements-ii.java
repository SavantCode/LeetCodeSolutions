import java.util.Arrays;

class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int median = nums[nums.length / 2];
        int operations = 0;
        
        for (int i = 0; i < nums.length; i++) {
            operations += Math.abs(nums[i] - median);
        }
        
        return operations;
    }
}