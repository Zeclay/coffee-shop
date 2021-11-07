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
import model.Product;
import model.Stock;

/**
 *
 * @author NITRO 5
 */
public class DaoStock implements DaoInterface<Stock> {

    @Override
    public int add(Stock stock) {
        Connection conn = null;
        Database db = Database.getInstance();
        conn = db.getConnection();
        int id = -1;
        try {
            String sql = "INSERT INTO Stock (stockprod_name,amount,price)VALUES (?,?,?);";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, stock.getStockprod_name());
            stmt.setInt(2, stock.getAmount());
            stmt.setDouble(3, stock.getPrice());
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
    public ArrayList<Stock> getAll() {
        ArrayList list = new ArrayList();
        Connection conn = null;
        Database db = Database.getInstance();
        conn = db.getConnection();
        try {
            String sql = "SELECT stock_id,stockprod_name,amount,price FROM Stock;";
            Statement stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery(sql);
            while (result.next()) {
                int stockid = result.getInt("stock_id");
                String stockname = result.getString("stockprod_name");
                int amount = result.getInt("amount");
                double price = result.getDouble("price");
                Stock stock = new Stock(stockid, stockname, amount, price);
                list.add(stock);
            }
        } catch (SQLException ex) {
            System.out.println("Database Error");
        }
        db.close();
        return list;
    }

    @Override
    public Stock get(int id) {
        Connection conn = null;
        Database db = Database.getInstance();
        conn = db.getConnection();
        try {
            String sql = "SELECT stock_id,stockprod_name,amount,price FROM Stock WHERE stock_id=" + id;
            Statement stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery(sql);
            while (result.next()) {
                int stockid = result.getInt("stock_id");
                String stockname = result.getString("stockprod_name");
                int amount = result.getInt("amount");
                double price = result.getDouble("price");
                Stock stock = new Stock(stockid, stockname, amount, price);
                return stock;
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
            String sql = "DELETE FROM Stock WHERE stock_id = ?";
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
    public int update(Stock stock) {
        Connection conn = null;
        Database db = Database.getInstance();
        conn = db.getConnection();
        int row = 0;
        try {
            String sql = "UPDATE Stock SET stockprod_name = ?,amount = ?,Price = ? WHERE stock_id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, stock.getStockprod_name());
            stmt.setInt(2, stock.getAmount());
            stmt.setDouble(3, stock.getPrice());
            stmt.setInt(4, stock.getStock_id());
            row = stmt.executeUpdate();
            System.out.println("Affect row " + row);
        } catch (SQLException ex) {
            System.out.println("Database Error");

        }

        db.close();
        return row;
    }

    public static void main(String[] args) {
        DaoStock dao = new DaoStock();
//        System.out.println(dao.getAll());
//System.out.println(dao.get(1));
//int id = dao.add(new Stock(-1,"Boyice",12,120.0));
//        System.out.println("id "+id);
//        dao.delete(13);
        Stock laststock = dao.get(1);
        System.out.println("Last Product" + laststock);
        laststock.setPrice(1300.0);
        int row = dao.update(laststock);
        Stock updateStock = dao.get(1);
        System.out.println("Update Product" + updateStock);

    }

}
