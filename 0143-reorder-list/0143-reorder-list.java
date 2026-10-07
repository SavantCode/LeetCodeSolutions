/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        // FIX 1: Handle edge cases where list has 0, 1, or 2 nodes (no reordering needed)
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }

        int totalLength = findLength(head);
        solve(head, totalLength, 1);
        
        // FIX 2: Removed 'return head;' because method return type is void
    }

    public void solve(ListNode head, int totalLength, int insertAtIndex) {
        // FIX 3: Changed 'insertAtIndex == totalLength' to '>=' condition.
        // For even-length lists (e.g., length 4), insertAtIndex skips '4' (1 -> 3 -> 5),
        // causing infinite recursion. Checking '>= totalLength - 1' stops at the middle.
        if (insertAtIndex >= totalLength - 1) {
            return;
        }

        // Find the last node and detach it from the end of the list
        ListNode lastNode = findLastNode(head);

        // Insert lastNode after the node at position insertAtIndex
        insertAt(head, lastNode, insertAtIndex);

        // Recurse to insert the next tail node 2 positions ahead
        solve(head, totalLength, insertAtIndex + 2);
    }

    public void insertAt(ListNode head, ListNode lastNode, int index) {
        ListNode temp = head;
        
        // FIX 4: Set count = 1 instead of 0.
        // Starting at 0 traversed 1 node too far ahead.
        int count = 1;
        while (count < index && temp != null) {
            temp = temp.next;
            count++;
        }

        if (temp != null) {
            ListNode currNodeNext = temp.next;
            temp.next = lastNode;
            lastNode.next = currNodeNext;
        }
    }

    public ListNode findLastNode(ListNode head) {
        ListNode temp = head;

        // FIX 5: Added safety check to prevent NullPointerException on short lists
        while (temp.next != null && temp.next.next != null) {
            temp = temp.next;
        }

        ListNode result = temp.next;
        temp.next = null; // Break connection to orphan the last node
        
        return result;
    }

    public int findLength(ListNode head) {
        int length = 0;
        ListNode temp = head;
        while (temp != null) {
            temp = temp.next;
            length++;
        }
        return length;
    }
}