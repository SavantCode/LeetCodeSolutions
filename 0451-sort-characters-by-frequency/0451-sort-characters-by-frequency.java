import java.util.*;

class Solution {

    public String frequencySort(String s) {
        // Step 1: Count character frequencies using HashMap
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        // Step 2: PriorityQueue with custom comparator to act as a max-heap
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> b.freq - a.freq);

        // Step 3: Add all map entries as Pair into priority queue
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            pq.add(new Pair(entry.getKey(), entry.getValue()));
        }

        // Step 4: Build the result string by polling from max-heap
        StringBuilder result = new StringBuilder();
        while (!pq.isEmpty()) {
            Pair temp = pq.poll();
            for (int i = 0; i < temp.freq; i++) {
                result.append(temp.ch);
            }
        }

        return result.toString();
    }

    // Define Pair class
    class Pair {
        char ch;
        int freq;

        Pair(char ch, int freq) {
            this.ch = ch;
            this.freq = freq;
        }
    }
}
