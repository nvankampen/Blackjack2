package com.example.java;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateResultSetDemo {
    public static void main(String[] args) throws SQLException {

        try (
                Connection conn = DBUtil.getConnection((DBType.ORADB));
                Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                ResultSet rs = stmt.executeQuery("Select Department_Id, Department_Name, Manager_Id, Location_Id from Departments");
        ) {
            rs.absolute(6);
            rs.updateString("Department_Name", "Information Technology");
            rs.updateRow();
            System.out.println("Record Update Successfully");

            rs.moveToInsertRow();
            rs.updateInt("Department_Id", 991);
            rs.updateString("Department_Name", "Training");
            rs.updateInt("Manager_Id", 200);
            rs.updateInt("Location_Id", 1800);
            rs.insertRow();
            System.out.println("Record Inserted Successfully");

            String format = "%-4s%-20s%-25s%-10f\n";
            rs.beforeFirst();
            System.out.println("Details of Table");
            while (rs.next()) {
                System.out.format(format, rs.getString("Department_Id"), rs.getString("Department_Name"),
                        rs.getString("Manager_Id"), rs.getFloat("Location_Id"));

            }

        } catch (SQLException ex) {
            DBUtil.showErrorMessage(ex);

        }
    }
}
