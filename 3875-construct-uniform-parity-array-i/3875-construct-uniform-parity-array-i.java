class Solution {
    public boolean uniformArray(int[] nums1) {
        return solveEven(nums1) || solveOdd(nums1);
    }

    private boolean solveEven(int[] nums) {
        int oddCount = 0;

        for (int num : nums) {
            if (num % 2 != 0) {
                oddCount++;
            }
        }

        // Every odd needs another odd to become even
        return oddCount == 0 || oddCount >= 2;
    }

    private boolean solveOdd(int[] nums) {
        int oddCount = 0;

        for (int num : nums) {
            if (num % 2 != 0) {
                oddCount++;
            }
        }

        // If there is an odd number, every even can subtract it
        return oddCount > 0 || nums.length <= 1;
    }
}
