class Solution {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = morrisInorder(root1);
        List<Integer> list2 = morrisInorder(root2);
        return mergeSortedLists(list1, list2);
    }

    private List<Integer> morrisInorder(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        TreeNode current = root;

        while (current != null) {
            if (current.left == null) {
                result.add(current.val);
                current = current.right;
            } else {
                TreeNode predecessor = current.left;

                // Find the rightmost node in the left subtree
                while (predecessor.right != null && predecessor.right != current) {
                    predecessor = predecessor.right;
                }

                if (predecessor.right == null) {
                    // Make thread
                    predecessor.right = current;
                    current = current.left;
                } else {
                    // Thread exists, restore tree
                    predecessor.right = null;
                    result.add(current.val);
                    current = current.right;
                }
            }
        }

        return result;
    }

    private List<Integer> mergeSortedLists(List<Integer> list1, List<Integer> list2) {
        List<Integer> merged = new ArrayList<>();
        int i = 0, j = 0;

        while (i < list1.size() && j < list2.size()) {
            if (list1.get(i) < list2.get(j)) {
                merged.add(list1.get(i++));
            } else {
                merged.add(list2.get(j++));
            }
        }

        while (i < list1.size()) merged.add(list1.get(i++));
        while (j < list2.size()) merged.add(list2.get(j++));

        return merged;
    }
}

/*
| Metric              | Complexity                                              |
| ------------------- | ------------------------------------------------------- |
| Time (Traversal)    | O(n + m)                                                |
| Time (Merging)      | O(n + m)                                                |
| Space (Output list) | O(n + m)                                                |
| Space (Extra)       | **O(1)** (due to Morris traversal, not counting output) |

Where n and m are the number of nodes in root1 and root2 respectively.

*/