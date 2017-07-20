package cr.ac.ucr.ecci.ci1310.cache.model.cache;

import cr.ac.ucr.ecci.ci1310.cache.model.Entry;

import java.util.Stack;

/**
 * Uses Last in First Out as replacement algorithm in case of full cache
 */
public class LIFOCache<K, V> extends MapCache<K, V> {
    private Stack<Entry<K, V>> entryStack;

    public LIFOCache(int maxElements, String name, int size, long lifespan, long elemLifespan) {
        super(maxElements, name, size, lifespan, elemLifespan);
        this.entryStack = new Stack<>();
    }

    public LIFOCache(String name, int size, long lifespan, long elemLifespan) {
        super(name, size, lifespan, elemLifespan);
        this.entryStack = new Stack<>();
    }

    public LIFOCache(int maxElements, String name, int size, long elemLifespan) {
        super(maxElements, name, size, elemLifespan);
        this.entryStack = new Stack<>();
    }

    public LIFOCache(int maxElements, String name, int size) {
        super(maxElements, name, size);
        this.entryStack = new Stack<>();
    }

    public LIFOCache(String name, int size) {
        super(name, size);
        this.entryStack = new Stack<>();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public V get(K key) {
        int index = entryStack.search(key);
        V value = entryStack.get(index).getValue();
        return value;
    }

    @Override
    public void put(K key, V value) {
        entryStack.push(new Entry<>(key, value));
    }

    @Override
    public void evict(K key) {
        entryStack.remove(key);
    }

    @Override
    public void clear() {
        entryStack.clear();

    }
}
