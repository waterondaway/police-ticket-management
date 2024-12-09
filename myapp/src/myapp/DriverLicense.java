/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author nakorn
 */
public class DriverLicense {
    public boolean createLicense(int input_license,String input_firstname,String input_lastname,String input_birthday,String input_address,String input_officer) throws SQLException{
        int userid = (int)(Math.random()*(7000000-4000000+1)+4000000);
        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String formattedDate = dateFormat.format(currentDate);
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/myapp","root","");
        String sql = "INSERT INTO `licensecard`(`LicenseID`,`Firstname`,`Lastname`,`Birthday`,`Address`,`Officer`,`DateTime`) VALUES ("+ userid +",'"+ input_firstname +"','"+ input_lastname+"','"+ input_birthday+"','"+ input_address+"','"+ input_officer +"','"+formattedDate+"');";
        Statement stmt = conn.createStatement();
        stmt.executeUpdate(sql);
        return true;
    }
}
