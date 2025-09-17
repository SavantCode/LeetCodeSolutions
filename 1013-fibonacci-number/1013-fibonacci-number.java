class Solution {
    int[] t = new int[31];  // to store memoized results

    public int fib(int n) {
        // Initialize the array with -1 (similar to memset in C++)
        for (int i = 0; i < t.length; i++) {
            t[i] = -1;
        }

        return solve(n);
    }

    private int solve(int n) {
        if (n <= 1) {
            return n;
        }

        if (t[n] != -1) {
            return t[n];
        }

        t[n] = solve(n - 1) + solve(n - 2);
        return t[n];
    }
}
