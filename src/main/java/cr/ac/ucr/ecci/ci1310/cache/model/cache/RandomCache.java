package cr.ac.ucr.ecci.ci1310.cache.model.cache;

import cr.ac.ucr.ecci.ci1310.cache.model.Entry;

import java.util.ArrayList;
import java.util.List;

/**
 * Removes random element when cache full
 */
public class RandomCache<K, V> extends MapCache<K, V> {
    private List<Entry<K, V>> entryList;

    public RandomCache(int maxElements, String name, long lifespan, long elemLifespan) {
        super(maxElements, name, lifespan, elemLifespan);
        entryList = new ArrayList<>();
    }

    public RandomCache(String name, long lifespan, long elemLifespan) {
        super(name, lifespan, elemLifespan);
        entryList = new ArrayList<>();
    }

    public RandomCache(int maxElements, String name, long elemLifespan) {
        super(maxElements, name, elemLifespan);
        entryList = new ArrayList<>();
    }

    public RandomCache(int maxElements, String name) {
        super(maxElements, name);
        entryList = new ArrayList<>();
    }

    public RandomCache(String name) {
        super(name);
        entryList = new ArrayList<>();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public synchronized V get(K key) {
        Entry<K, V> targetEntry = data.get(key);
        if(targetEntry == null) {
            return null;
        } else {
            targetEntry.updateLastQueryDate();
            return targetEntry.getValue();
        }
    }

    @Override
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

    @Override
    public synchronized void evict(K key) {
        entryList.remove(new Entry<K, V>(key, null)); //Comparator compares by key
        data.remove(key);
    }

    @Override
    public synchronized void clear() {
        entryList.clear();
        data.clear();
    }
}
