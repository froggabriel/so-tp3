package cr.ac.ucr.ecci.ci1310.cache.core.dao;

import cr.ac.ucr.ecci.ci1310.cache.model.WikiPage;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by alexiaborchgrevink on 7/13/17.
 */
public class WikiDaoImpl implements WikiDao {

    private Statement statement;

    @Override
    public WikiPage findById(String id) {
        WikiPage page = new WikiPage();
        ResultSet resultSet;
        try {
            resultSet = statement.executeQuery("SELECT page_id, page_title, page_len FROM page WHERE id = " + id);
            if (resultSet.next()) {
                page.setId(resultSet.getString("id"));
                page.setPage_len(resultSet.getString("page_len"));
                page.setPage_title(resultSet.getString("page_title"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return page;
    }

    @Override
    public WikiPage findByTitle(String title) {
        WikiPage page = new WikiPage();
        ResultSet resultSet;
        try {
            resultSet = statement.executeQuery("SELECT page_id, page_title, page_len FROM page WHERE page_title = " + title);
            if (resultSet.next()) {
                page.setId(resultSet.getString("id"));
                page.setPage_len(resultSet.getString("page_len"));
                page.setPage_title(resultSet.getString("page_title"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return page;
    }
}
