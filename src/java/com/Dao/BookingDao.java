/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Dao;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.*;
import java.sql.*;
import com.model.Booking;
import com.util.DBConnection;
/**
 *
 * @author Cahaya Bulan
 */
public class BookingDao {
    
    public static Connection getConnection() {
        
        Connection con = null;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sportfaciitybookingsystem", "root", "admin");
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return con;
    }
    
    public static int save(Booking e) {
        
        int status = 0;
        
        try {
            
            Connection con = BookingDao.getConnection();
            PreparedStatement ps = con.prepareStatement (
                    "insert into booking(date, Time, courtname, categorysport,email) values (?, ?, ?, ?, ?)");
            ps.setString (1, e.getDate());
            ps.setString (2, e.getTime());
            ps.setString (4, e.getCourtname());
            ps.setString (3, e.getCategorysport());
            ps.setString (5, e.getEmail());
            
            status = ps.executeUpdate();
            
            con.close();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return status;
    }
    
    public static int update (Booking e) {
        
        int status = 0;
        
        try {
            
            Connection con = BookingDao.getConnection();
            PreparedStatement ps = con.prepareStatement (
                    "update users set username=?, password=?, roles=? where id=?");
            ps.setString (1, e.getDate());
            ps.setString (2, e.getTime());
            ps.setString (4, e.getCourtname());
            ps.setString (3, e.getCategorysport());
            ps.setString (5, e.getEmail());
            ps.setInt (6, e.getBookid());
            
            status = ps.executeUpdate();
            
            con.close();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        
        return status;
    }
    
    public static int delete (int bookid) {
        
        int status = 0;
        
        try {
            
            Connection con = BookingDao.getConnection();
            PreparedStatement ps = con.prepareStatement ("delete from booking where bookid=?");
            ps.setInt (1, bookid);
            status = ps.executeUpdate();
            
            con.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        
        return status;
    }
    
    //step 9
    public static Booking getBookingById (int bookid) {
        
        Booking e = new Booking();
        
        try {
            
            Connection con = BookingDao.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from booking where bookid=?");
            ps.setInt(1, bookid);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                
                e.setBookid(rs.getInt(1));
                e.setDate (rs.getString(2));
                e.setTime (rs.getString(3));
                e.setCourtname (rs.getString(4));
                e.setCategorysport (rs.getString(5));
                e.setEmail (rs.getString(6));
                
            }
            con.close();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return e;
    }
    
    public static List<Booking> getAllBooking() {
        
        List<Booking> list = new ArrayList<Booking>();
        
        try {
            
            Connection con = BookingDao.getConnection();
            PreparedStatement ps = con.prepareStatement ("select * from users");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Booking e = new Booking();
                e.setBookid(rs.getInt(1));
                e.setDate (rs.getString(2));
                e.setTime (rs.getString(3));
                e.setCourtname (rs.getString(4));
                e.setCategorysport (rs.getString(5));
                e.setEmail (rs.getString(6));
                list.add(e);
            }
            con.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        
        return list;
    }
}
