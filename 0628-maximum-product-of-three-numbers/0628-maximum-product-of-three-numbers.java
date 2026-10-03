import java.util.Arrays;

class Solution {
    public int maximumProduct(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        // Case 1: Product of the 3 largest numbers
        int option1 = nums[n - 1] * nums[n - 2] * nums[n - 3];

        // Case 2: Product of 2 smallest (most negative) numbers and the largest number
        int option2 = nums[0] * nums[1] * nums[n - 1];

        return Math.max(option1, option2);
    }
}