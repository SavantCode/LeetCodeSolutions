import java.util.Stack;  // Required for using Stack class

// Class to implement a Queue using two Stacks
class MyQueue {
    Stack<Integer> st = new Stack<>();      // Main stack to hold elements
    Stack<Integer> helper = new Stack<>();  // Helper stack used during pop and peek operations

    // Constructor (optional since nothing special is needed at construction)
    public MyQueue() {
    }

    // Enqueue operation: Push element to the back of the queue
    public void push(int x) {
        st.push(x); // Simply push to main stack
    }

    // Dequeue operation: Remove and return the front element of the queue
    public int pop() {
        // Transfer all elements from 'st' to 'helper' except the last one
        while (st.size() > 1) {
            helper.push(st.pop());  // Move elements from 'st' to 'helper'
        }

        // Now, 'st' has only one element, which is the front of the queue
        int x = st.pop();  // Remove and store that front element

        // Move elements back from 'helper' to 'st' to restore original order
        while (helper.size() > 0) {
            st.push(helper.pop());
        }

        return x;  // Return the dequeued front element
    }

    // Peek operation: Return (but do not remove) the front element of the queue
    public int peek() {
        // Move all elements except the last to helper stack
        while (st.size() > 1) {
            helper.push(st.pop());
        }

        // Peek at the last remaining element (front of queue)
        int x = st.peek();

        // Put everything back to restore the stack to original order
        while (helper.size() > 0) {
            st.push(helper.pop());
        }

        return x;  // Return the front element without removing it
    }

    // Check if the queue is empty
    public boolean empty() {
        // If main stack is empty, the queue is empty
        if (st.size() == 0)
            return true;
        else
            return false;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();         // Creates a new queue
 * obj.push(x);                         // Pushes x to the queue
 * int param_2 = obj.pop();             // Removes and returns front element
 * int param_3 = obj.peek();            // Returns front element without removing
 * boolean param_4 = obj.empty();       // Checks if queue is empty
 */
