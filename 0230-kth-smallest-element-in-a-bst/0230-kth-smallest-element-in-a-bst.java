// ✅ Iterative with stack is best solution among all

class Solution {
    //morris traversal
    public int kthSmallest(TreeNode root, int k) {
        TreeNode current = root;
        int count = 0;
        int result = -1;

        while (current != null) {
            if (current.left == null) {
                // Visit node
                count++;
                if (count == k) result = current.val;
                current = current.right;
            } else {
                // Find inorder predecessor
                TreeNode predecessor = current.left;
                while (predecessor.right != null && predecessor.right != current) {
                    predecessor = predecessor.right;
                }

                if (predecessor.right == null) {
                    // Make current as right child of predecessor
                    predecessor.right = current;
                    current = current.left;
                } else {
                    // Revert changes
                    predecessor.right = null;
                    count++;
                    if (count == k) result = current.val;
                    current = current.right;
                }
            }
        }

        return result;
    }
}


/*
class Solution {
    //✅ Iterative with stack
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        int count = 0;

        while (current != null || !stack.isEmpty()) {
            // Go to the leftmost node
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            // Process node
            current = stack.pop();
            count++;

            if (count == k) {
                return current.val;
            }

            // Move to right subtree
            current = current.right;
        }

        return -1; // k is invalid (larger than number of nodes)
    }
}



class Solution {
    public int kthSmallest(TreeNode root, int k) {
        return inorderHelper(root, k, new int[]{0});
    }

    private Integer inorderHelper(TreeNode node, int k, int[] count) {
        if (node == null) return null;

        // Left
        Integer left = inorderHelper(node.left, k, count);
        if (left != null) return left;

        // Visit current
        count[0]++;
        if (count[0] == k) return node.val;

        // Right
        return inorderHelper(node.right, k, count);
    }
}

-----------------------------------------
class Solution {
    private int count = 0;
    private int result = -1;

    public int kthSmallest(TreeNode root, int k) {
        inorderHelper(root, k);
        return result;
    }

    private void inorderHelper(TreeNode node, int k) {
        if (node == null) return;

        // Traverse left subtree
        inorderHelper(node.left, k);

        // Visit current node
        count++;
        if (count == k) {
            result = node.val;
            return; // Early exit once kth element is found
        }

        // Traverse right subtree
        inorderHelper(node.right, k);
    }
}


// | Scenario                           | Time Complexity                           |
// | ---------------------------------- | ----------------------------------------- |
// | Best case (`k = 1`, leftmost node) | `O(h)` where `h = log n` in balanced tree |
// | Average / General case             | `O(k)`                                    |
// | Worst case (`k = n`)               | `O(n)`                                    |

// | Tree Type    | Space Complexity |
// | ------------ | ---------------- |
// | Balanced BST | `O(log n)`       |
// | Skewed BST   | `O(n)`           |

*/
