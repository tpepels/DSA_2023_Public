package trie_app;

import java.util.ArrayList;
import java.util.List;

class ExtendedTrie extends Trie {

    // Constructor
    public ExtendedTrie() {
        super();
    }

    // Method to fetch all words in the trie that start with the given prefix
    public List<String> getWordsWithPrefix(String prefix) {
        List<String> words = new ArrayList<>();
        TrieNode node = root;
        for (char c : prefix.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                return words; // Empty list if prefix not found
            }
            node = node.children[c - 'a'];
        }
        // At this point, node corresponds to the last character of the prefix
        findAllWordsFromNode(node, words, prefix);
        return words;
    }

    // Helper method to recursively find all words from the given node
    private void findAllWordsFromNode(TrieNode node, List<String> words, String currentWord) {
        if (node.isEndOfWord) {
            words.add(currentWord);
        }

        for (char c = 'a'; c <= 'z'; c++) {
            if (node.children[c - 'a'] != null) {
                findAllWordsFromNode(node.children[c - 'a'], words, currentWord + c);
            }
        }
    }
}
