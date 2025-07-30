import java.util.*;

class Solution {
    private List<String> result;
    private int rows, cols;
    private final int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    // Trie node class
    class TrieNode {
        boolean endOfWord;
        TrieNode[] children;
        String word;

        TrieNode() {
            endOfWord = false;
            children = new TrieNode[26];
            word = "";
        }
    }

    // Build the Trie
    private void insert(TrieNode root, String word) {
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

    // DFS search
    private void dfs(char[][] board, int i, int j, TrieNode node) {
        if (i < 0 || i >= rows || j < 0 || j >= cols || board[i][j] == '$') {
            return;
        }

        char ch = board[i][j];
        TrieNode next = node.children[ch - 'a'];
        if (next == null) return;

        if (next.endOfWord) {
            result.add(next.word);
            next.endOfWord = false; // Avoid duplicates
        }

        board[i][j] = '$'; // Mark visited
        for (int[] dir : directions) {
            dfs(board, i + dir[0], j + dir[1], next);
        }
        board[i][j] = ch; // Backtrack
    }

    public List<String> findWords(char[][] board, String[] words) {
        result = new ArrayList<>();
        rows = board.length;
        cols = board[0].length;

        TrieNode root = new TrieNode();
        for (String word : words) {
            insert(root, word);
        }

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
}
