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

//  Time Complexity  = O(n)
// Space Complexity = O(h)

// Worst-case Space = O(n)
// Balanced-tree Space = O(log n)


 class Solution {
    public int minDepth(TreeNode root) {
        return solve(root);
    }

    public int solve(TreeNode root) {

        // Empty tree
        if (root == null) {
            return 0;
        }

        // Only right child exists
        if (root.left == null) {
            return 1 + solve(root.right);
        }

        // Only left child exists
        if (root.right == null) {
            return 1 + solve(root.left);
        }

        // Both children exist
        return 1 + Math.min( solve(root.left), solve(root.right));
    }
}
