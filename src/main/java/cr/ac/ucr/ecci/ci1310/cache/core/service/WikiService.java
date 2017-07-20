package cr.ac.ucr.ecci.ci1310.cache.core.service;

import java.util.List;

/**
 * Created by alexiaborchgrevink on 7/13/17.
 */
public interface WikiService<T> {

    public T findById(String id);

    public List<T> findByTitle(String title);
}
