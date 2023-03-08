package com.example.demo.db;


import com.example.demo.db.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserController {
    public String GET_BY_ID_QUERY = "SELECT * FROM users WHERE users.id IS == ?";
    public String INSERT_QUERY = "INSERT INTO users (first_name, last_name, email,  password) VALUES (?, ?, ?, ?)";

    private final Connection conn;

    public UserController(Connection conn) {

        this.conn = conn;
    }



    public int saveUser(User user) throws SQLException {
        PreparedStatement s = conn.prepareStatement(INSERT_QUERY);
        s.setString(1, user.getFirstName());
        s.setString(2, user.getLastName());
        s.setString(3, user.getEmail());
        s.setString(4, user.getPassword());
        return s.executeUpdate();
    }
}
