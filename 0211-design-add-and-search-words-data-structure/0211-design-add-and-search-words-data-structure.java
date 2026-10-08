class WordDictionary {

    private class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEndOfWord = false;
    }

    private final TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode current = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }
            current = current.children[index];
        }
        current.isEndOfWord = true;
    }
    
    public boolean search(String word) {
        return searchInNode(word, 0, root);
    }

    private boolean searchInNode(String word, int index, TrieNode current) {
        if (current == null) return false;
        if (index == word.length()) return current.isEndOfWord;

        char c = word.charAt(index);

        if (c == '.') {
            // Wildcard search: recursively check all non-null children
            for (TrieNode child : current.children) {
                if (child != null && searchInNode(word, index + 1, child)) {
                    return true;
                }
            }
            return false;
        } else {
            // Standard character check
            int childIndex = c - 'a';
            return searchInNode(word, index + 1, current.children[childIndex]);
        }
    }
}