class Solution {

    int count = 0;

    public int averageOfSubtree(TreeNode root) {
        solve(root);
        return count;
    }

    public int[] solve(TreeNode root) {

        if (root == null) {
            return new int[]{0, 0};
        }

        int[] left = solve(root.left);
        int[] right = solve(root.right);

        int sum = root.val + left[0] + right[0];
        int nodes = 1 + left[1] + right[1];

        if (root.val == sum / nodes) {
            count++;
        }

        return new int[]{sum, nodes};
    }
}
