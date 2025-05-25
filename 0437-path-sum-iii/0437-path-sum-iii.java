class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) return 0;

        // Count paths starting at the current root
        int count = noOfPathSum(root, (long) targetSum);

        // Recurse on left and right subtree to find paths starting there
        count += pathSum(root.left, targetSum);
        count += pathSum(root.right, targetSum);

        return count;
    }

    private int noOfPathSum(TreeNode root, long targetSum) {
        if (root == null) return 0;

        int count = 0;
        if ((long) root.val == targetSum) {
            count++;
        }

        // Continue path on left and right child
        count += noOfPathSum(root.left, targetSum - root.val);
        count += noOfPathSum(root.right, targetSum - root.val);

        return count;
    }
}
