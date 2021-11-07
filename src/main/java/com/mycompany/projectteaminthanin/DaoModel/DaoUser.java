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
import model.Employee;
import model.Product;
import model.User;

/**
 *
 * @author ADMIN
 */
public class DaoUser implements DaoInterface<User> {

    @Override
    public int add(User user) {
        Connection conn = null;
        Database db = Database.getInstance();
        conn = db.getConnection();
        int id = -1;
        try {
            String sql = "INSERT INTO User (emp_id,username,password)VALUES (?,?,?);";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, user.getEmployee().getEmployeeId());
            stmt.setString(2, user.getUsername());
            stmt.setString(3, user.getPassword());
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
    public ArrayList<User> getAll() {
        ArrayList list = new ArrayList();
        Connection conn = null;
        Database db = Database.getInstance();
        conn = db.getConnection();
        try {
            String sql = "SELECT user_id,emp_id,emp.EmployeeId as employee_id,emp.Name as emp_name,username,password FROM User u , Employee emp where emp_id = employee_id;";
            Statement stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery(sql);
            while (result.next()) {
                int id = result.getInt("user_id");
                int empId = result.getInt("employee_id");
                String emp_Name = result.getString("emp_name");
                String username = result.getString("username");
                String password = result.getString("password");
                User user = new User(id, new Employee(empId, emp_Name, "", "", null, "", "", "", 0.0), username, password);
                list.add(user);
            }
        } catch (SQLException ex) {
            System.out.println("Database Error");
        }
        db.close();
        return list;
    }

    @Override
    public User get(int id) {
        ArrayList list = new ArrayList();
        Connection conn = null;
        Database db = Database.getInstance();
        conn = db.getConnection();
        try {
            String sql = "SELECT user_id,emp_id,emp.Name as emp_name,username,password FROM User,Employee emp WHERE  user_id = " + id;
            Statement stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery(sql);
            while (result.next()) {
                int uid = result.getInt("user_id");
                int empId = result.getInt("emp_id");
                String emp_Name = result.getString("emp_name");
                String username = result.getString("username");
                String password = result.getString("password");
                User user = new User(uid, new Employee(empId, emp_Name, "", "", null, "", "", "", 0.0), username, password);
                return user;
            }
        } catch (SQLException ex) {
            System.out.println("Database Error");
        }
        db.close();
        return null;
    }

    @Override
    public int delete(int id) {
        Connection conn = null;
        Database db = Database.getInstance();
        conn = db.getConnection();
        int row = 0;
        try {
            String sql = "DELETE FROM User WHERE user_id = ?";
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
    public int update(User user) {
        Connection conn = null;
        Database db = Database.getInstance();
        conn = db.getConnection();
        int row = 0;
        try {
            String sql = "UPDATE User SET username = ?,password = ? where user_id = ? ";
            PreparedStatement stmt = conn.prepareStatement(sql);
//            stmt.setInt(1, user.getEmployee().getEmployeeId());
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());
            stmt.setInt(3, user.getUser_id());
            row = stmt.executeUpdate();
            System.out.println("Affect row " + row);
        } catch (SQLException ex) {
            System.out.println("Database Error");

        }

        db.close();
        return row;
    }

    public static void main(String[] args) {
        DaoUser dao = new DaoUser();
//        User last = dao.get(5);
//        last.setPassword("password");
//        dao.update(last);
        System.out.println(dao.getAll());

    }

}
