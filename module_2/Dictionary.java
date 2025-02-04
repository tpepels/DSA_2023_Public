package module_2;

public interface Dictionary<K, V> {
    // Associates the specified value with the specified key
    void put(K key, V value);

    // Returns the value to which the specified key is mapped
    V get(K key);

    // Removes the mapping for a key if it is present
    V remove(K key);

    // Checks if the dictionary contains a mapping for the specified key
    boolean containsKey(K key);

    // Returns the number of key-value mappings in the dictionary
    int size();

    // Checks if the dictionary is empty
    boolean isEmpty();
}
