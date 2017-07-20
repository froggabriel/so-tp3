package cr.ac.ucr.ecci.ci1310.cache.model.cache;

import cr.ac.ucr.ecci.ci1310.cache.model.Entry;

import java.util.HashMap;

/**
 * Structure for caches with hashmap as storage structure
 */
abstract class MapCache<K, V> implements Cache<K, V> {
    protected HashMap<K, Entry<K, V>> data;
    protected int maxElements;
    protected String name;
    protected long lifespan;
    protected long elemLifespan;

    MapCache(int maxElements, String name, long lifespan, long elemLifespan) {
        set(maxElements, name, lifespan, elemLifespan);
    }

    MapCache(String name, long lifespan, long elemLifespan) {
        set(10, name, lifespan, elemLifespan);
    }

    MapCache(int maxElements, String name, long elemLifespan) {
        set(maxElements, name, -1, elemLifespan);
    }

    MapCache(int maxElements, String name) {
        set(maxElements, name, -1, 3600);
    }

    MapCache(String name) {
        set(10, name, -1, 3600);
    }
    private void set(int maxElements, String name, long lifespan, long elemLifespan) {
        this.maxElements = maxElements;
        this.name = name;
        this.lifespan = lifespan;
        this.elemLifespan = elemLifespan;
        data = new HashMap<>(maxElements);
    }

    /**
     * Determines if cache is full
     * @return true if cache is full
     */
    protected boolean isFull() {
        return data.size() >= maxElements;
    }

    @Override
    public String toString() {
        return "Name: " + name + "\n"
                + "Size: " + data.size() + "\n"
                + "Max size: " + maxElements + "\n";
    }
}
