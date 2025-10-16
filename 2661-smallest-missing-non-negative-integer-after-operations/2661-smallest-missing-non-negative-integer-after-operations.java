//Approach - Observation about Modulo(%) values
//T.C : O(n)
//S.C : O(n)
class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        HashMap<Integer, Integer> map = new HashMap<>();

        // Count occurrences of each normalized remainder
        for (int num : nums) {
            int r = ((num % value) + value) % value; // ensures non-negative remainder
            map.put(r, map.getOrDefault(r, 0) + 1);
        }

        int MEX = 0;

        // Increment MEX while we have available remainders
        while (map.getOrDefault(MEX % value, 0) > 0) {
            map.put(MEX % value, map.get(MEX % value) - 1);
            MEX++;
        }

        return MEX;
    }
}