import java.util.PriorityQueue;

class KthLargest {
    private final PriorityQueue<Integer> minHeap;
    private final int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.minHeap = new PriorityQueue<>();

        // Add all elements from initial array using the add method logic
        for (int num : nums) {
            add(num);
        }
    }
    
    public int add(int val) {
        // Add new value to the min-heap
        minHeap.offer(val);

        // Keep heap size at most k
        if (minHeap.size() > k) {
            minHeap.poll();
        }

        // Top element is the k-th largest
        return minHeap.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */