package cr.ac.ucr.ecci.ci1310.cache.caches;

/**
 * Cache interface
 */
public interface Cache<K, V> {
    String getName();

    V get(K key);

    void put(K key, V value);

    void evict(K key);

    void clear();
}
