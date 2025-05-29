class Solution {
    private String smallest = null;

    public String smallestFromLeaf(TreeNode root) {
        dfs(root, new StringBuilder());
        return smallest;
    }

    private void dfs(TreeNode node, StringBuilder path) {
        if (node == null) return;

        // Add current node's character to the path (prepend to simulate leaf-to-root)
        path.insert(0, (char)('a' + node.val));

        // If it's a leaf node
        if (node.left == null && node.right == null) {
            String current = path.toString();
            if (smallest == null || current.compareTo(smallest) < 0) {
                smallest = current;
            }
        }

        // Traverse children
        dfs(node.left, path);
        dfs(node.right, path);

        // Backtrack (remove the character we added at the front)
        path.deleteCharAt(0);
    }
}
