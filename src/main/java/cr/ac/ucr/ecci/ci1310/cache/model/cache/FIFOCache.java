package cr.ac.ucr.ecci.ci1310.cache.model.cache;

import cr.ac.ucr.ecci.ci1310.cache.model.Entry;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Uses First in First Out as replacement algorithm in case of full cache
 */
public class FIFOCache<K, V> extends MapCache<K, V> {
    private Queue<Entry<K, V>> entryQueue;

    public FIFOCache(int maxElements, String name, int size, long lifespan, long elemLifespan) {
        super(maxElements, name, size, lifespan, elemLifespan);
        this.entryQueue = new LinkedList<>();
    }

    public FIFOCache(String name, int size, long lifespan, long elemLifespan) {
        super(name, size, lifespan, elemLifespan);
        this.entryQueue = new LinkedList<>();
    }

    public FIFOCache(int maxElements, String name, int size, long elemLifespan) {
        super(maxElements, name, size, elemLifespan);
        this.entryQueue = new LinkedList<>();
    }

    public FIFOCache(int maxElements, String name, int size) {
        super(maxElements, name, size);
        this.entryQueue = new LinkedList<>();
    }

    public FIFOCache(String name, int size) {
        super(name, size);
        this.entryQueue = new LinkedList<>();
    }

    @Override
    public String getName() { //name lo asigna super, como se obtiene?
        return this.name;
    }

    @Override
    public V get(K key) {
        V value = data.get(key).getValue();
        return value;
    }

    @Override
    public void put(K key, V value) {
        entryQueue.add(new Entry<>(key, value));
    }

    @Override
    public void evict(K key) { //remove
        entryQueue.remove(key);
    }

    @Override
    public void clear() {
        entryQueue.clear();
    }
}
