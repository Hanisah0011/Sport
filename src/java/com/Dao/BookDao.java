/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Dao;

import java.sql.*;
import java.util.*;

import com.model.*;
import com.util.*;

/**
 *
 * @author Cahaya Bulan
 */
public class BookDao {
    
    private Connection connection;
    
    public BookDao() throws ClassNotFoundException{
        
        connection = DBConnection.getConnection();
    }
    
    public int addBooking(Book book){
        int status = 0;
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("insert into booking(bookid, date,Time,courtname, categorysport,email) values (?, ?, ?, ?, ?, ?)");
            //Parameters start with 1
            preparedStatement.setInt(1, book.getBookid());
            preparedStatement.setString(2, book.getDate());
            preparedStatement.setString(3, book.getTime());
            preparedStatement.setString(5, book.getCourtname());
            preparedStatement.setString(4, book.getCategorysport());
            preparedStatement.setString(6, book.getEmail());
            preparedStatement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
        return status;
    }
    public void deleteBooking(String bookid){
        try{
            PreparedStatement preparedStatement = connection.
                    prepareStatement("delete from booking where bookid=?");
            //Parameter start with 1
            preparedStatement.setString(1, bookid);
            preparedStatement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    public void updateBooking(Book book){
        try{
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update booking set date=?, Time=?,courtname=?, categorysport=? , email=? where bookid=?");
            //Parameters start with 1
            preparedStatement.setString(1, book.getDate());
            preparedStatement.setString(2, book.getTime());
            preparedStatement.setString(4, book.getCourtname());
            preparedStatement.setString(3, book.getCategorysport());
            preparedStatement.setString(5, book.getEmail());
            preparedStatement.setInt(6, book.getBookid());
            preparedStatement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    public List<Book> getAllBooking(){
        List<Book> booking = new ArrayList<Book>();
        try{
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from booking");
            while (rs.next()){
                Book book = new Book();
                book.setBookid(rs.getInt("bookid"));
                book.setDate(rs.getString("date"));
                book.setTime(rs.getString("Time"));
                book.setCourtname(rs.getString("courtname"));
                book.setCategorysport(rs.getString("categorysport"));
                book.setEmail(rs.getString("email"));
                booking.add(book);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return booking;
    }
    public Book getBookingById(String bookid){
        Book book = new Book();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "select * from booking where bookid=?");
            preparedStatement.setString(1, bookid);
            ResultSet rs = preparedStatement.executeQuery();
            
            while (rs.next()){
                book.setBookid(rs.getInt("bookid"));
                book.setDate(rs.getString("date"));
                book.setTime(rs.getString("Time"));
                book.setCourtname(rs.getString("courtname"));
                book.setCategorysport(rs.getString("categorysport"));
                book.setEmail(rs.getString("email"));
                
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return book;
    }
    
}

   
