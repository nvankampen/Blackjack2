package com.example.java;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class PreparedStatementInsert {

    public static void main (String[] args) throws SQLException {

        Connection conn = DBUtil.getConnection(DBType.ORADB);

        int empno;
        String ename,email;
        java.sql.Date hiredate;
        String jobId = "AD_PRES";
        double salary;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Employee ID :");
        empno = Integer.parseInt(scanner.nextLine());

        System.out.println("Enter Employee Name :");
        ename = scanner.nextLine();

        System.out.println("Enter Email : ");
        email = scanner.nextLine();

        System.out.println("Enter Date of Joining :");
        hiredate = java.sql.Date.valueOf(scanner.next());

        System.out.println("Enter Salary :");
        salary = scanner.nextDouble();

        String sql = "insert into Employees values (?,?,?,?,?,?,?,?,?,?,?)";

        PreparedStatement pstmt = conn.prepareStatement(sql);

        pstmt.setInt(1, empno);
        pstmt.setString(2, "");
        pstmt.setString(3,ename);
        pstmt.setString(4, email);
        pstmt.setString(5, "");
        pstmt.setDate(6, hiredate);
        pstmt.setString(7, jobId);
        pstmt.setDouble(8, salary);
        pstmt.setDouble(9, 0);
        pstmt.setDouble(10, 102);
        pstmt.setDouble(11, 20);


        int result = pstmt.executeUpdate();

        if (result == 1) {
            System.out.println("Record Inserted Successfully.");
        }
        else{
            System.out.println("Error while adding the record.");
        }

        scanner.close();
        pstmt.close();
        conn.close();
    }
}
