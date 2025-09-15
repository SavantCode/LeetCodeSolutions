import java.util.Arrays;

class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people); // Sort the weights

        int left = 0;
        int right = people.length - 1;
        int boats = 0;

        while (left <= right) {
            if (people[left] + people[right] <= limit) {
                // Pair the lightest and heaviest person
                left++;
            }
            // The heaviest person always goes
            right--;
            boats++;
        }

        return boats;
    }
}
