/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (p.val < root.val && q.val < root.val) {
                root = root.left;
            } else if (p.val > root.val && q.val > root.val) {
                root = root.right;
            } else {
                return root;
            }
        }
        return null;
    }
}
// Time: Still O(h) where h is the height of the tree.

// Space: O(1) (no recursion stack)

/*-----------------------------------Method 1-----------------------------
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p.val == root.val || q.val == root.val) return root;
        else if(p.val < root.val && q.val > root.val) return root;
        else if(q.val < root.val && p.val > root.val) return root;
        else if(q.val < root.val && p.val < root.val) return lowestCommonAncestor(root.left, p, q);
        else return lowestCommonAncestor(root.right, p, q);
    }
}
*/

/*
```

This is a standard recursive solution for finding the **Lowest Common Ancestor (LCA)** in a **Binary Search Tree (BST)**.

---

### ✅ **Time Complexity**

* In each recursive call, you're choosing to go either **left** or **right** — just **one** subtree — not both.
* In a **balanced BST**, the height of the tree is `O(log n)` → best/average case.
* In a **skewed BST** (like a linked list), the height is `O(n)` → worst case.

So:

* **Best/Average Case:** `O(log n)`
* **Worst Case:** `O(n)`

Where `n` is the number of nodes in the tree.

---

### ✅ **Space Complexity**

* Since this is a **recursive** function, the space complexity depends on the **call stack depth**, which is equal to the height of the tree.

So:

* **Best/Average Case (Balanced Tree):** `O(log n)` (stack space)
* **Worst Case (Skewed Tree):** `O(n)`

Note: There’s no extra data structure used, so only the recursion stack contributes to space usage.

---

### \U0001f50d Summary:

| Case      | Time Complexity | Space Complexity |
| --------- | --------------- | ---------------- |
| **Best**  | `O(log n)`      | `O(log n)`       |
| **Worst** | `O(n)`          | `O(n)`           |



*/