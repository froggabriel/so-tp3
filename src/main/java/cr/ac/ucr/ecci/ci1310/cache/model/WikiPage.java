package cr.ac.ucr.ecci.ci1310.cache.model;

/**
 * Created by alexiaborchgrevink on 7/19/17.
 */
public class WikiPage {

    private String page_title;
    private String id;
    private String page_len;

    public WikiPage() {

    }

    public WikiPage(String id, String page_len, String page_title) {
        this.page_title = page_title;
        this.id = id;
        this.page_len = page_len;
    }

    public String getPage_title() {
        return page_title;
    }

    public void setPage_title(String page_title) {
        this.page_title = page_title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPage_len() {
        return page_len;
    }

    public void setPage_len(String page_len) {
        this.page_len = page_len;
    }

    @Override
    public String toString() {
        return "Page ID: " + id + "\n"
            + "Page length: " + page_len + "\n"
            + "Page title: " + page_title + "\n";
    }
}
