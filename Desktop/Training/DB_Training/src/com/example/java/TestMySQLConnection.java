package com.example.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestMySQLConnection {

    static String username = "root";
    static String password = "42h981dq";
    static String dbUrl = "jdbc:mysql://localhost:3306/world";
    public static void main(String[] args) throws SQLException {

        Connection conn = null;
        try {
            conn = DriverManager.getConnection(dbUrl, username, password);
            System.out.println("Connection Established to MySQL Database");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        finally{
            conn.close();
        }

    }
}
