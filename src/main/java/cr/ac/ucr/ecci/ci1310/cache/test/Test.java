package cr.ac.ucr.ecci.ci1310.cache.test;

import cr.ac.ucr.ecci.ci1310.cache.core.dao.WikiDao;
import cr.ac.ucr.ecci.ci1310.cache.core.dao.WikiDaoImpl;
import cr.ac.ucr.ecci.ci1310.cache.core.service.WikiService;
import cr.ac.ucr.ecci.ci1310.cache.core.service.WikiServiceImpl;
import cr.ac.ucr.ecci.ci1310.cache.model.WikiPage;
import cr.ac.ucr.ecci.ci1310.cache.model.cache.*;

/**
 * Created by Gabriel on 7/15/2017.
 */
public class Test {
    private final int MAXENTRIES = 10000;
    public Test(){};
    public static void main(String[] args) {
        WikiDao wikiDao = new WikiDaoImpl();
        WikiService<WikiPage> service= new WikiServiceImpl(wikiDao);
        Test test = new Test();
        for(int i = 0; i < 6; i++)
            test.runAllTests(service, 20000, 10000);
    }

    private void runAllTests(WikiService<WikiPage> service, int times, int cachedElems) {
        System.out.println("Test");
        System.out.println(runTest(service, times, new FIFOCache<>(cachedElems,"fifo")));
        System.out.println(runTest(service, times, new LIFOCache<>(cachedElems,"lifo")));
        System.out.println(runTest(service, times, new LRUCache<>(cachedElems,"lru")));
        System.out.println(runTest(service, times, new RandomCache<>(cachedElems,"rand")));
        System.out.println(runTest(service, times, null));
    }

    private long runTest(WikiService<WikiPage> service, int times, Cache<String, WikiPage> cache) {
        if(cache == null) {
            return runNormalTest(service, times);
        } else {
            return runCacheTest(service, times, cache);
        }
    }

    private long runCacheTest(WikiService<WikiPage> service, int times, Cache<String, WikiPage> cache) {
        int rand_id;
        String key;
        long startTime = System.currentTimeMillis();
        for(int i = 0; i < times; i++) {
            rand_id = (int) (Math.random() * MAXENTRIES);
            key = Integer.toString(rand_id);
            WikiPage result = cache.get(key);
            if(result == null) {
                result = service.findById(key);
                cache.put(key, result);
            }
            /*if(result != null) {
                System.out.println(result.toString());
            }*/
        }
        return System.currentTimeMillis() - startTime;
    }

    private long runNormalTest(WikiService<WikiPage> service, int times) {
        int rand_id;
        String key;
        WikiPage result;
        long startTime = System.currentTimeMillis();
        for(int i = 0; i < times; i++) {
            rand_id = (int) (Math.random() * MAXENTRIES);
            key = Integer.toString(rand_id);
            result = service.findById(key);
            /*if (result != null) {
                System.out.println(result.toString());
            }*/
        }
        return System.currentTimeMillis() - startTime;
    }
}
