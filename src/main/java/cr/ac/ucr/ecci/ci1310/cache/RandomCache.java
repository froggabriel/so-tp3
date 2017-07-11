package cr.ac.ucr.ecci.ci1310.cache;

import java.util.List;

/**
 * Removes random element when cache full
 */
public class RandomCache<K, V> extends MapCache<K, V> {
    private List<Entry<K, V>> entryList;

    public RandomCache(int maxElements, String name, int size, long lifespan, long elemLifespan) {
        super(maxElements, name, size, lifespan, elemLifespan);
    }

    public RandomCache(String name, int size, long lifespan, long elemLifespan) {
        super(name, size, lifespan, elemLifespan);
    }

    public RandomCache(int maxElements, String name, int size, long elemLifespan) {
        super(maxElements, name, size, elemLifespan);
    }

    public RandomCache(int maxElements, String name, int size) {
        super(maxElements, name, size);
    }

    public RandomCache(String name, int size) {
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
