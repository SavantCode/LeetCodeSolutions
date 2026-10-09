import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // 1. Create an ArrayList to store all the values
        ArrayList<Integer> nodeVals = new ArrayList<>(); 

        // 2. Traverse list1 and collect all values
        ListNode temp = list1;
        while (temp != null) { // Fixed: Check if temp itself is null, not temp.next
            nodeVals.add(temp.val);
            temp = temp.next;
        }

        // 3. Traverse list2 and collect all values
        temp = list2;
        while (temp != null) { // Fixed: Removed variable re-declaration error and fixed loop condition
            nodeVals.add(temp.val);
            temp = temp.next;
        }

        // Edge Case: If both lists were empty
        if (nodeVals.isEmpty()) {
            return null;
        }

        // 4. Crucial Step: Sort the collected values to merge them in order
        Collections.sort(nodeVals);

        // 5. Rebuild the linked list from the sorted array
        ListNode head = new ListNode(nodeVals.get(0)); // Fixed: Instantiate a new ListNode object
        temp = head;

        for (int i = 1; i < nodeVals.size(); i++) {
            ListNode curr = new ListNode(nodeVals.get(i)); // Fixed: Create a new node with the integer value
            temp.next = curr;
            temp = curr;
        }

        return head;
    }
}
