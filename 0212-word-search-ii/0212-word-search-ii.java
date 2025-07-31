import java.util.*;

class Solution {
    // TrieNode class for internal use
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean endOfWord = false;
        String word = "";
    }

    // Directions for DFS (up, down, left, right)
    private final int[][] directions = {
        {-1, 0}, {1, 0}, {0, -1}, {0, 1}
    };

    private int rows, cols;
    private List<String> result;

    // Entry method
    public List<String> findWords(char[][] board, String[] words) {
        rows = board.length;
        cols = board[0].length;
        result = new ArrayList<>();

        // Build Trie
        TrieNode root = buildTrie(words);

        // Start DFS from every cell
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                char ch = board[i][j];
                if (root.children[ch - 'a'] != null) {
                    dfs(board, i, j, root);
                }
            }
        }

        return result;
    }

    // Build a Trie from given words
    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode current = root;
            for (char ch : word.toCharArray()) {
                int index = ch - 'a';
                if (current.children[index] == null) {
                    current.children[index] = new TrieNode();
                }
                current = current.children[index];
            }
            current.endOfWord = true;
            current.word = word;
        }
        return root;
    }

    // DFS to explore board and match Trie paths
    private void dfs(char[][] board, int i, int j, TrieNode node) {
        char ch = board[i][j];
        TrieNode current = node.children[ch - 'a'];
        if (current == null) return;

        // Word found
        if (current.endOfWord) {
            result.add(current.word);
            current.endOfWord = false; // Avoid duplicates
        }

        board[i][j] = '$'; // Mark as visited

        for (int[] dir : directions) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (x >= 0 && x < rows && y >= 0 && y < cols && board[x][y] != '$') {
                dfs(board, x, y, current);
            }
        }

        board[i][j] = ch; // Backtrack
    }
}
