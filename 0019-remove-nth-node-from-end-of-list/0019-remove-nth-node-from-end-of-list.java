class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        int length = findlengthLL(head);

        // if we need to remove first node
        if (n == length) {
            return head.next;
        }

        int target = length - n; // node just before deletion point

        ListNode temp = head;

        // move to (target - 1)th node
        for (int i = 1; i < target; i++) {
            temp = temp.next;
        }

        // delete nth node from end
        temp.next = temp.next.next;

        return head;
    }

    // find length of linked list
    public static int findlengthLL(ListNode head) {
        int count = 0;
        ListNode temp = head;

        while (temp != null) {
            count++;
            temp = temp.next;
        }

        return count;
    }
}