/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Dao;

/**
 *
 * @author adylh
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.Payments;
import com.util.DBConnection;
        
public class PaymentDAO {
  
    private static final String INSERT_PAYMENTS_SQL = "INSERT INTO payments VALUES(?, ?, ?, ?)";
    private static final String SELECT_PAYMENTS_BY_ID = "select id,name,invoice, amount from payments where id =?";
    private static final String SELECT_ALL_PAYMENTS = "select * from payments";
    private static final String DELETE_PAYMENTS_SQL = "delete from payments where id = ?";
    private static final String UPDATE_PAYMENTS_SQL = "update payments set name = ?,invoice= ?, amount= ? where id = ?";
    
    public void insertPayment(Payments payment) throws SQLException {
        // try-with-resource statement will auto close the connection.
        try (Connection connection = DBConnection.init(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PAYMENTS_SQL)) {
            preparedStatement.setInt(1, payment.getId());
            preparedStatement.setString(2, payment.getName());
            preparedStatement.setString(3, payment.getInvoice());
            preparedStatement.setInt(4, payment.getAmount());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }
    
    public Payments selectPayment(int id) {
    	Payments payment = null;
        // Step 1: Establishing a Connection
        try (Connection connection = DBConnection.init();
            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PAYMENTS_BY_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                String name = rs.getString("name");
                String invoice = rs.getString("invoice");
                int amount = rs.getInt("amount");
                payment = new Payments(id, name,invoice, amount);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return payment;
    }
    
    public List < Payments > selectAllPayments() {

        // using try-with-resources to avoid closing resources (boiler plate code)
        List < Payments > payment = new ArrayList < > ();
        // Step 1: Establishing a Connection
        try (Connection connection = DBConnection.init();

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PAYMENTS);) {
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String invoice = rs.getString("invoice");
                int amount = rs.getInt("amount");
                payment.add(new Payments(id, name,invoice, amount));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return payment;
    }
    
    public boolean deletePayment(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = DBConnection.init(); PreparedStatement statement = connection.prepareStatement(DELETE_PAYMENTS_SQL);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }
    public boolean updatePayment(Payments payment) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = DBConnection.init(); PreparedStatement statement = connection.prepareStatement(UPDATE_PAYMENTS_SQL);) {
            
            statement.setString(1,payment.getName());
            statement.setString(2,payment.getInvoice());
            statement.setInt(3,payment.getAmount());
            statement.setInt(4, payment.getId());
            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }
    
    private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }


}

