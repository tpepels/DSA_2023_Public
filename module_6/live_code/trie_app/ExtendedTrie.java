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
                return words;
            }
            node = node.children[c - 'a'];
        }
        findAllWordsFromNode(node, words, prefix);
        return words;
    }

    // Helper method to recursively find all words from the given node
    private void findAllWordsFromNode(TrieNode node, List<String> words, String currentWord) {
        if (node.isEndOfWord) {
            words.add(currentWord);
        }
        //
        for (int i = 0; i < TrieNode.ALPHABET_SIZE; i++) {
            if (node.children[i] != null) {
                findAllWordsFromNode(node.children[i], words, currentWord + (char) (i + 'a'));
            }
        }
    }
}