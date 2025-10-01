// Time Complexity: O(log n)
// Space Complexity: O(log n)

class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int countBottles = 0;
        int emptyBottles = 0;
        int maxExchange = 0;

        return countDrinkBottles(countBottles, numBottles, emptyBottles, maxExchange, numExchange);
    }

    private int countDrinkBottles(int countBottles, int numBottles, int emptyBottles, int maxExchange, int numExchange) {
        countBottles += numBottles; // drink all available full bottles
        int totalEmpty = numBottles + emptyBottles;

        maxExchange = totalEmpty / numExchange;

        if (maxExchange == 0) return countBottles;

        int remainingEmpty = totalEmpty % numExchange;

        return countDrinkBottles(countBottles, maxExchange, remainingEmpty, 0, numExchange);
    }
}
