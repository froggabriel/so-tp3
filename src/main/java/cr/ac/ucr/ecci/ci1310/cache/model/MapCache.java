package cr.ac.ucr.ecci.ci1310.cache.model;

import java.util.HashMap;

/**
 * Structure for caches with hashmap as storage structure
 */
abstract class MapCache<K, V> implements Cache<K, V> {
    protected HashMap<K, Entry<K, V>> data;
    protected int maxElements;
    protected String name;
    protected int size;
    protected long lifespan;
    protected long elemLifespan;

    MapCache(int maxElements, String name, int size, long lifespan, long elemLifespan) {
        set(maxElements, name, size, lifespan, elemLifespan);
    }

    MapCache(String name, int size, long lifespan, long elemLifespan) {
        set(10, name, size, lifespan, elemLifespan);
    }

    MapCache(int maxElements, String name, int size, long elemLifespan) {
        set(maxElements, name, size, -1, elemLifespan);
    }

    MapCache(int maxElements, String name, int size) {
        set(maxElements, name, size, -1, 3600);
    }

    MapCache(String name, int size) {
        set(10, name, size, -1, 3600);
    }
    private void set(int maxElements, String name, int size, long lifespan, long elemLifespan) {
        this.maxElements = maxElements;
        this.name = name;
        this.size = size;
        this.lifespan = lifespan;
        this.elemLifespan = elemLifespan;
        data = new HashMap<>(maxElements);
    }

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
