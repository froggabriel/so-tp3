package cr.ac.ucr.ecci.ci1310.cache.core.service;

import cr.ac.ucr.ecci.ci1310.cache.core.dao.WikiDao;
import cr.ac.ucr.ecci.ci1310.cache.model.WikiPage;

import java.util.List;

/**
 * Created by alexiaborchgrevink on 7/13/17.
 */
public class WikiServiceImpl implements WikiService<WikiPage> {

    private WikiDao wikiDao;

    public WikiServiceImpl(WikiDao dao) {
        this.wikiDao = dao;
    }

    @Override
    public WikiPage findById(String id) {
        return wikiDao.findById(id);
    }

    @Override
    public List<WikiPage> findByTitle(String title) {
        return wikiDao.findByTitle(title);
    }
}
