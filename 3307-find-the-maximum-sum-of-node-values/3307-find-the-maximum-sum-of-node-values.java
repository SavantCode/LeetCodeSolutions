//Approach-1 (Greedily picking nodes to xor)
//T.C : O(n)
//S.C : O(1)
class Solution {
    public long maximumValueSum(int[] nums, int k, int[][] edges) {
        long sum = 0;
        int count = 0;
        int minNukasan = Integer.MAX_VALUE;

        for (int num : nums) {
            if ((num ^ k) > num) {
                count++;
                sum += (num ^ k);
            } else {
                sum += num;
            }

            minNukasan = Math.min(minNukasan, Math.abs(num - (num ^ k)));
        }

        if (count % 2 == 0)
            return sum;

        return sum - minNukasan;
    }
}