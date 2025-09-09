class Solution {
    public ListNode deleteMiddle(ListNode head) {
        // Edge case: only one node
        if (head == null || head.next == null) return null;

        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        // Move slow by 1, fast by 2
        while (fast != null && fast.next != null) {// this case already handles case of having two nodes only
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // Delete the middle node
        prev.next = slow.next;

        return head;
    }
}
