package dataBase.postgre;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Operation with Postrge DB
 * 
 * @author Neznaev_AI
 *
 */
public class DataBaseWork {

    private String dbUrl = "jdbc:postgresql://localhost:5432/";
    private String user = "postgres";
    private String password = "admin";
    private Connection conn;
    private Statement stat;
    
    /**
     * @param dbUrl - data base URL with table name
     * @param user - username
     * @param pass - password
     */
    public DataBaseWork (String dbUrl, String user, String pass) {
        this.dbUrl = dbUrl;
        this.user = user;
        this.password = pass;
        openConnection();
    }

    /**
     * @param dataBaseName - the name of the date base with which operations will be performed
     */
    public DataBaseWork (String dataBaseName) {
        dbUrl = dbUrl + dataBaseName;
        openConnection();
    }

    /**
     *  opens a connection to the database
     */
    private void openConnection() {
        try {
            conn = DriverManager.getConnection(dbUrl, user, password);
            stat = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param tableName
     * @param args
     * @return
     */
    public boolean insert(String tableName, String ...args) {
        List<String> columnNames = columnNames(tableName);
        String query = queryShaper(tableName, columnNames, args);
        
        try (ResultSet res = stat.executeQuery(query)){
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * @param tableName
     * @param columnNames
     * @param args
     * @return
     */
    private String queryShaper (String tableName, List<String> columnNames, String ...args) {
        StringBuilder into = new StringBuilder();
        StringBuilder value = new StringBuilder();
        
        into.append("INSERT INTO ");
        into.append(tableName);
        into.append("(");
        value.append(") values ('");
        
        for (int i = 0; i < columnNames.size(); i++) {
            into.append(columnNames.get(i));
            value.append(args[i]);
            
            if (i != columnNames.size() - 1) {
                into.append(", ");
                value.append("', '");
            }
        }
        into.append(value.toString());
        into.append("');");
        return into.toString();
    }
    
    

    /**
     * @param tableName - the name of the table with which operations will be performed
     * @return all columnNames for this table
     */
    public List<String> columnNames (String tableName) {
        List<String> columnNames = new ArrayList<>();
        String query = "SELECT column_name, column_default FROM information_schema.columns WHERE table_name = '" + tableName + "'";
        
        List<List<String>> columnWithDefault = executeCustomQuery(query);
        for (List<String> list : columnWithDefault) {
            if (list.get(1) == null || list.get(1).contains("nextval")) columnNames.add(list.get(0));
        }
        return columnNames;
    }
    
    /**
     * @param query - SQL query 
     * @return
     */
    public List<List<String>> executeCustomQuery(String query) {
        List<List<String>> answer = new ArrayList<>();
        
        try (ResultSet res = stat.executeQuery(query)){
            while (res.next()) {
                List<String> row = new ArrayList<>();
                int colAmount = res.getMetaData().getColumnCount();
                
                for (int i = 1; i <= colAmount; i++) {
                    row.add(res.getString(i));
                }
                answer.add(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return answer;
    }
    
    /**
     * @param list
     * @param tableName - the name of the table with which operations will be performed
     * @return
     */
    public boolean listToDataBase(List<String[]> list, String tableName) {
        for (String[] strings : list) {
            if (!insert(tableName, strings)) return false;
        }
        return true;
    }
    
    
    /**
     * @param tableName - the name of the table with which operations will be performed
     */
    public void eraseAll(String tableName) {
        //DELETE FROM games;
    }
    
    /**
     *  Closes the connection to the database
     */
    public void close () {
        try {
            if (stat != null) stat.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        DataBaseWork db = new DataBaseWork("Games");
        System.out.println(db.columnNames("games"));
        db.close();
    }
}
