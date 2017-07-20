package cr.ac.ucr.ecci.ci1310.cache.test;

import cr.ac.ucr.ecci.ci1310.cache.core.dao.WikiDao;
import cr.ac.ucr.ecci.ci1310.cache.core.dao.WikiDaoImpl;
import cr.ac.ucr.ecci.ci1310.cache.core.service.WikiService;
import cr.ac.ucr.ecci.ci1310.cache.core.service.WikiServiceImpl;
import cr.ac.ucr.ecci.ci1310.cache.model.WikiPage;
import cr.ac.ucr.ecci.ci1310.cache.model.cache.*;
import cr.ac.ucr.ecci.ci1310.cache.model.Entry;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gabriel on 7/15/2017.
 */
public class test {
    public static void main(String[] args) {
        /*Cache<Integer, String> cache = new LIFOCache<Integer, String>(2, "lru", 10);
        cache.put(24, "Hello");
        System.out.println(cache.get(24));
        System.out.println(cache.toString());
        cache.put(48, "Goodbye");
        cache.put(22, "Hi");
        cache.put(13, "dd");
        System.out.println(cache.get(24));
        cache.evict(22);
        System.out.println(cache.get(22));
        System.out.println(cache.toString());
        cache = new RandomCache<Integer, String>(2, "random", 10);
        cache.put(24, "Hello");
        System.out.println(cache.get(24));
        System.out.println(cache.toString());
        cache.put(48, "Goodbye");
        cache.put(22, "Hi");
        cache.put(13, "dd");
        System.out.println(cache.get(22));
        System.out.println(cache.toString());*/
        WikiDao wikiDao = new WikiDaoImpl();
        WikiService<WikiPage> wikiService= new WikiServiceImpl(wikiDao);
        WikiPage page = wikiService.findById("10");
        System.out.println(page.toString());
        List<WikiPage> pages = wikiService.findByTitle("Anarchism");
        if(pages == null) {
            System.out.println("Page not found");
        } else {
            System.out.println(pages.size());
            for (WikiPage p : pages) {
                System.out.println(p.toString());
            }
        }
    }
}
