import java.util.*;

class Solution {
    public int minStoneSum(int[] piles, int k) {
        // Step 1: Use max-heap to always access the largest pile
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        // Step 2: Add all piles to the max-heap
        for (int pile : piles) {
            maxHeap.add(pile);
        }

        // Step 3: Perform k operations
        for (int i = 0; i < k; i++) {
            int top = maxHeap.poll();         // Get largest pile
            int reduced = top - top / 2;      // Remove floor(top/2) stones
            maxHeap.add(reduced);             // Push reduced pile back
        }

        // Step 4: Sum up remaining stones
        int total = 0;
        while (!maxHeap.isEmpty()) {
            total += maxHeap.poll();
        }

        return total;
    }
}
