class Solution {
    public int findLucky(int[] arr) {
        // int[] arr = {1, 2, 2, 3, 3, 3};

        HashMap<Integer, Integer> freqMap = new HashMap<>();

        for (int num : arr) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // keep track of number with heighest freq
        int heighestFreq = -1;
        for (int key : freqMap.keySet()) {
            if(key == freqMap.get(key)){
                heighestFreq = Math.max(key, heighestFreq);
            }
        }
    return heighestFreq;
    }
}

// | Type             | Complexity |
// | ---------------- | ---------- |
// | Time Complexity  | **O(n)**   |
// | Space Complexity | **O(n)**   |
