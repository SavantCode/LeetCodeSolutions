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

// Time Complexity  = O(n)
// Space Complexity = O(h)

class Solution {
    public int maxDepth(TreeNode root) {
        return solve(root);

    }

    public int solve(TreeNode root){
        if(root == null) return 0;

        if(root.left == null){
            return 1 + solve(root.right);
        }
        if(root.right == null){
            return 1 + solve(root.left);
        }

 
        return 1 + Math.max(solve(root.left), solve(root.right));
    }
}