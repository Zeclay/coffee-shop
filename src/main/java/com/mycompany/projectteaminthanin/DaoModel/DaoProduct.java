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
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Product;

/**
 *
 * @author SUPAKIT KONGKAM
 */
public class DaoProduct implements DaoInterface<Product> {

    @Override
    public int add(Product product) {
        Connection conn = null;
        Database db = Database.getInstance();
        conn = db.getConnection();
        int id = -1;
        try {
            String sql = "INSERT INTO Product(ProductName,Type,Price)VALUES (?,?,?);";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, product.getProductName());
            stmt.setString(2, product.getType());
            stmt.setDouble(3, product.getPrice());
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
    public ArrayList<Product> getAll() {
        ArrayList list = new ArrayList();
        Connection conn = null;
        Database db = Database.getInstance();
        conn = db.getConnection();
        try {
            String sql = "SELECT ProductId,ProductName,Type,Price FROM Product;";
            Statement stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery(sql);
            while (result.next()) {
                int id = result.getInt("ProductId");
                String name = result.getString("ProductName");
                String type = result.getString("Type");
                double price = result.getDouble("Price");
                Product product = new Product(id, name, type, price);
                list.add(product);
            }
        } catch (SQLException ex) {
            System.out.println("Database Error");
        }
        db.close();
        return list;
    }

    @Override
    public Product get(int id) {
        Connection conn = null;
        Database db = Database.getInstance();
        conn = db.getConnection();
        try {
            String sql = "SELECT ProductId,ProductName,Type,Price FROM Product WHERE ProductId=" + id;
            Statement stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery(sql);
            while (result.next()) {
                int pid = result.getInt("ProductId");
                String name = result.getString("ProductName");
                String type = result.getString("Type");
                double price = result.getDouble("Price");
                Product product = new Product(pid, name, type, price);
                return product;
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
            String sql = "DELETE FROM Product WHERE ProductId = ?";
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
    public int update(Product product) {
        Connection conn = null;
        Database db = Database.getInstance();
        conn = db.getConnection();
        int row = 0;
        try {
            String sql = "UPDATE Product SET ProductName = ?,Type = ?,Price = ? WHERE ProductId = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, product.getProductName());
            stmt.setString(2, product.getType());
            stmt.setDouble(3, product.getPrice());
            stmt.setInt(4, product.getProductId());
            row = stmt.executeUpdate();
            System.out.println("Affect row " + row);
        } catch (SQLException ex) {
            System.out.println("Database Error");

        }

        db.close();
        return row;
    }

    public static void main(String[] args) {
        DaoProduct dao = new DaoProduct();
//        System.out.println(dao.getAll());
//        System.out.println(dao.get(50));
//        int id = dao.add(new Product(-1, "Olieng", "Coffee", 30.0));
//        System.out.println("id " + id);
        Product lastProduct = dao.get(29);
        System.out.println("Last Product" + lastProduct);
        lastProduct.setPrice(300);
        int row = dao.update(lastProduct);
        Product updateProduct = dao.get(29);
        System.out.println("Update Product" + updateProduct);
//        dao.delete(28);
//        Product deleteProduct = dao.get(28);
//        System.out.println("Delete product: " + deleteProduct);
    }

}
