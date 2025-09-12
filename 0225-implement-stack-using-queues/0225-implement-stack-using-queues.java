//approach 2: efficient

// TC: O(1)
// SC: push--> O(n), pop--> O(1), peek--> O(1)

import java.util.LinkedList;
import java.util.Queue;

class MyStack {
    Queue<Integer> q = new LinkedList<>();

    public MyStack() {
    }

    public void push(int x) {
        if(q.size() == 0) q.add(x);
        else{
            q.add(x);
            for(int i  = 1; i <=q.size()-1; i++){
                q.add(q.remove());
            }
        }
    }

    public int pop() {
        return q.remove();
    }

    public int top() {
        return q.peek();
    }

    public boolean empty() {
        return q.isEmpty();
    }
}






//approach 1
/* 
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

TC : O(1)
SC : push()--> O(1), pop()--> O(n), pek()--> O(n)
*/