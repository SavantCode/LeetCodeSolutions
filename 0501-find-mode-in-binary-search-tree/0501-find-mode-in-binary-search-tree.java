import java.util.*;

class Solution {
    public int[] findMode(TreeNode root) {
        if (root == null) return new int[0];

        HashMap<Integer, Integer> freqMap = new HashMap<>();
        int maxFreq = 0;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        // Inorder traversal to fill freqMap
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            current = stack.pop();

            int val = current.val;
            int freq = freqMap.getOrDefault(val, 0) + 1;
            freqMap.put(val, freq);

            maxFreq = Math.max(maxFreq, freq);  // Keep track of max frequency

            current = current.right;
        }

        // Collect all values with max frequency
        List<Integer> modes = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            if (entry.getValue() == maxFreq) {
                modes.add(entry.getKey());
            }
        }

        // Convert List<Integer> to int[]
        int[] result = new int[modes.size()];
        for (int i = 0; i < modes.size(); i++) {
            result[i] = modes.get(i);
        }

        return result;
    }
}
