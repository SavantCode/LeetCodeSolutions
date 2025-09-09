/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

class Solution {
    /**
     * Deletes a node (except the tail) in a singly linked list,
     * given only access to that node.
     *
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     *
     * @param node The node to be "deleted"
     */
    public void deleteNode(ListNode node) {
        // Copy the next node's value into the current node
        node.val = node.next.val;

        // Skip the next node to remove it from the list
        node.next = node.next.next;
    }
}



// /**
//  * Definition for singly-linked list.
//  * public class ListNode {
//  *     int val;
//  *     ListNode next;
//  *     ListNode(int x) { val = x; }
//  * }
//  */
// //T.C : O(n)
// //S.C : O(1)
// class Solution {
//     public void deleteNode(ListNode node) {
//         ListNode prev = null;

//         while (node != null && node.next != null) {
//             node.val = node.next.val;
//             prev = node;
//             node = node.next;
//         }
        
//         if (node != null) {
//             if (prev != null)
//                 prev.next = null;
//             else
//                 node = null;
//         }
//     }
// }