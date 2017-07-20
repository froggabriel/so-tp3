package cr.ac.ucr.ecci.ci1310.cache.model.cache;

import cr.ac.ucr.ecci.ci1310.cache.model.Entry;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Uses First in First Out as replacement algorithm in case of full cache
 */
public class FIFOCache<K, V> extends MapCache<K, V> {
    private Queue<Entry<K, V>> entryQueue;

    public FIFOCache(int maxElements, String name, long lifespan, long elemLifespan) {
        super(maxElements, name, lifespan, elemLifespan);
        this.entryQueue = new LinkedList<>();
    }

    public FIFOCache(String name, long lifespan, long elemLifespan) {
        super(name, lifespan, elemLifespan);
        this.entryQueue = new LinkedList<>();
    }

    public FIFOCache(int maxElements, String name, long elemLifespan) {
        super(maxElements, name, elemLifespan);
        this.entryQueue = new LinkedList<>();
    }

    public FIFOCache(int maxElements, String name) {
        super(maxElements, name);
        this.entryQueue = new LinkedList<>();
    }

    public FIFOCache(String name) {
        super(name);
        this.entryQueue = new LinkedList<>();
    }

    @Override
    public String getName() { //name lo asigna super, como se obtiene?
        return this.name;
    }

    @Override
    public V get(K key) {
        Entry<K, V> targetEntry = data.get(key);
        if(targetEntry == null) {
            return null;
        } else {
            entryQueue.remove(targetEntry);
            entryQueue.add(targetEntry);
            targetEntry.updateLastQueryDate();
            return targetEntry.getValue();
        }
    }

    @Override
    public void put(K key, V value) {
        while(isFull()) { //remove from queue if full
            Entry<K, V> targetEntry = entryQueue.remove();
            data.remove(targetEntry.getKey());
        }
        Entry<K, V> newEntry = new Entry<>(key, value);
        entryQueue.add(newEntry);
        data.put(key, newEntry);
    }

    @Override
    public void evict(K key) { //remove
        entryQueue.remove(new Entry<K, V>(key, null)); //Comparator compares by key
        data.remove(key);
    }

    @Override
    public void clear() {
        entryQueue.clear();
        data.clear();
    }
}
