import java.util.HashMap;

class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        HashMap<Character, Integer> map = new HashMap<>();
        
        // Count frequencies of each stone
        for (int i = 0; i < stones.length(); i++) {
            char c = stones.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int totalStones = 0;
        
        // Sum frequency for each jewel character present in the map
        for (int i = 0; i < jewels.length(); i++) {
            char j = jewels.charAt(i);
            totalStones += map.getOrDefault(j, 0);
        }

        return totalStones;
    }
}