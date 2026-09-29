class Solution {
    int result = Integer.MIN_VALUE;

    public int maxSumBST(TreeNode root) {
        helper(root);
        return result < 0 ? 0 : result;
    }

    // res[0]: minimum value of the subtree
    // res[1]: maximum value of the subtree
    // res[2]: sum of the subtree
    public int[] helper(TreeNode root) {
        if (root == null) {
            return new int[] { Integer.MAX_VALUE, Integer.MIN_VALUE, 0 };
        }

        int[] left = helper(root.left);
        int[] right = helper(root.right);

        // Check BST condition:
        // Invalid if left max >= root.val OR right min <= root.val
        if (left[1] >= root.val || right[0] <= root.val) {
            // Return inverted min/max so any ancestor checking this subtree will also fail BST check
            return new int[] { Integer.MIN_VALUE, Integer.MAX_VALUE, 0 };
        }

        int sum = left[2] + root.val + right[2];
        result = Math.max(result, sum);

        return new int[] { Math.min(root.val, left[0]), Math.max(root.val, right[1]), sum };
    }
}