package com.xworkz.contact;

import java.sql.Connection;
import java.sql.DriverManager;

public class Tester {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/contact_management?useSSL=false&serverTimezone=UTC",
                    "root",
                    "Sonal@7715"
            );
            System.out.println("✅ Connected successfully!");
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

}
