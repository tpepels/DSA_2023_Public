package module_2.lecture_notes;

public class HashTable<K, V> {
    // Inner class for representing entries in the hash table
    private static class Entry<K, V> {
        // The key-value pair
        private final K key;
        private V value;
        // Reference to the next entry in the chain (if there is a collision)
        private Entry<K, V> next;

        public Entry(K key, V value, Entry<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    // The size of the array (i.e., the number of buckets)
    private final int size;
    // The array of entries (buckets)
    private final Entry<K, V>[] entries;

    @SuppressWarnings("unchecked")
    public HashTable(int size) {
        // Initialize the array of entries
        this.size = size;
        this.entries = new Entry[size];
    }

    public void put(K key, V value) {
        // Determine which bucket the key-value pair should go in
        int index = key.hashCode() % size;
        // Add the key-value pair to the front of the linked list for that bucket
        entries[index] = new Entry<>(key, value, entries[index]);
    }

    public V get(K key) {
        // Determine which bucket the key should be in
        int index = key.hashCode() % size;
        // Search the linked list for the key
        for (Entry<K, V> entry = entries[index]; entry != null; entry = entry.next) {
            if (entry.key.equals(key)) {
                // Return the value if the key is found
                return entry.value;
            }
        }
        // Return null if the key is not found
        return null;
    }
}
