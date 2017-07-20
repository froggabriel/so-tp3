package cr.ac.ucr.ecci.ci1310.cache.model.cache;

/**
 * Cache interface
 */
public interface Cache<K, V> {
    /**
     * Gets name of cache
     * @return name of cache
     */
    String getName();

    /**
     * Gets value stored at specified key in cache
     * @param key storage key
     * @return value stored at key
     */
    V get(K key);

    /**
     * Puts specified value in specified key in cache
     * @param key storage key
     * @param value value to store
     */
    void put(K key, V value);

    /**
     * Evicts value stored at specified key from cache
     * @param key storage key
     */
    void evict(K key);

    /**
     * Clears all values in cache
     */
    void clear();
}
