package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class db_connection {
    // Konfigurasi database
    private static db_connection instance;
    private Connection connection;

    public static db_connection getInstance() {
        if (instance == null) {
            instance = new db_connection();
        }
        return instance;
    }
    
    private db_connection() {
        
    }
    public void connectDatabase() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/kasirgrosir";
        String user = "root";
        String pass = "";
        connection = java.sql.DriverManager.getConnection(url,user,pass);
    }
    public Connection getConnection() {
        return connection;
    }
    public void setConnection(Connection connection) {
        this.connection = connection;
    }
}
    