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

/**
 *
 * @author AuyouknoW
 */
public class DaoEmployee implements DaoInterface<Employee> {

    @Override
    public int add(Employee emp) {
        Connection conn = null;
        Database db = Database.getInstance();
        conn = db.getConnection();
        int id = -1;
        try {
            String sql = "INSERT INTO Employee (Name,PID,Phone,BirthDay,Address,Gender,Type,Salary) VALUES (?,?,?,?,?,?,?,?);";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, emp.getName());
            stmt.setString(2, emp.getPID());
            stmt.setString(3, emp.getPhone());
            stmt.setString(4, emp.getBirthDay());
            stmt.setString(5, emp.getAddress());
            stmt.setString(6, emp.getGender());
            stmt.setString(7, emp.getType());
            stmt.setDouble(8, emp.getSalary());
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
    public ArrayList getAll() {
        ArrayList list = new ArrayList();
        Connection conn = null;
        Database db = Database.getInstance();
        conn = db.getConnection();
        try {
            String sql = "SELECT EmployeeId,Name,PID,Phone,BirthDay,Address,Gender,Type,Salary FROM Employee;";
            Statement stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery(sql);
            while (result.next()) {
                int id = result.getInt("EmployeeId");
                String name = result.getString("Name");
                String pid = result.getString("PID");
                String phone = result.getString("Phone");
                String birthDay = result.getString("Birthday");
                String address = result.getString("Address");
                String gender = result.getString("Gender");
                String type = result.getString("Type");
                double salaly = result.getDouble("Salary");
                Employee emp = new Employee(id, name, pid, phone, birthDay, address, gender, type, salaly);
                list.add(emp);
            }
        } catch (SQLException ex) {
            System.out.println("Database Error");
        }
        db.close();
        return list;

    }

    @Override
    public Employee get(int id) {
        Connection conn = null;
        Database db = Database.getInstance();
        conn = db.getConnection();
        try {
            String sql = "SELECT EmployeeId,Name,PID,Phone,BirthDay,Address,Gender,Type,Salary FROM Employee WHERE EmployeeId =" + id;
            Statement stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery(sql);
            while (result.next()) {
                int eid = result.getInt("EmployeeId");
                String name = result.getString("Name");
                String pid = result.getString("PID");
                String phone = result.getString("Phone");
                String birthDay = result.getString("Birthday");
                String address = result.getString("Address");
                String gender = result.getString("Gender");
                String type = result.getString("Type");
                double salaly = result.getDouble("Salary");
                Employee emp = new Employee(eid, name, pid, phone, birthDay, address, gender, type, salaly);
                return emp;
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
            String sql = "DELETE FROM Employee WHERE EmployeeId = ?";
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
    public int update(Employee emp) {
        Connection conn = null;
        Database db = Database.getInstance();
        conn = db.getConnection();
        int row = 0;
        try {
            String sql = "UPDATE Employee SET Name = ?,PID = ?,Phone = ?,BirthDay = ?,Address = ?,Gender = ?,Type = ?,Salary = ? WHERE EmployeeId = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, emp.getName());
            stmt.setString(2, emp.getPID());
            stmt.setString(3, emp.getPhone());
            stmt.setString(4, emp.getBirthDay());
            stmt.setString(5, emp.getAddress());
            stmt.setString(6, emp.getGender());
            stmt.setString(7, emp.getType());
            stmt.setDouble(8, emp.getSalary());
            stmt.setInt(9, emp.getEmployeeId());
            row = stmt.executeUpdate();
            System.out.println("Affect row " + row);
        } catch (SQLException ex) {
            System.out.println("Database Error");

        }

        db.close();
        return row;
    }

    public static void main(String[] args) {
        DaoEmployee dao = new DaoEmployee();
//        System.out.println(dao.getAll());
//        System.out.println(dao.get(1));
        int id = dao.add(new Employee(-1, "Man sudsoy", "1754433221123", "0992222111","08/12/1999","Bangkok","Male","Employee",10000));
        System.out.println("id " + id);
//        Employee last = dao.get(8);
//        System.out.println("Last Employee" + last);
//        last.setSalary(30000);
//        int row = dao.update(last);
//        System.out.println("Last Employee" + last);
//        Employee upEmployee = dao.get(8);
//        System.out.println("Update Employee" + upEmployee);
//        dao.delete(8);
//        Employee deleteEmployee = dao.get(8);
//        System.out.println("Delete Employee: " + deleteEmployee);
    }

}
