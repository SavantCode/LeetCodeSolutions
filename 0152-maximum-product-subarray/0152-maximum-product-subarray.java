class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int leftProduct = 1;
        int rightProduct = 1;
        int ans = nums[0];

        for (int i = 0; i < n; i++) {
            // Reset if product becomes 0
            if (leftProduct == 0) leftProduct = 1;
            if (rightProduct == 0) rightProduct = 1;

            leftProduct *= nums[i];
            rightProduct *= nums[n - 1 - i];

            ans = Math.max(ans, Math.max(leftProduct, rightProduct));
        }

        return ans;
    }
}






// class Solution {

//     public int maxProduct(int[] nums) {
//         int n = nums.length;

//         // Use long to prevent integer overflow during intermediate multiplications
//         long leftProduct = 1;  // Tracks running prefix product (left -> right)
//         long rightProduct = 1; // Tracks running suffix product (right -> left)
//         long ans = nums[0];    // Stores global maximum product seen so far

//         for (int i = 0; i < n; i++) {

//             // 1. RESET CONDITION:
//             // If running product hit 0 in previous step (or underflowed), 
//             // reset it to 1 to start a fresh subarray product.
//             if (leftProduct == 0 || leftProduct < Integer.MIN_VALUE) {
//                 leftProduct = 1;
//             }
//             if (rightProduct == 0 || rightProduct < Integer.MIN_VALUE) {
//                 rightProduct = 1;
//             }

//             // 2. MULTIPLY:
//             // Include current element in left-to-right prefix product
//             leftProduct *= nums[i];

//             // Include corresponding element from the back in right-to-left suffix product
//             rightProduct *= nums[n - 1 - i];

//             // 3. UPDATE MAXIMUM:
//             // Compare overall answer with both prefix and suffix products
//             ans = Math.max(ans, Math.max(leftProduct, rightProduct));
//         }

//         // Cast result back to standard int as per problem signature
//         return (int) ans;
//     }

// }