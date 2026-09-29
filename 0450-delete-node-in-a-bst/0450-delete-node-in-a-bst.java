class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        // 1. If key is at the root
        if (root.val == key) {
            return helper(root);
        }

        // 2. Search for the node to delete
        TreeNode dummy = root;
        while (root != null) {
            if (key < root.val) {
                if (root.left != null && root.left.val == key) {
                    root.left = helper(root.left);
                    break;
                } else {
                    root = root.left;
                }
            } else {
                if (root.right != null && root.right.val == key) {
                    root.right = helper(root.right);
                    break;
                } else {
                    root = root.right;
                }
            }
        }
        return dummy;
    }

    // Helper function to delete the target node and return the new root of the re-linked subtree
    private TreeNode helper(TreeNode node) {
        if (node.left == null) {
            return node.right;
        } else if (node.right == null) {
            return node.left;
        }

        // If both children exist:
        TreeNode rightChild = node.right;
        TreeNode lastRight = findLastRight(node.left); // Or find leftmost child of right subtree
        lastRight.right = rightChild;

        return node.left;
    }

    private TreeNode findLastRight(TreeNode node) {
        if (node.right == null) {
            return node;
        }
        return findLastRight(node.right);
    }
}