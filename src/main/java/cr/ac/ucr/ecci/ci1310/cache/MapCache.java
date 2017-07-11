package cr.ac.ucr.ecci.ci1310.cache;

import java.util.HashMap;

/**
 * Structure for caches with hashmap as storage structure
 */
abstract class MapCache<K, V> implements Cache<K, V> {
    protected HashMap<K, Entry> data;
    private int maxElements;
    private String name;
    private int size;
    private long lifespan;
    private long elemLifespan;

    MapCache(int maxElements, String name, int size, long lifespan, long elemLifespan) {
        this.maxElements = maxElements;
        this.name = name;
        this.size = size;
        this.lifespan = lifespan;
        this.elemLifespan = elemLifespan;
    }

    MapCache(String name, int size, long lifespan, long elemLifespan) {
        this.maxElements = 10;
        this.name = name;
        this.size = size;
        this.lifespan = lifespan;
        this.elemLifespan = elemLifespan;
    }

    MapCache(int maxElements, String name, int size, long elemLifespan) {
        this.maxElements = maxElements;
        this.name = name;
        this.size = size;
        this.lifespan = -1;
        this.elemLifespan = elemLifespan;
    }

    MapCache(int maxElements, String name, int size) {
        this.maxElements = maxElements;
        this.name = name;
        this.size = size;
        this.lifespan = -1;
        this.elemLifespan = 3600;
    }

    MapCache(String name, int size) {
        this.maxElements = 10;
        this.name = name;
        this.size = size;
        this.lifespan = -1;
        this.elemLifespan = 3600;
    }
}
