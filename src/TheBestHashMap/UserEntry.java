package TheBestHashMap;

public class UserEntry<K, V> {
    public K key;
    public V value;
    public UserEntry<K,V> next;

    public UserEntry(K key, V value, UserEntry<K, V> kvUserEntry) {
    }

    public V getValue() {
        return value;
    }

    public K getKey() {
        return key;
    }
    private UserEntry(K key, V value) {
        this.key = key;
        this.value = value;
    }

}
