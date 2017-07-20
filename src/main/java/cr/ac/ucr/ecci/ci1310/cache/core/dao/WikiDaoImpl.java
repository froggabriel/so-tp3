package cr.ac.ucr.ecci.ci1310.cache.core.dao;

import cr.ac.ucr.ecci.ci1310.cache.model.WikiPage;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by alexiaborchgrevink on 7/13/17.
 */
public class WikiDaoImpl implements WikiDao {

    private Connection conn;
    private Statement statement;

    public WikiDaoImpl() {
        try {
            String url = "jdbc:mysql://localhost:3306/wiki";
            String user = "root";
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter password for root...");
            String password = scan.next();
            conn = DriverManager.getConnection(url, user, password);
            statement = conn.createStatement();
        }catch(SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public WikiPage findById(String id) {
        WikiPage page = new WikiPage();
        ResultSet resultSet;
        try {
            resultSet = statement.executeQuery("SELECT page_id, page_title, page_len FROM wiki.page WHERE page_id = " + id);
            if (resultSet.next()) {
                page.setId(resultSet.getString("page_id"));
                page.setPage_len(resultSet.getString("page_len"));
                page.setPage_title(resultSet.getString("page_title"));
            }
            else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return page;
    }

    @Override
    public List<WikiPage> findByTitle(String title) {
        List<WikiPage> results = new ArrayList<>();
        ResultSet resultSet;
        try {
            resultSet = statement.executeQuery("SELECT page_id, page_title, page_len FROM wiki.page WHERE page_title = \'" + title + "\'");
            if(resultSet == null) {
                return null;
            }
            while (resultSet.next()) {
                results.add(new WikiPage(resultSet.getString("page_id"),
                        resultSet.getString("page_len"),
                        resultSet.getString("page_title")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return results;
    }
}
