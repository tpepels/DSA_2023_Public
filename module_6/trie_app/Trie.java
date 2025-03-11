package trie_app;

/**
 * The Trie class represents a trie (prefix tree) data structure
 * that provides efficient storage and retrieval of strings.
 */
public class Trie {
    /**
     * The root node of the trie.
     */
    protected TrieNode root;
    private int size;

    /**
     * Constructor that initializes the trie with a root node.
     */
    public Trie() {
        root = new TrieNode();
        size = 0;
    }

    /**
     * Inserts a word into the trie.
     * 
     * @param word The word to insert into the trie.
     */
    public void insert(String word) {
        // Start from the root node
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            // Calculate the index of the child node based on the current character
            // 'a' has an index of 0, 'b' has 1, and so on.
            if (node.children[c - 'a'] == null) {
                // If the child node doesn't exist, create a new TrieNode at this index
                node.children[c - 'a'] = new TrieNode();
                size++;
            }
            // Move to the child node
            node = node.children[c - 'a'];
            // Increment the count of passing words for this node
            node.passingWords++;
        }
        // Mark the last node as the end of a word
        node.isEndOfWord = true;
    }

    /**
     * Searches for a word in the trie.
     * 
     * @param word The word to search for.
     * @return True if the word is found, false otherwise.
     */
    public boolean search(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            // If the child node for the current character doesn't exist, the word is not in
            // the trie
            if (node.children[c - 'a'] == null) {
                return false;
            }
            // Move to the child node
            node = node.children[c - 'a'];
        }
        // Return true if the current node marks the end of a word
        return node.isEndOfWord;
    }

    /**
     * Checks if there is any word in the trie that starts with the given prefix.
     * 
     * @param prefix The prefix to check for.
     * @return True if there is at least one word starting with the given prefix,
     *         false otherwise.
     */
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (char c : prefix.toCharArray()) {
            // If the child node for the current character doesn't exist, no word starts
            // with the given prefix
            if (node.children[c - 'a'] == null) {
                return false;
            }
            // Move to the child node
            node = node.children[c - 'a'];
        }
        // Return true since there is at least one word starting with the given prefix
        return true;
    }

    public int size() {
        return size;
    }
}

class TrieNode {
    public TrieNode[] children = new TrieNode[26]; // Assuming lowercase English letters
    public boolean isEndOfWord;
    public int passingWords; // Counts the number of words that pass through this node

    TrieNode() {
        isEndOfWord = false;
        passingWords = 0;
        for (int i = 0; i < 26; i++) {
            children[i] = null;
        }
    }
}
