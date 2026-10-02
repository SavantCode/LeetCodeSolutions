import java.util.HashSet;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> seen = new HashSet<>();
        
        for (int num : nums) {
            // add() returns false if the number is already present
            if (!seen.add(num)) {
                return true; // Duplicate found immediately
            }
        }
        
        return false;
    }
}