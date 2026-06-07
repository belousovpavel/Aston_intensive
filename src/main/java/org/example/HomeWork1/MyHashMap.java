package org.example.HomeWork1;


public class MyHashMap<K, V> {
    private static class Entry<K, V> {
        final K key;
        V value;
        Entry<K, V> next;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private Entry<K, V>[] table;
    private int capacity = 16;

    public MyHashMap() {
        table = new Entry[capacity];
    }

    private int hash(K key) {
        return key == null ? 0 : Math.abs(key.hashCode() % table.length);
    }

    public void put(K key, V value) {
        int index = hash(key);
        Entry<K, V> head = table[index];

        while (head != null) {
            if ((key == null && head.key == null) || (key != null && key.equals(head.key))) {
                head.value = value;
                return;
            }
            head = head.next;
        }

        Entry<K, V> newEntry = new Entry<>(key, value);
        newEntry.next = table[index];
        table[index] = newEntry;
    }

    public V get(K key) {
        int index = hash(key);
        Entry<K, V> head = table[index];

        while (head != null) {
            if ((key == null && head.key == null) || (key != null && key.equals(head.key))) {
                return head.value;
            }
            head = head.next;
        }

        return null;
    }

    public V remove(K key) {
        int index = hash(key);
        Entry<K, V> current = table[index];
        Entry<K, V> previous = null;

        while (current != null) {
            if ((key == null && current.key == null) || (key != null && key.equals(current.key))) {
                previous.next = current.next;
                return current.value;
            }
            previous = current;
            current = current.next;
        }
        return null;
    }

    public int size() {
        int size = 0;
        for (Entry<K, V> entry : table) {
            Entry<K, V> current = entry;
            while (current != null) {
                size++;
                current = current.next;
            }
        }
        return size;
    }
    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("{");

        boolean first = true;
        for (int i = 0; i < table.length; i++) {
            Entry<K, V> current = table[i];
            while (current != null) {
                if (!first) {
                    sb.append(", ");
                }
                sb.append(current.key).append("=").append(current.value);
                first = false;
                current = current.next;
            }
        }

        sb.append("}");
        return sb.toString();
    }
}

