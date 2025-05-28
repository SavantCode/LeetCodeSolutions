class Solution {
    public int differenceOfSums(int n, int m) {
        int num1 = 0;
        int num2 = 0;

        for (int i = 1; i <= n; i++) {
            if (i % m != 0) {
                num1 += i;
            } else {
                num2 += i;
            }
        }

        return num1 - num2;
    }
}

/*
//Approach - Constant time using maths
//T.C : O(1)
//S.C : O(1)
class Solution {
    public int differenceOfSums(int n, int m) {
         int k = n / m;

        //Using variables for clarity
        int totalSum = n * (n + 1) / 2;
        int divisibleSum = m * k * (k + 1) / 2;
        int nonDivisibleSum = totalSum - divisibleSum;

        return nonDivisibleSum - divisibleSum;
    }
}
*/