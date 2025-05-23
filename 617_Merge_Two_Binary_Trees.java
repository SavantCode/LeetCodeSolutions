/*

🕒 Time Complexity: O(n)
Where n = total number of nodes in the smaller of the two trees.

Why? Because we visit each node in both trees at most once.

If both trees are complete and overlap fully, we’ll process every node once.

✅ Worst case: O(min(N1, N2))
✅ If same size: O(N), where N = number of nodes in tree

📦 Space Complexity:
🔹 Recursion stack: O(h)
Where h = height of the tree (max depth of recursion)

Worst case: skewed tree → O(n)

Best case: balanced tree → O(log n)

🔹 Extra memory:
The function creates a new tree, so in the worst case (where every node is merged or new), we allocate O(n) new nodes.


| Aspect               | Complexity     |
| -------------------- | -------------- |
| **Time**             | O(min(n1, n2)) |
| **Space (stack)**    | O(h)           |
| **Space (new tree)** | O(n)           |

*/



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
class Solution {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        // Base cases
        if (root1 == null) return root2;
        if (root2 == null) return root1;

        // Create new root with summed value
        TreeNode mergedRoot = new TreeNode(root1.val + root2.val);

        // Recursively merge left children
        mergedRoot.left = mergeTrees(root1.left, root2.left);
        // Recursively merge right children
        mergedRoot.right = mergeTrees(root1.right, root2.right);

        return mergedRoot;
    }
}
