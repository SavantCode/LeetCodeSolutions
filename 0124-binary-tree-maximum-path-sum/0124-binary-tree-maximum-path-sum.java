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
//Approach - Recursively finding the best path
//T.C : O(n)
//S.C : O(n)
class Solution {
    
    private int maxSum;
    
    private int solve(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int left = solve(root.left);
        int right = solve(root.right);
        
        int neecheHiMilgayaAnswer = left + right + root.val; // (1)
        int koiEkAcha = Math.max(left, right) + root.val; // (2)
        int onlyRootAcha = root.val; // (3)

        maxSum = Math.max(maxSum, Math.max(neecheHiMilgayaAnswer, Math.max(koiEkAcha, onlyRootAcha)));
        
        // Most important part
        return Math.max(koiEkAcha, onlyRootAcha);
    }
    
    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        solve(root);
        return maxSum;
    }
}