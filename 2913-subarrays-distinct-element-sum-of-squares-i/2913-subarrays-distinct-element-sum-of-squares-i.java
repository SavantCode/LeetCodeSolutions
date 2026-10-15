import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public int sumCounts(List<Integer> nums) {
        int result = 0;
        int n = nums.size(); // 1. Defined n using list size
        
        for (int i = 0; i < n; i++) {
            Set<Integer> set = new HashSet<>(); // 2. Initialized the Set for each starting index
            for (int j = i; j < n; j++) {
                set.add(nums.get(j)); // 3. Used nums.get(j) to add elements of the subarray
                
                // add the square of the distinct count for every subarray [i..j]:
                result += set.size() * set.size(); 
                
                // Note: If your problem asks for the simple sum of counts instead of squares, 
                // change it to: result += set.size();
            }
        }
        return result;
    }
}