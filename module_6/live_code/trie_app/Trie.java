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

    }

    /**
     * Searches for a word in the trie.
     * 
     * @param word The word to search for.
     * @return True if the word is found, false otherwise.
     */
    public boolean search(String word) {

    }

    /**
     * Checks if there is any word in the trie that starts with the given prefix.
     * 
     * @param prefix The prefix to check for.
     * @return True if there is at least one word starting with the given prefix,
     *         false otherwise.
     */
    public boolean startsWith(String prefix) {

    }

    public int size() {
        return size;
    }
}

class TrieNode {

}
