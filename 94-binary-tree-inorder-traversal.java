// 94-binary-tree-inorder-traversal.java


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
