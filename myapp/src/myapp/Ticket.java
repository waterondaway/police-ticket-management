/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author nakorn
 */
public class Ticket {
    public boolean giveTicket(int input_licenseid, String input_violation, String input_location, String input_officer,int input_penaltycost) throws SQLException{
        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String formattedDate = dateFormat.format(currentDate);
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/myapp","root","");
        String sql = "INSERT INTO `ticket`(`LicenseID`,`Violation`,`PenaltyCost`,`Location`,`Officer`,`DateTime`) VALUES ("+ input_licenseid +",'"+input_violation+"',"+input_penaltycost+",'"+input_location+"','"+input_officer+"','"+formattedDate+"');";
        Statement stmt = conn.createStatement();
        stmt.executeUpdate(sql);
        return true;
    }
    public boolean payTicket(int LicenseID,int penaltycost) throws SQLException{
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/myapp","root","");
        String sql = "SELECT PenaltyCost FROM ticket WHERE LicenseID = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, LicenseID); // กำหนดค่าของ LicenseID
        ResultSet rs = pstmt.executeQuery();
        rs.next();
        int sum_amount = rs.getInt("PenaltyCost");
        if(penaltycost>=sum_amount){
            sql = "DELETE FROM `ticket` WHERE `LicenseID` = "+LicenseID;
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            return true;
        }else{
            return false;
        }
    }
}
