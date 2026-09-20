import java.util.HashSet;

class Solution {
    public int[] singleNumber(int[] nums) {
        int[] result = new int[2];
        HashSet<Integer> set = new HashSet<>();

        int index = 0;

        for (int value : nums) {
            if (set.contains(value)) {
                set.remove(value);
            } else {
                set.add(value);
            }
        }

        for (int value : set) {
            result[index] = value;
            index++;
        }

        return result;
    }
}
