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
    private int count = 0;
    private int result = -1;

    public int kthSmallest(TreeNode root, int k) {
        this.count = k;
        inorder(root);
        return result;
    }

    private void inorder(TreeNode node) {
        if (node == null || result != -1) {
            return; // Stop if node is null or answer is already found
        }

        // 1. Visit left subtree
        inorder(node.left);

        // 2. Process current node
        count--;
        if (count == 0) {
            result = node.val;
            return;
        }

        // 3. Visit right subtree
        inorder(node.right);
    }
}