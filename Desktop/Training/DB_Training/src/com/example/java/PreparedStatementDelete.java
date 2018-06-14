package com.example.java;

import java.sql.*;
import java.util.Scanner;

public class PreparedStatementDelete {

    public static void main (String[] args) throws SQLException {

        Connection conn = DBUtil.getConnection(DBType.ORADB);

        String sql = "Delete from Employees where Employee_Id = ?";

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Employee Id: ");
        int empno = scanner.nextInt();

        PreparedStatement pstmt = conn.prepareStatement(sql);

        pstmt.setInt(1, empno);

        int result = pstmt.executeUpdate();

        if (result ==1) {
            System.out.println("Employee Record Removed Successfully.");
            System.out.println("-------------------------");
        }
        else {
            System.out.println("Error while Removing Employee Record.");
        }

        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("Select * from Employees");

        String format = "%-13s%-20s%-25s%-10f\n";
        String headerFormat = "%-13s%-20s%-25s%-25s\n";
        System.out.format(headerFormat, "Employee ID", "First Name", "Last Name", "Salary");
        while (rs.next()) {
            System.out.format(format, rs.getString("Employee_Id"), rs.getString("First_Name"),
                    rs.getString("Last_Name"), rs.getFloat("Salary"));
        }

        scanner.close();
        pstmt.close();
        conn.close();
    }
}
