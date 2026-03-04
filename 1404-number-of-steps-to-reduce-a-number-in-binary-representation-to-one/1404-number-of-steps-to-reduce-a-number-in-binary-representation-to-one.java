import java.math.BigInteger;
// Complexity	Value
// Time	--> O(n²)
// Space --> O(n)
class Solution {
    public int numSteps(String s) {
        BigInteger num = new BigInteger(s, 2);
        int steps = 0;

        while (!num.equals(BigInteger.ONE)) {
            if (num.mod(BigInteger.TWO).equals(BigInteger.ZERO)) {
                num = num.divide(BigInteger.TWO);
            } else {
                num = num.add(BigInteger.ONE);
            }
            steps++;
        }

        return steps;
    }
}