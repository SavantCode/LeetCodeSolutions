class Solution {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);

        int prev = nums[0];
        int count = 1;
        System.out.print(prev + " ");

        for(int i = 1 ; i < nums.length; i++){

            int val = nums[i];
            System.out.print(val + " ");
            if(prev != val){
                count = 0;
                prev = val;
            }
            count++;

            if(count >= 2) return true;
        }
        return false;
    }
}