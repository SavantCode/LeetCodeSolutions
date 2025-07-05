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

/*
class Solution {
    public int findLucky(int[] arr) {
        int[] count = new int[551]; // Since 1 <= arr[i] <= 500

        // Count frequencies
        for (int num : arr) {
            count[num]++;
        }

        int result = -1;

        // Check for lucky numbers
        for (int i = 1; i < count.length; i++) {
            if (count[i] == i) {
                result = Math.max(result, i);
            }
        }

        return result;
    }
}

 */