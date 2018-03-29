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
public class ValuesToDB {

    private String dbUrl = "jdbc:postgresql://localhost:5432/";
    private String user = "postgres";
    private String password = "admin";
    private Connection conn;
    
    /**
     * @param dbUrl - data base URL with table name
     * @param user - username
     * @param pass - password
     */
    public ValuesToDB (String dbUrl, String user, String pass) {
        this.dbUrl = dbUrl;
        this.user = user;
        this.password = pass;
    }

    /**
     * @param dataBaseName - the name of the date base with which operations will be performed
     */
    public ValuesToDB (String dataBaseName) {
        dbUrl = dbUrl + dataBaseName;
    }

    /**
     * @param args 
     */
    public void add(String tableName, String ...args) {
        List<String> columnNames = columnNames(tableName);
        String query = queryCollecor(tableName, columnNames, args);
        System.out.println(query);
    }

    /**
     * @param tableName
     * @param columnNames
     * @param args
     * @return
     */
    private String queryCollecor (String tableName, List<String> columnNames, String ...args) {
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
        
        try {
            conn = DriverManager.getConnection(dbUrl, user, password);
            Statement statement = conn.createStatement();
            ResultSet exec = statement.executeQuery("SELECT column_name, column_default FROM information_schema.columns WHERE table_name = '" + tableName + "'");
            while (!exec.isLast()) {
                exec.next();
                String name = exec.getString(1);
                String def = exec.getString(2);
                if (def == null || !def.contains("nextval")) columnNames.add(name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return columnNames;
    }
    
    /**
     *  Closes the connection to the database
     */
    public void close () {
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        new ValuesToDB("Games").add("games", "1", "2", "2018-Jan-05", "4", "5", "6", "7");
    }
}
