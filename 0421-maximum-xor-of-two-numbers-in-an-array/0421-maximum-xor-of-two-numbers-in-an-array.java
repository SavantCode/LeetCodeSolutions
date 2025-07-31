class Solution {
    static class TrieNode {
        TrieNode left;   // represents bit 0
        TrieNode right;  // represents bit 1
    }

    private void insert(TrieNode root, int num) {
        TrieNode pCrawl = root;
        for (int i = 31; i >= 0; i--) {
            int ithBit = (num >> i) & 1;
            if (ithBit == 0) {
                if (pCrawl.left == null) {
                    pCrawl.left = new TrieNode();
                }
                pCrawl = pCrawl.left;
            } else {
                if (pCrawl.right == null) {
                    pCrawl.right = new TrieNode();
                }
                pCrawl = pCrawl.right;
            }
        }
    }

    private int maxXor(TrieNode root, int num) {
        TrieNode pCrawl = root;
        int maxXor = 0;
        for (int i = 31; i >= 0; i--) {
            int ithBit = (num >> i) & 1;
            if (ithBit == 1) {
                if (pCrawl.left != null) {
                    maxXor |= (1 << i);
                    pCrawl = pCrawl.left;
                } else {
                    pCrawl = pCrawl.right;
                }
            } else {
                if (pCrawl.right != null) {
                    maxXor |= (1 << i);
                    pCrawl = pCrawl.right;
                } else {
                    pCrawl = pCrawl.left;
                }
            }
        }
        return maxXor;
    }

    public int findMaximumXOR(int[] nums) {
        TrieNode root = new TrieNode();
        for (int num : nums) {
            insert(root, num);
        }

        int maxResult = 0;
        for (int num : nums) {
            maxResult = Math.max(maxResult, maxXor(root, num));
        }

        return maxResult;
    }
}
