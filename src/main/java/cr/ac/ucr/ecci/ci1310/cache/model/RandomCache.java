package cr.ac.ucr.ecci.ci1310.cache.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Removes random element when cache full
 */
public class RandomCache<K, V> extends MapCache<K, V> {
    private List<Entry<K, V>> entryList;

    public RandomCache(int maxElements, String name, int size, long lifespan, long elemLifespan) {
        super(maxElements, name, size, lifespan, elemLifespan);
        entryList = new ArrayList<>();
    }

    public RandomCache(String name, int size, long lifespan, long elemLifespan) {
        super(name, size, lifespan, elemLifespan);
        entryList = new ArrayList<>();
    }

    public RandomCache(int maxElements, String name, int size, long elemLifespan) {
        super(maxElements, name, size, elemLifespan);
        entryList = new ArrayList<>();
    }

    public RandomCache(int maxElements, String name, int size) {
        super(maxElements, name, size);
        entryList = new ArrayList<>();
    }

    public RandomCache(String name, int size) {
        super(name, size);
        entryList = new ArrayList<>();
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
            int rand = (int)((Math.random() * entryList.size()));
            Entry<K, V> targetEntry = entryList.remove(rand);
            data.remove(targetEntry.getKey());
        }
        Entry<K, V> newEntry = new Entry<>(key, value);
        entryList.add(newEntry);
        data.put(key, newEntry);
    }

    public synchronized void evict(K key) {
        entryList.remove(new Entry<K, V>(key, null)); //Comparator compares by key
        data.remove(key);
    }

    public synchronized void clear() {
        entryList.clear();
        data.clear();
    }
}
