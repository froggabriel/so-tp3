package cr.ac.ucr.ecci.ci1310.cache.core.service;

import cr.ac.ucr.ecci.ci1310.cache.model.WikiPage;

/**
 * Created by alexiaborchgrevink on 7/13/17.
 */
public interface WikiService<T> {

    public T findById(String id);

    public T findByTitle(String title);
}
