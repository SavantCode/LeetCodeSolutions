/*
    MY YOUTUBE VIDEO ON THIS Qn : https://www.youtube.com/watch?v=OLgXN2Yg3xQ
    Company Tags                : Morgan Stanley, Amazon, Microsoft, Snapdeal, MakeMyTrip, Ola Cabs, BankBazaar
    Leetcode Link               : https://leetcode.com/problems/copy-list-with-random-pointer/
*/

import java.util.HashMap;
import java.util.Map;

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null)
            return null;
            
        Map<Node, Node> mp = new HashMap<>();
        Node curr = head;
        Node prev = null;
        Node newHead = null;
        
        while (curr != null) {
            Node temp = new Node(curr.val);
            mp.put(curr, temp);
            if (newHead == null) {
                newHead = temp;
                prev = newHead;
            } else {
                prev.next = temp;
                prev = temp;
            }
            curr = curr.next;
        }
        
        curr = head;
        Node newCurr = newHead;
        while (curr != null) {
            if (curr.random == null) {
                newCurr.random = null;
            } else {
                newCurr.random = mp.get(curr.random);
            }
            
            newCurr = newCurr.next;
            curr = curr.next;
        }
        
        return newHead;
    }
}