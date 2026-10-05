/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        // Base case: empty list or single node without a loop
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;

        // Traverse the list
        while (fast != null && fast.next != null) {
            slow = slow.next;          // Move slow pointer 1 step
            fast = fast.next.next;     // Move fast pointer 2 steps

            // If fast and slow meet, a cycle exists
            //correction : // Check for match AFTER moving pointers
            if (slow == fast) {
                return true;
            }
        }

        // Fast pointer reached the end (null) -> no cycle
        return false;
    }
}