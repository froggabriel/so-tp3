package cr.ac.ucr.ecci.ci1310.cache;

/**
 * Memory entry
 */
class Entry<K, V> {
    K key;
    V value;
    long lastQueryDate;
}
