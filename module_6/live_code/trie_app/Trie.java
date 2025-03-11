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
        TrieNode current = root;
        for (char c : word.toCharArray()) {
            if (current.children[c - 'a'] == null) {
                current.children[c - 'a'] = new TrieNode();
                size++;
            }
            current = current.children[c - 'a'];
            current.passingWords++;
        }
        current.isEndOfWord = true;

    }

    /**
     * Searches for a word in the trie.
     * 
     * @param word The word to search for.
     * @return True if the word is found, false otherwise.
     */
    public boolean search(String word) {
        TrieNode current = root;
        for (char c : word.toCharArray()) {
            if (current.children[c - 'a'] == null) {
                return false;
            }
            current = current.children[c - 'a'];
        }
        return current.isEndOfWord;
    }

    /**
     * Checks if there is any word in the trie that starts with the given prefix.
     * 
     * @param prefix The prefix to check for.
     * @return True if there is at least one word starting with the given prefix,
     *         false otherwise.
     */
    public boolean startsWith(String prefix) {
        TrieNode current = root;
        for (char c : prefix.toCharArray()) {
            if (current.children[c - 'a'] == null) {
                return false;
            }
            current = current.children[c - 'a'];
        }
        return true;
    }

    public int size() {
        return size;
    }
}

class TrieNode {
    /**
     * The number of children of the node.
     */
    protected static final int ALPHABET_SIZE = 26;

    /**
     * The children of the node.
     */
    protected TrieNode[] children = new TrieNode[ALPHABET_SIZE];
    boolean isEndOfWord;

    int passingWords = 0;

    public TrieNode() {
        isEndOfWord = false;

    }

}
