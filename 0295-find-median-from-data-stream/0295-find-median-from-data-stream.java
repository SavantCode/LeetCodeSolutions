//T.C : The overall time complexity is O(log N) for the addNum method and O(1) for the findMedian method.
//S.C : O(N).
public class MedianFinder {
    private PriorityQueue<Integer> leftMaxHeap; // max heap
    private PriorityQueue<Integer> rightMinHeap; // min heap

    public MedianFinder() {
        leftMaxHeap = new PriorityQueue<>(Collections.reverseOrder());
        rightMinHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if (leftMaxHeap.isEmpty() || num < leftMaxHeap.peek()) {
            leftMaxHeap.add(num);
        } else {
            rightMinHeap.add(num);
        }

        // always maintain leftMaxHeap size one greater than rightMinHeap size
        // or both sizes equal
        if (Math.abs(leftMaxHeap.size() - rightMinHeap.size()) > 1) {
            rightMinHeap.add(leftMaxHeap.poll());
        } else if (leftMaxHeap.size() < rightMinHeap.size()) {
            leftMaxHeap.add(rightMinHeap.poll());
        }
    }

    public double findMedian() {
        if (leftMaxHeap.size() == rightMinHeap.size()) {
            // even number of elements
            return (double) (leftMaxHeap.peek() + rightMinHeap.peek()) / 2;
        }

        // odd number of elements
        return leftMaxHeap.peek();
    }
}