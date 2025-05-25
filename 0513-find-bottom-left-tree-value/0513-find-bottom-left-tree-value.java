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



// -----------------------------------------Method 2-----------------------------------------
// Time Complexity: O(n)
// You visit every node once.

// Space Complexity: O(n)
// Due to the queue which can hold up to one full level of nodes.

class Solution {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int leftmost = root.val;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {
                TreeNode current = queue.poll();

                if (i == 0) {
                    leftmost = current.val;
                }

                if (current.left != null) queue.offer(current.left);
                if (current.right != null) queue.offer(current.right);
            }
        }

        return leftmost;
    }
}




/*
-----------------------------------------Method 1-----------------------------------------
//Time Complexity: O(n)
// Let n = total number of nodes in the tree.

// Space Complexity: O(n)
// Due to the result list + BFS queue.

class Solution {
    public int findBottomLeftValue(TreeNode root) {
        List<List<Integer>> result = levelOrder(root);
        int n = result.size();
        return result.get(n - 1).get(0);

    

    }
    private List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        // Edge case: if the tree is empty
        if (root == null) {
            return result;
        }

        // Initialize a queue to process nodes level by level
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);  // Start BFS with the root node

        // Loop until all nodes are processed
        while (!queue.isEmpty()) {
            int levelSize = queue.size();  // Number of nodes in the current level
            List<Integer> currentLevel = new ArrayList<>();

            // Process all nodes at the current level
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();  // Dequeue node
                currentLevel.add(currentNode.val);    // Add node's value to level list

                // Enqueue left and right children if they exist
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }

            // Add this level's result to the final list
            result.add(currentLevel);
        }

        return result;
    }
}
*/