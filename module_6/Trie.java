public class Trie {
    protected TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Insert a word into the Trie
    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new TrieNode();
            }
            node = node.children[c - 'a'];
            node.passingWords++; // Increment the count of passing words
        }
        node.isEndOfWord = true;
    }

    // Search a word in the Trie
    public boolean search(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                return false;
            }
            node = node.children[c - 'a'];
        }
        return node.isEndOfWord;
    }

    // Check if there is any word in the Trie that starts with the given prefix
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (char c : prefix.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                return false;
            }
            node = node.children[c - 'a'];

        }
        return true;
    }
}

class TrieNode {
    TrieNode[] children = new TrieNode[26]; // Assuming lowercase English letters
    boolean isEndOfWord;
    int passingWords; // Counts the number of words that pass through this node

    TrieNode() {
        isEndOfWord = false;
        passingWords = 0;
        for (int i = 0; i < 26; i++) {
            children[i] = null;
        }
    }
}
