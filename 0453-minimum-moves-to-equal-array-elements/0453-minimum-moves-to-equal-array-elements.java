class Solution {
    public int minMoves(int[] nums) {
        int n = nums.length;

        int operations = 0;

        int minValue = Integer.MAX_VALUE;
        for(int i = 0 ; i < n ; i++){  
            minValue = Math.min(minValue, nums[i]);
        }

        for(int i = 0 ; i < n ; i++){  
            
            operations += Math.abs(nums[i] - minValue);
        }

        return operations;
    }
}