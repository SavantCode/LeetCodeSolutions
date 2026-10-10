class Solution {
    public int findMin(int[] nums) {
        int minVal = Integer.MAX_VALUE;

        for(int val : nums){
            minVal = Math.min(minVal, val);
        }

        return minVal;
    }
}