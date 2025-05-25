class Solution {

    public void helper(List<List<Integer>> ans, List<Integer> path, TreeNode root, int sum) {
        if (root == null) return;

        path.add(root.val);

        // If it's a leaf and the path sum equals the target
        if (root.left == null && root.right == null && root.val == sum) {
            ans.add(new ArrayList<>(path)); // Copy the current path
        }

        // Recurse left and right
        helper(ans, path, root.left, sum - root.val);
        helper(ans, path, root.right, sum - root.val);

        // Backtrack
        path.remove(path.size() - 1);
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        helper(ans, path, root, targetSum);
        return ans;
    }
}
