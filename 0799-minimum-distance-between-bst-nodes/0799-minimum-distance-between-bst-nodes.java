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
    private TreeNode prev = null;

    private int minDiff = Integer.MAX_VALUE;

    public int minDiffInBST(TreeNode root) {
        // TreeNode prev = null;
        // int minDiff = Integer.MAX_VALUE;
        // re- initialise the variables if leetcode doesnt recognisess
        
        
        inorderTraversal(root);
        return minDiff;
    }

    public void inorderTraversal(TreeNode root) {
        if (root == null)
            return;

        inorderTraversal(root.left);

        if (prev != null) {
            minDiff = Math.min(minDiff, Math.abs(root.val - prev.val) );
        }
        prev = root;

        inorderTraversal(root.right);
    }

}

/*
| Complexity       | Value             | Reason                               |
| ---------------- | ----------------- | ------------------------------------ |
| Time Complexity  | O(n)              | Visit each node once                 |
| Space Complexity | O(h) (worst O(n)) | Recursion stack height = tree height |

h-> heght of tree

In the worst case:
If the tree is completely skewed (like a linked list), h = n → O(n)
If the tree is balanced, h = log n → O(log n)




Difference between static and instance variables??????

Instance variables--> (like private int minDiff) belong to each object (instance) of the class.
Every time you create a new Solution object, it gets its own separate copy.

Static variables --> belong to the class itself, not any one instance.
There is only one shared copy of a static variable no matter how many objects you create.





*/