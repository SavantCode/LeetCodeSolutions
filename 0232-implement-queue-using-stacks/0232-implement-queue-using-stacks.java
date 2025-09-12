import java.util.Stack;

class MyQueue {
    Stack<Integer> st = new Stack<>();      // Main stack to hold elements in queue order (front at top)
    Stack<Integer> helper = new Stack<>();  // Helper stack used to reorder elements during push

    // Constructor: Initializes an empty queue
    public MyQueue() {
    }
    
    /**
     * Push element x to the back of the queue.
     * 
     * Since we're implementing queue using stacks, 
     * we need to maintain the order so that front of the queue
     * is always on top of 'st'.
     * 
     * Steps:
     * 1. Move all elements from 'st' to 'helper' (reversing the order).
     * 2. Push the new element 'x' into the now empty 'st'.
     * 3. Move all elements back from 'helper' to 'st' to restore order.
     * 
     * This way, the newest element is at the bottom of 'st',
     * and the oldest (front) element is at the top.
     */
    public void push(int x) {
        if(st.size() == 0) {
            // If stack is empty, simply push the element
            st.push(x);
        } else {
            // Move all elements from st to helper stack
            while(st.size() > 0) {
                helper.push(st.pop());
            }
            // Push new element into empty st
            st.push(x);
            // Move elements back from helper to st
            while(helper.size() > 0) {
                st.push(helper.pop());
            }
        }
    }
    
    /**
     * Removes the element from in front of queue and returns it.
     * 
     * Since 'st' always has the front element at the top, simply pop from 'st'.
     */
    public int pop() {
        return st.pop();
    }
    
    /**
     * Get the front element.
     * 
     * Since 'st' always has the front element at the top, simply peek the top.
     */
    public int peek() {
        return st.peek();
    }
    
    /**
     * Returns whether the queue is empty.
     * 
     * Checks if 'st' is empty.
     */
    public boolean empty() {
        return st.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */


/*
| Operation | Time Complexity | Space Complexity |
| --------- | --------------- | ---------------- |
| `push(x)` | O(n)            | O(n) auxiliary   |
| `pop()`   | O(1)            | O(1)             |
| `peek()`  | O(1)            | O(1)             |
| `empty()` | O(1)            | O(1)             |

*/