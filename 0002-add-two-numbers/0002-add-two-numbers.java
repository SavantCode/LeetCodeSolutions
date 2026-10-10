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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Dummy head to easily return the resulting linked list
        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;
        
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        int carry = 0;
        
        // Loop runs as long as there are digits left in l1, l2, or a leftover carry
        while (temp1 != null || temp2 != null || carry != 0) {
            int sum = carry; // Start with the carry from the previous addition
            
            if (temp1 != null) {
                sum += temp1.val;
                temp1 = temp1.next; // Advance l1 pointer
            }
            
            if (temp2 != null) {
                sum += temp2.val;
                temp2 = temp2.next; // Advance l2 pointer
            }
            
            // Calculate new carry (e.g., 12 / 10 = 1)
            carry = sum / 10;
            
            // Get the single digit value for the current node (e.g., 12 % 10 = 2)
            int digit = sum % 10;
            
            // Attach new node to the result list
            current.next = new ListNode(digit);
            current = current.next; // Advance current pointer
        }
        
        return dummyHead.next;
    }
}