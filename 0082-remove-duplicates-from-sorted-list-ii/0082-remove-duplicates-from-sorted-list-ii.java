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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;
        ListNode curr = head;

        while (curr != null) {
            // Check whether curr is the start of a duplicate group
            if (curr.next != null && curr.val == curr.next.val) {

                // Skip all nodes having the same value
                while (curr.next != null && curr.val == curr.next.val) {
                    curr = curr.next;
                }

                // Remove the entire duplicate group
                prev.next = curr.next;
            } else {
                // curr is unique, so keep it
                prev = curr;
            }

            curr = curr.next;
        }

        return dummy.next;
    }
}
