package com.example.java;

import java.sql.*;
import java.util.Scanner;

public class PreparedStatementUpdate {

    public static void main (String[] args) throws SQLException {

        Connection conn = DBUtil.getConnection(DBType.ORADB);

        String sql = "Update Employees set Salary = ? where Employee_Id = ?";

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Employee Id: ");
        int empno = scanner.nextInt();

        System.out.println("Enter New Salary: ");
        double salary = scanner.nextDouble();

        PreparedStatement pstmt = conn.prepareStatement(sql);

        pstmt.setDouble(1, salary);
        pstmt.setInt(2, empno);

        int result = pstmt.executeUpdate();

        if (result ==1) {
            System.out.println("Employee Salary Updated Successfully.");
            System.out.println("-------------------------");
        }
        else{
            System.out.println("Error while updating the Salary.");
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
