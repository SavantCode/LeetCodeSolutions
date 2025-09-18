class Solution {
    public int fib(int n) {
        if (n <= 1) {
            return n;
        }

        // Only keep track of the last two Fibonacci numbers
        int a = 0; // fib(0)
        int b = 1; // fib(1)
        int c = 0; // will hold current Fibonacci number

        for (int i = 2; i <= n; i++) {
            c = a + b; // current Fibonacci number
            a = b;     // shift window
            b = c;
        }

        return c;
    }
}
