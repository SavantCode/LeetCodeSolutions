class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        Set<Integer> set = new HashSet<>();
        
        int i = 0; 
        int j = 0;
        int sum = 0;
        int max = 0;
        
        while(j < nums.length) {
            if(!set.contains(nums[j])) {
                sum += nums[j];
                max = Math.max(max, sum); 
                set.add(nums[j++]);
            } else {
                sum -= nums[i];
                set.remove(nums[i++]);
            }
        }
        
        return max;
    }
}

