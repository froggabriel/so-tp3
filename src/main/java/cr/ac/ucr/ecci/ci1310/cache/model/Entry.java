package cr.ac.ucr.ecci.ci1310.cache.model;

import java.util.Date;

/**
 * Memory entry
 */
public class Entry<K, V> {

    private K key;
    private V value;
    private Date lastQueryDate;

    public Entry() {

    }

    public Entry(K key, V value) {
        this.key = key;
        this.value = value;
        lastQueryDate = new Date();
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public Date getLastQueryDate() {
        return lastQueryDate;
    }

    public void updateLastQueryDate() {
        this.lastQueryDate = new Date();
    }

    @Override
    public boolean equals(Object otherEntry) {
        return otherEntry.getClass() == this.getClass() && this.key == ((Entry<K, V>) otherEntry).key;
    }
}
