package cr.ac.ucr.ecci.ci1310.cache.build;

import cr.ac.ucr.ecci.ci1310.cache.core.dao.WikiDao;
import cr.ac.ucr.ecci.ci1310.cache.core.dao.WikiDaoImpl;
import cr.ac.ucr.ecci.ci1310.cache.core.service.WikiService;
import cr.ac.ucr.ecci.ci1310.cache.core.service.WikiServiceImpl;
import cr.ac.ucr.ecci.ci1310.cache.model.Entry;
import cr.ac.ucr.ecci.ci1310.cache.model.WikiPage;
import cr.ac.ucr.ecci.ci1310.cache.model.cache.LRUCache;
import cr.ac.ucr.ecci.ci1310.cache.model.cache.Cache;
import cr.ac.ucr.ecci.ci1310.cache.model.cache.RandomCache;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * Created by alexiaborchgrevink on 7/13/17.
 */
public class MenuController {

    WikiDao wikiDao = new WikiDaoImpl();
    WikiService wikiService = new WikiServiceImpl(wikiDao);
    Cache cacheById;
    Cache cacheByTitle;

    public static void main(String[] args) {
        new MenuController().Menu();
    }

    public void Menu() {

        System.out.println("Especifique si desea usar el cache.\n 0 - el cache sera utilizado\n 1 - el cache no sera utilizado");
        Scanner scanner = new Scanner(System.in);
        int useCache = scanner.nextInt();
        switch (useCache) {
            case 0: //usa cache
                System.out.println("-- El cache sera utilizado -- ");
                System.out.println("Ingrese el numero maximo de elementos en el cache (int):");
                int numElementos = scanner.nextInt();
                System.out.println("Ingrese el nombre del cache");
                String cacheName = scanner.next();
                System.out.println("Puede realizar consultas a la base de datos de acuerdo a id y/o titulo");
                cacheById = new LRUCache(numElementos, cacheName);
                cacheByTitle = new RandomCache(numElementos, cacheName);
                while (true) {
                    System.out.println("Especifique el tipo de consulta que desea realizar.\n 1 - Buscar por id \n 2 - Buscar por titulo");
                    int consultType = scanner.nextInt();
                    if (consultType == 1) {
                        cacheVersion(this.cacheById, consultType);
                    } else {
                        cacheVersion(this.cacheByTitle, consultType);
                    }
                    System.out.println("Desea continuar?\n1 - Si\n0 - No");
                    int continuar = scanner.nextInt();
                    if (continuar == 0) {
                        break;
                    }
                }
                break;
            case 1: //no usa cache
                System.out.println("-- El cache no sera utilizado -- ");
                while (true) {
                    System.out.println("Especifique el tipo de consulta que desea realizar.\n 1 - Buscar por id \n 2 - Buscar por titulo");
                    int consultType2 = scanner.nextInt();
                    switch (consultType2) {
                        case 1: //consulta por id
                            System.out.println("Ingrese el id a consultar");
                            String findId = scanner.next();
                            this.findIdByService(findId);
                            break;
                        case 2: //consulta por titulo
                            System.out.println("Ingrese el titulo a consultar");
                            String findTitle = scanner.next();
                            this.findTitleByService(findTitle);
                            break;
                    }
                    System.out.println("Desea continuar?\n1 - Si\n0 - No");
                    int continuar = scanner.nextInt();
                    if (continuar == 0) {
                        break;
                    }
                }
        }
    }

    public void cacheVersion(Cache cache, int consultType) {
        Scanner scanner = new Scanner(System.in);
        switch (consultType) {
            case 1: //consulta por id
                System.out.println("Ingrese el id a consultar");
                String findId = scanner.next();
                this.queryById(findId, cache);
                break;
            case 2: //consulta por titulo
                System.out.println("Ingrese el titulo a consultar");
                String findTitle = scanner.next();
                this.queryByTitle(findTitle, cache);
                break;
        }
    }

    public void queryById(String findId, Cache cache) {
        WikiPage page;
        page = (WikiPage) cache.get(findId);
        if (page != null) {
            System.out.println("El resultado de su consulta es:");
            System.out.println(" -> id = " + page.getId());
            System.out.println(" -> titulo = " + page.getPage_title());
            System.out.println(" -> length = " + page.getPage_len() + "\n");
        } else { //si no encuentra la pagina en cache
            page = this.findIdByService(findId);
            cache.put(page.getId(), page);
        }
    }

    public void queryByTitle(String findTitle, Cache cache) {
        List<WikiPage> pages = (List<WikiPage>) cache.get(findTitle);
        if (pages != null) {
            Iterator<WikiPage> it = pages.iterator();
            System.out.println("Los resultado de su consulta son:");
            while (it.hasNext()) {
                WikiPage page1 = it.next();
                System.out.println(" -> id = " + page1.getId() + " / titulo = " + page1.getPage_title() + " / length = " + page1.getPage_len() + "\n");
            }
        } else {
            pages = this.findTitleByService(findTitle);
            if (pages.size() > 0) {
                cache.put(findTitle, pages);
            }
        }
    }

    public WikiPage findIdByService(String id) {
        WikiPage page = this.wikiService.findById(id);
        if (page != null) {
            System.out.println("El resultado de su consulta es:");
            System.out.println(" -> id = " + page.getId());
            System.out.println(" -> titulo = " + page.getPage_title());
            System.out.println(" -> length = " + page.getPage_len() + "\n");
        } else {
            System.out.println("El id no fue encontrado");
        }
        return page;
    }

    public List<WikiPage> findTitleByService(String title) {
        List<WikiPage> wikiPages = this.wikiService.findByTitle(title);
        if (wikiPages.size() > 0) {
            Iterator<WikiPage> iterator = wikiPages.iterator();
            System.out.println("Los resultado de su consulta son:");
            while (iterator.hasNext()) {
                WikiPage page1 = iterator.next();
                System.out.println(" -> id = " + page1.getId() + " / titulo = " + page1.getPage_title() + " / length = " + page1.getPage_len() + "\n");
            }
        } else {
            System.out.println("El titulo no fue encontrado");
        }
        return wikiPages;
    }
}

