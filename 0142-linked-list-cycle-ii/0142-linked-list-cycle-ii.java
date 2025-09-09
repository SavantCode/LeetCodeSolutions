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


//T.C : O(n)
//S.C : O(1)
public class Solution {
    
    public ListNode detectCycle(ListNode head){
        if(head == null ||(head.next == null)) return null;

        ListNode fast = head;
        ListNode slow = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;


            if(slow == fast) break;
        }

        if(slow !=fast ) return null;

        ListNode p = head;
        
        while(p != slow){
            p = p.next;
            slow = slow.next;
        }
        return slow; // or you can return 'p' also since 'p' and 'slow' both are same at this point
    }

}






//brute force
// public class Solution {
//     public ListNode detectCycle(ListNode head) {
//         Set<ListNode> visited = new HashSet<>();
//         ListNode current = head;

//         while (current != null) {
//             if (visited.contains(current)) {
//                 // Cycle detected; current is start of cycle
//                 return current;
//             }
//             visited.add(current);
//             current = current.next;
//         }

//         // No cycle found
//         return null;
//     }

// }