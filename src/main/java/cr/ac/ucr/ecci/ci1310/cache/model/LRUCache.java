package cr.ac.ucr.ecci.ci1310.cache.model;

import java.util.PriorityQueue;

/**
 * Uses Least Recently Used as replacement algorithm in case of full cache
 */
public class LRUCache<K, V> extends MapCache<K, V> {
    private PriorityQueue<Entry<K, V>> entryPriorityQueue;

    public LRUCache(int maxElements, String name, int size, long lifespan, long elemLifespan) {
        super(maxElements, name, size, lifespan, elemLifespan);
        entryPriorityQueue = new PriorityQueue<>();
    }

    public LRUCache(String name, int size, long lifespan, long elemLifespan) {
        super(name, size, lifespan, elemLifespan);
        entryPriorityQueue = new PriorityQueue<>();

    }

    public LRUCache(int maxElements, String name, int size, long elemLifespan) {
        super(maxElements, name, size, elemLifespan);
        entryPriorityQueue = new PriorityQueue<>();

    }

    public LRUCache(int maxElements, String name, int size) {
        super(maxElements, name, size);
        entryPriorityQueue = new PriorityQueue<>();
    }

    public LRUCache(String name, int size) {
        super(name, size);
        entryPriorityQueue = new PriorityQueue<>();

    }

    public String getName() {
        return this.getSuperName();
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
