package cr.ac.ucr.ecci.ci1310.cache.model.cache;

import cr.ac.ucr.ecci.ci1310.cache.model.Entry;

import java.util.Stack;

/**
 * Uses Last in First Out as replacement algorithm in case of full cache
 */
public class LIFOCache<K, V> extends MapCache<K, V> {
    private Stack<Entry<K, V>> entryStack;

    public LIFOCache(int maxElements, String name, long lifespan, long elemLifespan) {
        super(maxElements, name, lifespan, elemLifespan);
        this.entryStack = new Stack<>();
    }

    public LIFOCache(String name, long lifespan, long elemLifespan) {
        super(name, lifespan, elemLifespan);
        this.entryStack = new Stack<>();
    }

    public LIFOCache(int maxElements, String name, long elemLifespan) {
        super(maxElements, name, elemLifespan);
        this.entryStack = new Stack<>();
    }

    public LIFOCache(int maxElements, String name) {
        super(maxElements, name);
        this.entryStack = new Stack<>();
    }

    public LIFOCache(String name) {
        super(name);
        this.entryStack = new Stack<>();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public V get(K key) {
        Entry<K, V> targetEntry = data.get(key);
        if(targetEntry == null) {
            return null;
        } else {
            entryStack.remove(targetEntry);
            entryStack.push(targetEntry);
            targetEntry.updateLastQueryDate();
            return targetEntry.getValue();
        }
    }

    @Override
    public void put(K key, V value) {
        while(isFull()) { //pop from stack if full
            Entry<K, V> targetEntry = entryStack.pop();
            data.remove(targetEntry.getKey());
        }
        Entry<K, V> newEntry = new Entry<>(key, value);
        entryStack.push(newEntry);
        data.put(key, newEntry);
    }

    @Override
    public void evict(K key) {
        entryStack.remove(new Entry<K, V>(key, null)); //compares by key
        data.remove(key);
    }

    @Override
    public void clear() {
        entryStack.clear();
        data.clear();
    }
}
