package com.blogConnect;
import java.sql.Connection;
import java.sql.DriverManager;

public class TestConnection {
    public static void main(String[] args) {
         try {
                Class.forName("com.mysql.jdbc.Driver");
                System.out.println("Loaded driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/blogConnectDB","root","root");
                System.out.println("Connected to MySQL");
                con.close();
         } 
         catch (Exception ex) {
                ex.printStackTrace();
         }
    }
}