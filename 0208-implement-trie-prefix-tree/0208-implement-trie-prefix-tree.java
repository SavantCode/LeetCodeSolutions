class Trie {

    /** Trie node structure */
    private static class TrieNode {
        TrieNode[] children;
        boolean isEndOfWord;

        TrieNode() {
            children = new TrieNode[26]; // for 'a' to 'z'
            isEndOfWord = false;
        }
    }

    private final TrieNode root;

    /** Initialize the Trie object */
    public Trie() {
        root = new TrieNode();
    }

    /** Helper method to create a new TrieNode */
    private TrieNode getNode() {
        return new TrieNode();
    }

    /** Inserts a word into the trie */
    public void insert(String word) {
        TrieNode crawler = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (crawler.children[index] == null) {
                crawler.children[index] = getNode();
            }
            crawler = crawler.children[index];
        }
        crawler.isEndOfWord = true;
    }

    /** Returns true if the word is in the trie */
    public boolean search(String word) {
        TrieNode crawler = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (crawler.children[index] == null) {
                return false;
            }
            crawler = crawler.children[index];
        }
        return crawler != null && crawler.isEndOfWord;
    }

    /** Returns true if there is any word in the trie that starts with the given prefix */
    public boolean startsWith(String prefix) {
        TrieNode crawler = root;
        for (int i = 0; i < prefix.length(); i++) {
            int index = prefix.charAt(i) - 'a';
            if (crawler.children[index] == null) {
                return false;
            }
            crawler = crawler.children[index];
        }
        return true;
    }
}

/**
 * Time Complexity:
 *  insert(word)     -> O(L)
 *  search(word)     -> O(L)
 *  startsWith(prefix) -> O(L)
 * 
 * Space Complexity: O(N)
 *  where L = length of word/prefix,
 *        N = total number of nodes created across all words
 */

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */