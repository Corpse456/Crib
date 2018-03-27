package dataBase.postgre;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ValuesToDB {

    private String dbUrl = "jdbc:postgresql://localhost:5432/Games";
    private String user = "postgres";
    private String password = "admin";
    
    public void add(String ...args) {
        String tableName = "games";
        List<String> columnNames = new ArrayList<>();
        
        try {
            Connection conn = DriverManager.getConnection(dbUrl, user, password);
            Statement statement = conn.createStatement();
            ResultSet exec = statement.executeQuery("SELECT column_name FROM information_schema.columns WHERE table_name = '" + tableName + "'");
            while (true) {
                exec.next();
                columnNames.add(exec.getString(1));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        System.out.println(args.length);
    }
    
    public static void main(String[] args) {
        new ValuesToDB().add("", "l", "");
    }
}
