// Time Complexity: O(n²)
// Time Complexity: O(n)
class Solution {
    public int triangularSum(int[] nums) {
        int n = nums.length;
        return triangle(nums, n);
    }

    private int triangle(int[] nums, int n) {
        if (n == 1) return nums[0]; // fixed from n == 0 to n == 1
        int[] newArr = new int[n - 1];
        for (int i = 0; i < n - 1; i++) { // fixed loop bounds
            newArr[i] = (nums[i] + nums[i + 1]) % 10; // fixed index and parentheses
        }
        return triangle(newArr, n - 1); // added return
    }
}
