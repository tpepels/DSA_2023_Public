package module_2.lecture;

import module_2.Dictionary;

public class HashTable<K, V> implements Dictionary<K, V> {

    class Entry<K, V> {
        K key;
        V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int DEFAULT_CAPACITY = 16;
    private Entry<K, V>[] table;
    private int size;

    public HashTable() {
        table = new Entry[DEFAULT_CAPACITY];
        size = 0;
    }

    private int hash(K key) {
        return Math.abs(key.hashCode() % table.length);
    }

    @Override
    public void put(K key, V value) {
        int index = hash(key);

        if (table[index] == null) {
            table[index] = new Entry(key, value);
            size++;
            if (size / (float) table.length > 0.8)
                grow();
        } else if (table[index] != null && table[index].key == key) {
            table[index].value = value;
        } else if (table[index] != null && table[index].key != key) {
            // Collision!
            return;
        }
    }

    @Override
    public V get(K key) {
        int index = hash(key);

        if (table[index] == null) {
            return null;
        } else if (table[index] != null && table[index].key == key) {
            return table[index].value;
        } else if (table[index] != null && table[index].key != key) {
            // Collision!
            return null;
        }
        return null;
    }

    @Override
    public V remove(K key) {
        int index = hash(key);

        if (table[index] == null) {
            return null;
        } else if (table[index] != null && table[index].key == key) {
            V value = table[index].value;
            table[index] = null;
            size--;
            return value;
        } else if (table[index] != null && table[index].key != key) {
            // Collision!
            return null;
        }
        return null;
    }

    @Override
    public boolean containsKey(K key) {
        int index = hash(key);

        if (table[index] == null) {
            return false;
        } else if (table[index] != null && table[index].key == key) {
            return true;
        } else if (table[index] != null && table[index].key != key) {
            return false;
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private void grow() {
        int newSize = table.length * 2;
        Entry<K, V>[] newTable = new Entry[newSize];

        for (int i = 0; i < table.length; i++) {
            if (table[i] == null)
                continue;
            Entry<K, V> entry = table[i];
            int newIndex = entry.key.hashCode() % newSize;
            if (newTable[newIndex] == null) {
                newTable[newIndex] = entry;
            } else {
                // Collision!
            }
        }
        this.table = newTable;
    }
}