package cr.ac.ucr.ecci.ci1310.cache.caches;

/**
 * Uses Last in First Out as replacement algorithm in case of full cache
 */
public class LIFOCache<K, V> extends MapCache<K, V> implements Cache<K, V> {
    public LIFOCache(int maxElements, String name, int size, long lifespan, long elemLifespan) {
        super(maxElements, name, size, lifespan, elemLifespan);
    }

    public LIFOCache(String name, int size, long lifespan, long elemLifespan) {
        super(name, size, lifespan, elemLifespan);
    }

    public LIFOCache(int maxElements, String name, int size, long elemLifespan) {
        super(maxElements, name, size, elemLifespan);
    }

    public LIFOCache(int maxElements, String name, int size) {
        super(maxElements, name, size);
    }

    public LIFOCache(String name, int size) {
        super(name, size);
    }

    public String getName() {
        return null;
    }

    public V get(K key) {
        return null;
    }

    public void put(K key, V value) {

    }

    public void evict(K key) {

    }

    public void clear() {

    }
}
