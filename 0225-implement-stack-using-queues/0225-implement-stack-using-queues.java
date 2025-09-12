import java.util.LinkedList;
import java.util.Queue;

class MyStack {
    Queue<Integer> q = new LinkedList<>();

    public MyStack() {
    }

    public void push(int x) {
        q.add(x);
    }

    public int pop() {
        int size = q.size();
        for (int i = 0; i < size - 1; i++) {
            q.add(q.remove());
        }

        return q.remove();  // Remove the "top" element
    }

    public int top() {
        int size = q.size();
        for (int i = 0; i < size - 1; i++) {
            q.add(q.remove());
        }

        int top = q.peek();  // Peek the front element
        q.add(q.remove());   // Put it back to maintain order

        return top;
    }

    public boolean empty() {
        return q.isEmpty();
    }
}
