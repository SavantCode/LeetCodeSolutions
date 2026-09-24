class Solution {
    public int smallestIndex(int[] nums) {
        int n = nums.length;
        
        // Start from index 0
        for (int i = 0; i < n; i++) {
            if (solve(i, nums)) {
                // Since loop runs from 0 to n - 1, 
                // the first valid index found is guaranteed to be the smallest.
                return i;
            }
        }
        
        return -1;
    }

    public boolean solve(int idx, int[] nums) {
        int currVal = nums[idx];
        int currSum = 0;
        
        // Loop while currVal is strictly greater than 0
        while (currVal > 0) {
            currSum += currVal % 10;
            currVal = currVal / 10;
        }

        return currSum == idx;
    }
}