class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int n = nums.length;

        int i = 0;

        while(i < n){
            // j starts from i+1 and goes up to i+k (but not beyond array bounds)
            for (int j = i + 1; j <= i + k && j < n; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
            i++;
        }

        return false;
    }
}

/*

Time Complexity	  O(k * n)	O(n)
Space Complexity	O(1) (no extra space used)
*/