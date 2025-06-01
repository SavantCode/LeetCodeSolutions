import java.util.*;

public class Solution {

    public TreeNode sortedListToBST(ListNode head) {
        // Convert linked list to array
        List<Integer> list = traverseAndStore(head);
        int[] nums = list.stream().mapToInt(i -> i).toArray(); // Convert List<Integer> to int[]
        return sortedArrayToBST(nums);
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    private TreeNode helper(int[] nums, int lo, int hi) {
        if (lo > hi) return null;

        int mid = (lo + hi) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, lo, mid - 1);
        root.right = helper(nums, mid + 1, hi);

        return root;
    }

    public List<Integer> traverseAndStore(ListNode head) {
        List<Integer> values = new ArrayList<>();
        while (head != null) {
            values.add(head.val);
            head = head.next;
        }
        return values;
    }
}
