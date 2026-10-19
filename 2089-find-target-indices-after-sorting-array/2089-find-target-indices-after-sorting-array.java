class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        
        List<Integer> result = new LinkedList<>(); // because insertion is faster in linkedlist

        int n = nums.length;
        Arrays.sort(nums);

        for(int i = 0;i < n; i++){

            if(nums[i] == target){
                result.add(i);
            }
        }

        Collections.sort(result);
        return result;
    }
}