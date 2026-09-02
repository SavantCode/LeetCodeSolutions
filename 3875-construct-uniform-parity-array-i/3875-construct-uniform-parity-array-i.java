class Solution {

    public boolean uniformArray(int[] nums1) {

        // We have two possible targets:
        //
        // 1. Make all numbers EVEN
        // 2. Make all numbers ODD
        //
        // If either possibility works, return true.
        return solveEven(nums1) || solveOdd(nums1);
    }

    // Checks whether it is possible to make all numbers EVEN.
    private boolean solveEven(int[] nums) {

        int oddCount = 0;

        // Count how many numbers are currently odd.
        for (int num : nums) {
            if (num % 2 != 0) {
                oddCount++;
            }
        }

        /*
         * To make an odd number even, we need another odd number
         * to perform the required operation.
         *
         * Therefore:
         *
         * - If there are NO odd numbers:
         *      The array is already completely even.
         *
         * - If there are at least TWO odd numbers:
         *      The odd numbers can be used together to make
         *      the required changes.
         *
         * - If there is EXACTLY ONE odd number:
         *      There is no second odd number to help it,
         *      so we cannot make the whole array even.
         */
        return oddCount == 0 || oddCount >= 2;
    }

    // Checks whether it is possible to make all numbers ODD.
    private boolean solveOdd(int[] nums) {

        int oddCount = 0;

        // Count how many numbers are currently odd.
        for (int num : nums) {
            if (num % 2 != 0) {
                oddCount++;
            }
        }

        /*
         * If there is at least ONE odd number:
         *
         * That odd number can be used with the even numbers
         * to make them odd.
         *
         * So, having at least one odd number is enough to
         * make the entire array odd.
         *
         * nums.length <= 1 handles an array with zero or one
         * element, which is already considered uniform.
         */
        return oddCount > 0 || nums.length <= 1;
    }
}



