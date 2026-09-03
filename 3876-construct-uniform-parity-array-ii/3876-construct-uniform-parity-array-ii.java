class Solution {
    public boolean uniformArray(int[] nums1) {
        int minVal = Integer.MAX_VALUE;
        boolean hasOdd = false;

        for (int num : nums1) {
            if (num < minVal) {
                minVal = num;
            }
            if (num % 2 != 0) {
                hasOdd = true;
            }
        }

        // 1. If minVal is odd, we can always make all elements odd.
        if (minVal % 2 != 0) {
            return true;
        }

        // 2. If minVal is even, we can only succeed if there are NO odd numbers at all.
        return !hasOdd;
    }
}