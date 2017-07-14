package cr.ac.ucr.ecci.ci1310.cache.core.dao;

/**
 * Created by alexiaborchgrevink on 7/13/17.
 */
public interface WikiDao<T> {

    public T findById(String id);

    public T findByTitle(String title);
}
