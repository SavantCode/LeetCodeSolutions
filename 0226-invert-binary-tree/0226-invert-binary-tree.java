class Solution {
    public TreeNode invertTree(TreeNode root) {
        // Base case: if the root is null, we are done
        if (root == null) {
            return null;
        }
        
        // Swap the left and right pointers
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        
        // Recursively invert the left and right subtrees
        invertTree(root.left);
        invertTree(root.right);
        
        return root;
    }
}