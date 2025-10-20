class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int X = 0; // Initial value of X is 0

        for (String operation : operations) {
            if (operation.equals("++X") || operation.equals("X++")) {
                X++;
            } else {
                X--;
            }
        }

        return X;
    }
}
