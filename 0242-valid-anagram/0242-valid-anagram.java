class Solution {
    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length())
            return false;
        HashMap<Character, Integer> map = new HashMap<>();

        int n = s.length();

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for (int i = 0; i < t.length(); i++) {

            char currChar = t.charAt(i);

            if (map.containsKey(currChar) && map.get(currChar) > 0) {
                map.put(currChar, map.get(currChar) - 1);
            } else {
                return false; // Character missing from 's' or frequency exceeded
            }

        }
        // for (int i = 0; i < n; i++) {
        //     char ch = s.charAt(i);

        //     int val = map.get(ch);
        //     System.out.print(ch + " ");
        //     if (val != 0) {
        //         return false;
        //     }
        // }
        return true;

    }
}