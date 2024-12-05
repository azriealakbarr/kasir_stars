package service;

import db.db_connection;
import java.sql.*;
import model.ModelLogin_Register;
import model.ModelLogin_Login;

public class ServiceLogin_User {
    private final Connection cnct;
    
    public ServiceLogin_User() {
        cnct = db_connection.connect();
    }
    public ModelLogin_Register login_User(ModelLogin_Login login) throws SQLException {
    ModelLogin_Register data = null;

    try (PreparedStatement p = cnct.prepareStatement("SELECT user_id, username, password FROM users WHERE BINARY(username) = ? AND BINARY(password) = ? LIMIT 1", Statement.RETURN_GENERATED_KEYS)) {
        p.setString(1, login.getUsername());
        p.setString(2, login.getPassword());

        try (ResultSet rs = p.executeQuery()) {
            if (rs.next()) {
                int user_id = rs.getInt(1);
                String username = rs.getString(2);
                String password = rs.getString(3);
                data = new ModelLogin_Register(user_id, username, password);
            }
        }
    } catch (SQLException e) {
        // Handle the exception appropriately, e.g., log the error or throw a custom exception
        e.printStackTrace();
        throw new SQLException("Error during login: " + e.getMessage());
    }

    return data;
    }

    public void insertUser(ModelLogin_Register username) throws SQLException {
        PreparedStatement p = cnct.prepareStatement("INSERT INTO users (username, email, password) VALUES (?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
        p.setString(1, username.getUsername());
        p.setString(2, username.getEmail());
        p.setString(3, username.getPassword());
        p.execute();
        
        ResultSet r = p.getGeneratedKeys();
        if (r.next()) {
            int user_id = r.getInt(1);
            username.setUser_id(user_id);
        }
        
        r.close();
        p.close();
    }
    
    public boolean checkDuplicateUser(String username) throws SQLException {
        boolean duplicate = false;
        PreparedStatement p = cnct.prepareStatement("SELECT user_id FROM users WHERE username = ? LIMIT 1",  Statement.RETURN_GENERATED_KEYS);
        p.setString(1, username);
        ResultSet r = p.executeQuery();
        if (r.next()) {
            duplicate = true;
        }
        r.close();
        p.close();
        return duplicate;
    }
    
    public boolean checkDuplicateEmail(String email) throws SQLException {
        boolean duplicate = false;
        PreparedStatement p = cnct.prepareStatement("SELECT user_id FROM users WHERE email = ? LIMIT 1");
        p.setString(1, email);
        ResultSet r = p.executeQuery();
        if (r.next()) {
            duplicate = true;
        }
        r.close();
        p.close();
        return duplicate;
    }
}
