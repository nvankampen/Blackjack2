package com.example.java;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class randomCrap {
    public static void main(String[] args) throws SQLException {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs= null;

        try {
            conn = DBUtil.getConnection(DBType.ORADB);
            stmt = conn.createStatement();
            rs = stmt.executeQuery("Select * from Employees");

            String format = "%-4s%-20s%-25s%-10f\n";
            while (rs.next()) {
                System.out.format(format, rs.getString("Employee_Id"), rs.getString("First_Name"),
                        rs.getString("Last_Name"), rs.getFloat("Manager_Id"));
            }
        } catch (SQLException e) {
            DBUtil.showErrorMessage(e);
        } finally {
            rs.close();
            stmt.close();
            conn.close();
        }

    }
}
