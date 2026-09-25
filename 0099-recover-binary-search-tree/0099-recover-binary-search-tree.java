import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public void recoverTree(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        
        // 1. Extract values in in-order sequence
        inorderExtract(root, list);
        
        // 2. Sort the collected values
        Collections.sort(list);
        
        // 3. Put sorted values back in in-order sequence
        // We pass an index array or index container so it updates globally
        int[] index = new int[]{0};
        inorderPut(root, list, index);
    }

    private void inorderExtract(TreeNode root, List<Integer> list) {
        if (root == null) return;

        inorderExtract(root.left, list);
        list.add(root.val); // Root step
        inorderExtract(root.right, list);
    }

    private void inorderPut(TreeNode root, List<Integer> list, int[] index) {
        if (root == null) return;

        inorderPut(root.left, list, index);
        
        // Overwrite node value with sorted value
        root.val = list.get(index[0]);
        index[0]++; // Increment global index counter
        
        inorderPut(root.right, list, index);
    }
}