class Solution {
    private TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null) return new TreeNode(val);

        if(root.val > val) {//go left
            if(root.left == null) root.left = new TreeNode(val);
            else insertIntoBST(root.left, val);
        }
        else{ // root.val < val --> go right
            if(root.right == null) root.right = new TreeNode(val);
            else insertIntoBST(root.right, val);
        }

        return root;
    }

    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = new TreeNode(preorder[0]);
        for(int i = 1 ; i<preorder.length; i++){
            root = insertIntoBST(root, preorder[i]);

        }
        return root;
    }

}
