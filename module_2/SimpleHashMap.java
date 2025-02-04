package module_2;

public class SimpleHashMap<K, V> {

    /**
     * Internal class representing a key-value pair.
     */
    private static class Entry<K, V> {
        final K key;
        V value;
        final int hash; // storing the computed hash

        Entry(K key, V value, int hash) {
            this.key = key;
            this.value = value;
            this.hash = hash;
        }
    }

    private Entry<K, V>[] table;
    private int capacity;
    private int size;

    private static final int DEFAULT_CAPACITY = 16;

    /**
     * Constructs a SimpleHashMap with the default capacity.
     */
    public SimpleHashMap() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * Constructs a SimpleHashMap with the specified capacity.
     *
     * @param capacity the initial capacity of the hash map
     */
    @SuppressWarnings("unchecked")
    public SimpleHashMap(int capacity) {
        // No assumption that capacity is a power of 2 since we use modulus.
        this.capacity = capacity;
        this.table = (Entry<K, V>[]) new Entry[capacity];
        this.size = 0;
    }

    /**
     * Computes the hash code for a given key.
     *
     * @param key the key (null maps to 0)
     * @return the hash code for the key
     */
    private int hash(Object key) {
        return (key == null) ? 0 : key.hashCode();
    }

    /**
     * Computes the index in the table for a given hash code using modulus.
     *
     * This method uses {@link Math#floorMod} to ensure a non-negative result.
     *
     * @param hash the hash code
     * @return the index in the table array
     */
    private int indexFor(int hash) {
        return Math.floorMod(hash, capacity);
    }

    /**
     * Associates the specified value with the specified key in this map.
     *
     * If the key already exists, its value is updated.
     * If a collision occurs (i.e. a different key already occupies the computed
     * index),
     * an {@link IllegalStateException} is thrown.
     *
     * @param key   key with which the specified value is to be associated
     * @param value value to be associated with the specified key
     * @return the previous value associated with key, or null if there was no
     *         mapping
     */
    public V put(K key, V value) {
        int hash = hash(key);
        int index = indexFor(hash);

        Entry<K, V> existing = table[index];
        if (existing != null) {
            // If the same key exists, update its value.
            if ((existing.key == key) || (existing.key != null && existing.key.equals(key))) {
                V oldValue = existing.value;
                existing.value = value;
                return oldValue;
            } else {
                throw new IllegalStateException(
                        "Hash collision detected for keys: " + key + " and " + existing.key);
            }
        }
        table[index] = new Entry<>(key, value, hash);
        size++;
        return null;
    }

    /**
     * Returns the value associated with the specified key, or null if not found.
     *
     * @param key the key whose associated value is to be returned
     * @return the value associated with key, or null if no such mapping exists
     */
    public V get(K key) {
        int hash = hash(key);
        int index = indexFor(hash);
        Entry<K, V> entry = table[index];
        if (entry != null && ((entry.key == key) || (entry.key != null && entry.key.equals(key)))) {
            return entry.value;
        }
        return null;
    }

    /**
     * Removes the mapping for the specified key from this map, if present.
     *
     * @param key the key whose mapping is to be removed
     * @return the previous value associated with key, or null if there was no
     *         mapping
     */
    public V remove(K key) {
        int hash = hash(key);
        int index = indexFor(hash);
        Entry<K, V> entry = table[index];
        if (entry != null && ((entry.key == key) || (entry.key != null && entry.key.equals(key)))) {
            V oldValue = entry.value;
            table[index] = null;
            size--;
            return oldValue;
        }
        return null;
    }

    /**
     * Returns the number of key-value mappings in this map.
     *
     * @return the size of the map
     */
    public int size() {
        return size;
    }

    /**
     * A simple demonstration of the SimpleHashMap usage.
     */
    public static void main(String[] args) {
        // This clears the console (on most systems)
        System.out.print("\033[H\033[2J");
        System.out.flush();
        // Example 1: Using String keys.
        SimpleHashMap<String, Integer> map = new SimpleHashMap<>();
        map.put("apple", 1);
        map.put("banana", 2);

        System.out.println("apple: " + map.get("apple"));
        System.out.println("banana: " + map.get("banana"));

        // Example 2: Intentionally forcing a collision.
        // We'll create two different keys with the same hash code.
        KeyWithHash key1 = new KeyWithHash("key1", 42);
        KeyWithHash key2 = new KeyWithHash("key2", 42); // same hash code as key1

        SimpleHashMap<KeyWithHash, String> map2 = new SimpleHashMap<>();
        map2.put(key1, "Value for key1");

        try {
            // This call should throw an exception because key1 and key2,
            // although different, produce the same hash and map to the same index.
            map2.put(key2, "Value for key2");
        } catch (IllegalStateException ex) {
            System.out.println("Collision detected: " + ex.getMessage());
        }
    }

    /**
     * A helper class to create keys with a fixed hash code.
     * This is used to demonstrate a collision.
     */
    private static class KeyWithHash {
        private final String name;
        private final int fixedHash;

        KeyWithHash(String name, int fixedHash) {
            this.name = name;
            this.fixedHash = fixedHash;
        }

        @Override
        public int hashCode() {
            return fixedHash;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (!(obj instanceof KeyWithHash))
                return false;
            KeyWithHash other = (KeyWithHash) obj;
            return fixedHash == other.fixedHash && name.equals(other.name);
        }

        @Override
        public String toString() {
            return "Key(" + name + ")";
        }
    }
}
