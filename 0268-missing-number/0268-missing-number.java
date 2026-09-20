//although numbers are from [0,n], which includes n, but i cannot go upto including 'n' since nums[n] does not exist, thats wy we are keeping result = n so that it can be included in XOR

//TC :O(n)
//SC : O(1)
class Solution {
    public int missingNumber(int[] nums) {
        int result = nums.length;
        for (int i = 0; i < nums.length; i++) {
            result ^= i ^ nums[i];
        }
        return result;
    }
}   

