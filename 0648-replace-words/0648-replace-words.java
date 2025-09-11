class Solution {

    static class TrieNode {
        boolean isWord;
        TrieNode[] children = new TrieNode[26];
    }

    // Insert a word (root) into Trie
    public void insert(TrieNode root, String word) {
        TrieNode curr = root;
        for (char ch : word.toCharArray()) {
            int idx = ch - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new TrieNode();
            }
            curr = curr.children[idx];
        }
        curr.isWord = true; // mark end of word
    }

    // Search for the shortest root prefix for a given word
    public String getShortestPrefix(TrieNode root, String word) {
        TrieNode curr = root;
        StringBuilder prefix = new StringBuilder();

        for (char ch : word.toCharArray()) {
            int idx = ch - 'a';
            if (curr.children[idx] == null) {
                break;
            }
            prefix.append(ch);
            curr = curr.children[idx];
            if (curr.isWord) {
                return prefix.toString(); // return as soon as we find a valid root
            }
        }

        return word; // no root found, return original word
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        TrieNode root = new TrieNode();

        // Insert all dictionary words (roots) into Trie
        for (String rootWord : dictionary) {
            insert(root, rootWord);
        }

        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            String replacement = getShortestPrefix(root, words[i]);
            result.append(replacement);

            if (i < words.length - 1) {
                result.append(" ");
            }
        }

        return result.toString();
    }
}
