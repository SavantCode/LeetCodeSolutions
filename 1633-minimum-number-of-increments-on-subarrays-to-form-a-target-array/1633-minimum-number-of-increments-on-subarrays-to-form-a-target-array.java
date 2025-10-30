//T.C : O(n)
//S.C : O(1)
class Solution {
    public int minNumberOperations(int[] target) {
        int n = target.length;
        int result = 0;
        int prev = 0;

        for (int i = 0; i < n; i++) {
            int curr = target[i];
            if (curr > prev) {
                result += (curr - prev);
            }
            prev = curr;
        }

        return result;
    }
}