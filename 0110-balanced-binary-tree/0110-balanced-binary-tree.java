/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

 class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;

        int left = findHeight(root.left);
        int right = findHeight(root.right);

        // Check current node AND recursively check both subtrees
        return Math.abs(left - right) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    public int findHeight(TreeNode root) {
        if (root == null) return 0;

        int left = findHeight(root.left);
        int right = findHeight(root.right);

        return 1 + Math.max(left, right);
    }
}