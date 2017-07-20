package cr.ac.ucr.ecci.ci1310.cache.model.cache;

import cr.ac.ucr.ecci.ci1310.cache.model.Entry;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Uses Least Recently Used as replacement algorithm in case of full cache
 */
public class LRUCache<K, V> extends MapCache<K, V> {
    private PriorityQueue<Entry<K, V>> entryPriorityQueue;

    public LRUCache(int maxElements, String name, long lifespan, long elemLifespan) {
        super(maxElements, name, lifespan, elemLifespan);
        initPriorityQueue();
    }

    public LRUCache(String name, long lifespan, long elemLifespan) {
        super(name, lifespan, elemLifespan);
        initPriorityQueue();

    }

    public LRUCache(int maxElements, String name, long elemLifespan) {
        super(maxElements, name, elemLifespan);
        initPriorityQueue();
    }

    public LRUCache(int maxElements, String name) {
        super(maxElements, name);
        initPriorityQueue();
    }

    public LRUCache(String name) {
        super(name);
        initPriorityQueue();
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

    /**
     * Initializes priority queue with comparator based on Entry's lastQueryDate
     */
    private void initPriorityQueue() {
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
