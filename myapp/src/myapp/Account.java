/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author nakorn
 */
public class Account {
    public boolean createAccount(String input_email,String input_password,String input_firstname,String input_lastname) throws SQLException{
        int userid = (int)(Math.random()*(7000000-4000000+1)+4000000);
        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String formattedDate = dateFormat.format(currentDate);
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/myapp","root","");
        String sql = "INSERT INTO `userdata`(`UserID`,`Email`,`Password`,`Firstname`,`Lastname`,`DateTime`) VALUES ("+ userid +",'"+input_email+"','"+input_password+"','"+input_firstname+"','"+input_lastname+"','"+formattedDate+"');";
        Statement stmt = conn.createStatement();
        stmt.executeUpdate(sql);
        return true;
    }
    public boolean loginAccount(String input_email,String input_password) throws SQLException{
        System.out.println("");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/myapp","root","");
        String sql = "SELECT * FROM userdata";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()){
            if(rs.getString("Email").equals(input_email)){
                String real_password = rs.getString("Password");
                return real_password.equals(input_password);
            }
        }
        return false;
    }
}
