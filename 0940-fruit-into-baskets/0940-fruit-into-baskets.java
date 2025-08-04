class Solution {
    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> basket = new HashMap<>();
        int i = 0, max = 0;

        for (int j = 0; j < fruits.length; j++) {
            int fruit = fruits[j];
            basket.put(fruit, basket.getOrDefault(fruit, 0) + 1);

            // Shrink the window from the left if we have more than 2 types
            // actually we are shrinking the window using while loop
            while (basket.size() > 2) {
                int leftFruit = fruits[i];
                basket.put(leftFruit, basket.get(leftFruit) - 1);
                if (basket.get(leftFruit) == 0) {
                    basket.remove(leftFruit);
                }
                i++;
            }

            // Update max length of valid window
            max = Math.max(max, j - i + 1);
        }

        return max;
    }
}

/*

//T.C : O(n)
//S.C : O(n)
*/