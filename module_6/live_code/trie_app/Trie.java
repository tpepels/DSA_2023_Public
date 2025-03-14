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
            int index = c - 'a';
            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
                size++;
            }
            current = current.children[index];
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
            int index = c - 'a';
            if (current.children[index] == null) {
                return false;
            }
            current = current.children[index];
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
            int index = c - 'a';
            if (current.children[index] == null) {
                return false;
            }
            current = current.children[index];
        }
        return true;
    }

    public int size() {
        return size;
    }
}

class TrieNode {

    final int ALPHABET_SIZE = 26;
    TrieNode[] children = new TrieNode[ALPHABET_SIZE];
    boolean isEndOfWord = false;
    int passingWords = 0;

}
