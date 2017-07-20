package cr.ac.ucr.ecci.ci1310.cache.core.service;

import cr.ac.ucr.ecci.ci1310.cache.core.dao.WikiDao;
import cr.ac.ucr.ecci.ci1310.cache.model.WikiPage;

/**
 * Created by alexiaborchgrevink on 7/13/17.
 */
public class WikiServiceImpl implements WikiService {

    private WikiDao wikiDao;

    public WikiServiceImpl(WikiDao dao) {
        this.wikiDao = dao;
    }

    @Override
    public WikiPage findById(String id) {
        return wikiDao.findById(id);
    }

    @Override
    public WikiPage findByTitle(String title) {
        return wikiDao.findByTitle(title);
    }
}
