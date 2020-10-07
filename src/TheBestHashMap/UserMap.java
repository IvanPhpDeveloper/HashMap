package TheBestHashMap;

import java.util.*;

import static java.util.Objects.hash;

public class UserMap<K,V> implements Map<K,V> {
    private static final int DEFAULT_SIZE = 20;
    private UserEntry<K, V>[] buckets;
    private int size;
    public K key;
    public V value;





    public UserMap() {
        this(DEFAULT_SIZE);
    }


    @SuppressWarnings("unchecked")
    public UserMap(int bucketSize) {
        buckets = new UserEntry[bucketSize];
        size = 0;
    }

    private int getIndex(Object key) {
        return key.hashCode() % buckets.length;
    }

    @Override
    public int size() {
        return DEFAULT_SIZE;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public boolean containsKey(Object key) {
        int keyBucket = hash(key);//значение ключа корзины

        UserEntry<K, V> temp = buckets[keyBucket];
        while (temp != null) {
            if ((temp.key == null && key == null)
                    || (temp.key != null && temp.key.equals(key))) {
                return true;
            }
            temp.next = temp;
        }
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        for (UserEntry<K, V> bucket : buckets) {
            if(bucket!=null && bucket.getValue()==value){
                return true;
            }
        }
        return false;
    }



    @Override
    public V get(Object key) {
        return null;
    }

    @Override
    public V put(K key, V value) {
        int keyBucket = hash(key);//значение ключа корзины

        UserEntry<K, V> temp = buckets[keyBucket];
        while (temp != null) {
            if ((temp.key == null && key == null)
                    || (temp.key != null && temp.key.equals(key))) {
                temp.value = value;

            }
            temp = temp.next;
        }

        buckets[keyBucket] = new UserEntry<K, V>(key, value, buckets[keyBucket]);
        size++;
        return value;
    }

    @Override
    public V remove(Object key) {
        int keyBucket = hash(key);
        if (buckets[keyBucket].getKey() == key) {
            for (int i =keyBucket; i < buckets.length; i++) {
                buckets[i] = null;
            }
        }
        return null;
    }



    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        for (Entry<? extends K, ? extends V> entry : m.entrySet()) {
            K key = entry.getKey();
            V value = entry.getValue();
            this.put(key, value);
        }
    }

    

    @Override
    public void clear() {
        Arrays.fill(buckets, null);
        size = 0;

    }

    @Override
    public Set<K> keySet() {
        Set<K> set = new HashSet<>();
        for (UserEntry<K, V> bucket : buckets) {
            if (bucket != null) {
                set.add(bucket.key);
                size++;
            }
        }
        return set;
    }



    @Override
    public Collection<V> values() {
        return null;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        Set<Entry<K, V>> setEntry = new HashSet<>();
        for (UserEntry<K, V> bucket : buckets) {
            UserEntry<K, V> entry = bucket;
            if (bucket != null) {
                setEntry.add((Entry<K, V>) entry);
                size++;
            }
        }
        return setEntry;
    }

}

