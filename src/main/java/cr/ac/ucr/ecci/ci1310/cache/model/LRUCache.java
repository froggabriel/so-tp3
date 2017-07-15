package cr.ac.ucr.ecci.ci1310.cache.model;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Uses Least Recently Used as replacement algorithm in case of full cache
 */
public class LRUCache<K, V> extends MapCache<K, V> {
    private PriorityQueue<Entry<K, V>> entryPriorityQueue;

    public LRUCache(int maxElements, String name, int size, long lifespan, long elemLifespan) {
        super(maxElements, name, size, lifespan, elemLifespan);
        initPriorityQueue(maxElements);
    }

    public LRUCache(String name, int size, long lifespan, long elemLifespan) {
        super(name, size, lifespan, elemLifespan);
        initPriorityQueue(maxElements);

    }

    public LRUCache(int maxElements, String name, int size, long elemLifespan) {
        super(maxElements, name, size, elemLifespan);
        initPriorityQueue(maxElements);
    }

    public LRUCache(int maxElements, String name, int size) {
        super(maxElements, name, size);
        initPriorityQueue(maxElements);
    }

    public LRUCache(String name, int size) {
        super(name, size);
        initPriorityQueue(maxElements);
    }

    public String getName() {
        return this.name;
    }

    public synchronized V get(K key) {
        Entry<K, V> targetEntry = data.get(key);
        if(targetEntry == null) {
            return null;
        } else {
            targetEntry.updateLastQueryDate();
            return targetEntry.getValue();
        }
    }

    public synchronized void put(K key, V value) {
        while(isFull()) { //remove least recently used element if full
            Entry<K, V> targetEntry = entryPriorityQueue.remove();
            data.remove(targetEntry.getKey());
        }
        Entry<K, V> newEntry = new Entry<>(key, value);
        entryPriorityQueue.add(newEntry);
        data.put(key, newEntry);
    }

    public synchronized void evict(K key) {
        entryPriorityQueue.remove(new Entry<K, V>(key, null)); //Comparator compares by key
        data.remove(key);
    }

    public synchronized void clear() {
        entryPriorityQueue.clear();
        data.clear();
    }

    private void initPriorityQueue(int maxElements) {
        Comparator<Entry<K, V>> comparator = new Comparator<Entry<K, V>>() {
            @Override
            public int compare(Entry<K, V> o1, Entry<K, V> o2) {
                if(o1.getLastQueryDate().before(o2.getLastQueryDate()))
                    return -1;
                else
                    return 1;
            }
        };
        entryPriorityQueue = new PriorityQueue<>(maxElements, comparator);
    }
}
