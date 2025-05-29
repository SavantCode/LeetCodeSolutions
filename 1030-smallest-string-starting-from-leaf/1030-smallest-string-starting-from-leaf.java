import java.util.*;

class Solution {
    public String smallestFromLeaf(TreeNode root) {
        if (root == null) return "";

        String smallest = null;

        // Queue for BFS: stores Pair<Node, String>
        Queue<Pair<TreeNode, String>> queue = new LinkedList<>();
        queue.offer(new Pair<>(root, String.valueOf((char) ('a' + root.val))));

        while (!queue.isEmpty()) {
            Pair<TreeNode, String> current = queue.poll();
            TreeNode node = current.getKey();
            String path = current.getValue();

            // If it's a leaf node
            if (node.left == null && node.right == null) {
                String candidate = new StringBuilder(path).reverse().toString(); // leaf to root
                if (smallest == null || candidate.compareTo(smallest) < 0) {
                    smallest = candidate;
                }
            }

            // Push children with updated path
            if (node.left != null) {
                queue.offer(new Pair<>(node.left, path + (char) ('a' + node.left.val)));
            }

            if (node.right != null) {
                queue.offer(new Pair<>(node.right, path + (char) ('a' + node.right.val)));
            }
        }

        return smallest;
    }
}



























/*class Solution {
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
*/
// important CONCEPT

/*

### \U0001f4dd Why Use `insert(0, ...)` Instead of `append(...)` in Tree String Construction

In problems where we need to build a **string from a leaf node to the root** (like *"smallest string starting from leaf to root"*), using `StringBuilder.insert(0, ...)` is the cleanest solution.

#### ✅ Reason:

* `insert(0, char)` adds the character to the **front**, so the string is built in the **correct (leaf-to-root)** order as we go down the tree.
* `append(char)` builds the string in **root-to-leaf** order, which is the **reverse of what we want**, and would require an extra reversal step.

---

### \U0001f9ea Example Tree:

```
    a       (val = 0)
   / \
  b   c     (1)   (2)
```

**Expected strings (leaf → root):**

* `"ba"` (from leaf `b` to root `a`)
* `"ca"` (from leaf `c` to root `a`)

#### Using `insert(0, ...)`:

```java
path.insert(0, 'b'); // path = "b"
path.insert(0, 'a'); // path = "ab" → this is actually "ba" from leaf to root
```

#### If we used `append(...)`:

```java
path.append('a'); // root
path.append('b'); // leaf → path = "ab" (wrong direction)
```

Then you'd need: `path.reverse()` to fix it.

---

### ✅ Summary:

| Method                      | Builds Order | Needs Reverse? | Clean for Leaf-to-Root? |
| --------------------------- | ------------ | -------------- | ----------------------- |
| `insert(0, ...)`            | Leaf → Root  | ❌ No           | ✅ Yes                   |
| `append(...)` + `reverse()` | Root → Leaf  | ✅ Yes          | ❌ No                    |


| Tree Type           | Time Complexity |
| ------------------- | --------------- |
| Worst-case (skewed) | **O(n³)**       |
| Balanced tree       | **O(n log² n)** |

O(L × h²)


*/
