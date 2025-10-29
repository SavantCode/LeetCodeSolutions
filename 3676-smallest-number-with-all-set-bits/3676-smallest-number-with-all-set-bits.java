class Solution {
    public int smallestNumber(int n) {
        int result = 1;

        while (result < n) {
            result = 2 * result + 1;
        }

        return result;
    }
}
