/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prithu.sim.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author lion
 */
public class TestDatabase {

    public static void main(String[] args) {
        try {
            //Registering the Driver
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            //Getting the connection
            String mysqlUrl = "jdbc:mysql://localhost:3306/StudentInfoManagement";
            Connection con = DriverManager.getConnection(mysqlUrl, "Lion", "P@ssword1");
            System.out.println("Connection established......");
            //Creating the Statement
            Statement stmt = con.createStatement();

            //Executing the statement
//            String createTable = "select count(*) from user_info";
//            java.sql.ResultSet bool = stmt.executeQuery(createTable);
            String tableSql = "CREATE TABLE IF NOT EXISTS employees"
                    + "(emp_id int PRIMARY KEY AUTO_INCREMENT, name varchar(30),"
                    + "position varchar(30), salary double)";
            stmt.execute(tableSql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
