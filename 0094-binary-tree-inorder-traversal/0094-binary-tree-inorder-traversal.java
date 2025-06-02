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
// Inorder Traversal Order:
// Left subtree → Root → Right subtree
// this is traversal using Iteration
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode node = root;

        while (node != null || !stack.isEmpty()) {
            // Traverse left subtree
            while (node != null) {
                stack.push(node);
                node = node.left;
            }

            // Visit node
            node = stack.pop();
            res.add(node.val);

            // Traverse right subtree
            node = node.right;
        }

        return res;
    }
}


/*
class Solution { // Morris Traversal

    public List<Integer> inorderTraversal(TreeNode root) {
        TreeNode curr = root;
        List<Integer> arr = new ArrayList<>();

        while (curr != null) {
            if (curr.left != null) { // find pred
                
                TreeNode pred = curr.left;
                while (pred.right != null && pred.right != curr) {
                    pred = pred.right;
                }

                if (pred.right == null) {
                    // Make a temporary link (thread) from pred to curr---> connect pred with curr
                    pred.right = curr;
                    curr = curr.left;
                } else {
                    // Thread already exists: remove it and visit curr --> unlink pred and curr
                    pred.right = null;
                    arr.add(curr.val);
                    curr = curr.right;
                }
            } else {
                // No left child; visit the current node
                arr.add(curr.val);
                curr = curr.right;
            }
        }

        return arr;
    }
}

*/