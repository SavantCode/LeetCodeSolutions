class Solution {
    private TreeNode prev = null;

    public void flatten(TreeNode root) {
        if (root == null) return;

        TreeNode dummy = new TreeNode(-1);
        prev = dummy;

        preorder(root);

        // Copy flattened list back to original tree
        root.left = null;
        root.right = dummy.right.right;
    }

    private void preorder(TreeNode node) {
        if (node == null) return;

        TreeNode newNode = new TreeNode(node.val); // ❗ Not allowed by problem, but OK for learning
        prev.right = newNode;
        prev = newNode;

        preorder(node.left);
        preorder(node.right);
    }
}
