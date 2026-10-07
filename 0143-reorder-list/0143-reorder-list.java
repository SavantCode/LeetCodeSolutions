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
        if (head == null || head.next == null) {
            return;
        }

        int totalLength = findLength(head);
        solve(head, totalLength, 1);
    }

    public void solve(ListNode head, int totalLength, int insertAtIndex) {
        // Base Case: Stop when insert position reaches or exceeds total length - 1
        if (insertAtIndex >= totalLength - 1) {
            return;
        }

        // 1. Find the last node and detach it from the end
        ListNode lastNode = findLastNode(head);

        // 2. Insert the last node after the node at position insertAtIndex
        insertAt(head, lastNode, insertAtIndex);

        // 3. Move to the next insertion position (skipping the inserted node)
        solve(head, totalLength, insertAtIndex + 2);
    }

    public void insertAt(ListNode head, ListNode lastNode, int index) {
        ListNode temp = head;
        int count = 1;

        // Traverse to the node at position `index`
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

        // Traverse to the second-to-last node
        while (temp.next != null && temp.next.next != null) {
            temp = temp.next;
        }

        ListNode result = temp.next;
        temp.next = null; // Disconnect the last node
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