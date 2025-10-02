/*
 * Time Complexity: O(numBottles)
 * Space Complexity: O(1)
 */

class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int totalDrank = numBottles;
        int emptyBottles = numBottles;

        while (emptyBottles >= numExchange) {
            // Perform one exchange
            emptyBottles -= numExchange;
            totalDrank += 1;
            emptyBottles += 1; // the new full bottle becomes empty after drinking

            numExchange++; // Increase the exchange cost
        }

        return totalDrank;
    }
}
