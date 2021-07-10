package com.proj01.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgresConnector {
    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    Connection getConnection(String username, String password, String url) throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }
}

