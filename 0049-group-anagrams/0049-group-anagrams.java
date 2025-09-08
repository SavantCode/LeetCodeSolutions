class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            String original = strs[i];

            // Step 1: Create the key by sorting the string

            // Step 1.1: Convert to char array
            char[] charArray = original.toCharArray(); // ['e', 'a', 't']

            // Step 1.2: Sort it
            Arrays.sort(charArray); // ['a', 'e', 't']

            // Step 1.3: Convert back to string
            String key = new String(charArray); // "aet"


            

            // Step 2: If key doesn't exist, create new list
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }

            // Step 3: Add the original string to the list
            map.get(key).add(original);
        }

        // Return all the values (groups of anagrams)
        return new ArrayList<>(map.values());
    }
}
