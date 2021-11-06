/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projectteaminthanin.DaoModel;

import com.mycompany.projectteaminthanin.database.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Customer;

/**
 *
 * @author Mesaya
 */
public class DaoCustomer implements DaoInterface<Customer> {

    @Override
    public int add(Customer customer) {
        Connection conn = null;
        Database db = Database.getInstance();
        conn = db.getConnection();
        int id = -1;
        try {
            String sql = "INSERT INTO Customer (Name,Phone, BirthDay )VALUES (?,?,?);";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, customer.getName());
            stmt.setString(2, customer.getPhone());
            stmt.setString(3, customer.getBirthDay());
            int row = stmt.executeUpdate();
            ResultSet result = stmt.getGeneratedKeys();
            if (result.next()) {
                id = result.getInt(1);
            }
        } catch (SQLException ex) {
            System.out.println("Database Error");
        }
        db.close();
        return id;
    }

    @Override
    public ArrayList<Customer> getAll() {
        ArrayList list = new ArrayList();
        Connection conn = null;
        Database db = Database.getInstance();
        conn = db.getConnection();
        try {
            String sql = "SELECT CustomerId, Name,Phone,BirthDay FROM Customer;";
            Statement stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery(sql);
            while (result.next()) {
                int id = result.getInt("CustomerId");
                String name = result.getString("Name");
                String phone = result.getString("Phone");
                String birthday = result.getString("BirthDay");
                Customer customer = new Customer(id, name, phone, birthday);
                list.add(customer);
            }
        } catch (SQLException ex) {
            System.out.println("Database Error");
        }
        db.close();
        return list;
    }

    @Override
    public Customer get(int id) {
        Connection conn = null;
        Database db = Database.getInstance();
        conn = db.getConnection();
        try {
            String sql = "SELECT CustomerId, Name,Phone,BirthDay FROM Customer WHERE CustomerId=" + id;
            Statement stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery(sql);
            while (result.next()) {
                int cusid = result.getInt("CustomerId");
                String name = result.getString("Name");
                String phone = result.getString("Phone");
                String birthday = result.getString("BirthDay");
                Customer customer = new Customer(cusid, name, phone, birthday);
                return customer;
            }
        } catch (SQLException ex) {
            System.out.println("Database Error");
        }
        return null;
    }

    @Override
    public int delete(int id) {
        Connection conn = null;
        Database db = Database.getInstance();
        conn = db.getConnection();
        int row = 0;
        try {
            String sql = "DELETE FROM Customer WHERE CustomerId = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            row = stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Database Error");

        }
        db.close();
        return row;
    }

    @Override
    public int update(Customer customer) {
        Connection conn = null;
        Database db = Database.getInstance();
        conn = db.getConnection();
        int row = 0;
        try {
            String sql = "UPDATE Customer SET  Name = ?,  Phone = ?, BirthDay = ? WHERE CustomerId = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, customer.getName());
            stmt.setString(2, customer.getPhone());
            stmt.setString(3, customer.getBirthDay());
            stmt.setInt(4, customer.getCustomerId());
            row = stmt.executeUpdate();
            System.out.println("Affect row " + row);
        } catch (SQLException ex) {
            System.out.println("Database Error");

        }

        db.close();
        return row;
    }

    public static void main(String[] args) {
        DaoCustomer dao = new DaoCustomer();
        System.out.println(dao.getAll());
//        dao.add(new Customer(999,"Unknown (Not Member)","",""));
//        int id = dao.add(new Customer(-1, "Mesaya Koedsorot", "0843540991", "20/04/2542"));
//        System.out.println("id " + id);
//        Customer last = dao.get(8);
//        System.out.println("Last Cos" + last);
//        last.setPhone("191");        
//        dao.update(last);
    }

}
