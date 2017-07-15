package cr.ac.ucr.ecci.ci1310.cache.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Removes random element when cache full
 */
public class RandomCache<K, V> extends MapCache<K, V> {
    private List<Entry<K, V>> entryList;

    public RandomCache(int maxElements, String name, int size, long lifespan, long elemLifespan) {
        super(maxElements, name, size, lifespan, elemLifespan);
        entryList = new ArrayList<>();
    }

    public RandomCache(String name, int size, long lifespan, long elemLifespan) {
        super(name, size, lifespan, elemLifespan);
        entryList = new ArrayList<>();
    }

    public RandomCache(int maxElements, String name, int size, long elemLifespan) {
        super(maxElements, name, size, elemLifespan);
        entryList = new ArrayList<>();

    }

    public RandomCache(int maxElements, String name, int size) {
        super(maxElements, name, size);
        entryList = new ArrayList<>();

    }

    public RandomCache(String name, int size) {
        super(name, size);
        entryList = new ArrayList<>();

    }

    public String getName() {
        return this.name;
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
