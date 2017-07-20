package cr.ac.ucr.ecci.ci1310.cache.core.service;

import cr.ac.ucr.ecci.ci1310.cache.model.WikiPage;
import java.util.List;

/**
 * Created by alexiaborchgrevink on 7/13/17.
 */
public interface WikiService {

    public WikiPage findById(String id);

    public List<WikiPage> findByTitle(String title);
}
