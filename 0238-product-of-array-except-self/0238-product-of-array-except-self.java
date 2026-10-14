class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] prefixProd = new int[n];
        int[] suffixProd = new int[n];

        prefixProd[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefixProd[i] = prefixProd[i - 1] * nums[i];
        }

        suffixProd[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffixProd[i] = suffixProd[i + 1] * nums[i];
        }

        int[] result = new int[n];
        result[0] = suffixProd[1];
        result[n - 1] = prefixProd[n - 2];
        
        for (int i = 1; i < n - 1; i++) {
            result[i] = prefixProd[i - 1] * suffixProd[i + 1];
        }

        return result;
    }
}