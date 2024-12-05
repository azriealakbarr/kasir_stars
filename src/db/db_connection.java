package db;

import java.sql.*;

public class db_connection {
    private static db_connection instance;
    private Connection connection;
    private static String url = "jdbc:mysql://localhost:3306/kasirgrosir";
    private static String user = "root";
    private static String password = "";
    private static Connection conn = null;
    public static Connection connect(){
        if (conn == null ) {
            try {
                conn = DriverManager.getConnection(url,user,password);
                Class.forName("com.mysql.cj.jdbc.Driver");
                if (conn !=null) {
                    System.out.println("Koneksi berhasil");
                }
            } catch (Exception e) {
                System.out.println("Gagal menyambungkan database!" +e.getMessage());
                e.printStackTrace();
            }
        }
        return conn;
    }
    public static void main(String[] args) {
        connect();
    }
}
    
    