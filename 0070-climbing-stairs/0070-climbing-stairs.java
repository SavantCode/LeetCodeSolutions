//optimised DP constant space
// Time: O(n)
// Space: O(1)
class Solution {
    public int climbStairs(int n) {
         // Step 1: Handle base cases
        if (n == 1 || n == 2)
            return n;

        // Step 2: Use only three variables to track last two steps
        int a = 1; // Ways to reach step 1
        int b = 2; // Ways to reach step 2
        int c = 0; // Variable to store result for current step

        // Step 3: Loop from step 3 to n
        for (int i = 3; i <= n; i++) {
            c = a + b; // Current ways = previous two steps
            a = b;     // Shift a to b (i.e., step i-2 becomes i-1)
            b = c;     // Shift b to c (i.e., step i-1 becomes i)
        }

        // Step 4: Return result
        return c;
    }
}