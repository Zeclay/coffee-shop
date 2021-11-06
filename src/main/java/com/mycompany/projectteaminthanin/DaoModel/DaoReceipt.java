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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Customer;
import model.Employee;
import model.Product;
import model.Receipt;
import model.ReceiptDetail;

/**
 *
 * @author ROG
 */
public class DaoReceipt implements DaoInterface<Receipt> {

    @Override
    public int add(Receipt object) {
        Connection conn = null;
        Database db = Database.getInstance();
        conn = db.getConnection();
        int id = -1;
        try {
            String sql = "INSERT INTO Receipt (emp_id,cus_id,total,cash,change)VALUES (?,?,?,?,?);";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, object.getEmployee().getEmployeeId());
            stmt.setInt(2, object.getCustomer().getCustomerId());
            stmt.setDouble(3, object.getTotal());
            stmt.setDouble(4, object.getCash());
            stmt.setDouble(5, object.getChange());

            int row = stmt.executeUpdate();

            ResultSet result = stmt.getGeneratedKeys();
            if (result.next()) {
                id = result.getInt(1);
                object.setRep_id(id);
            }
            for (ReceiptDetail r : object.getReceiptDetail()) {
                String sqlDetail = "INSERT INTO Receiptdetail (rep_id,prod_id,amount,total) VALUES (?,?,?,?);";
                PreparedStatement stmtDetail = conn.prepareStatement(sqlDetail);
                stmtDetail.setInt(1, r.getReceipt().getRep_id());
                stmtDetail.setInt(2, r.getProduct().getProductId());
                stmtDetail.setInt(3, r.getAmount());
                stmtDetail.setDouble(4, r.getTotal());
                int rowDetail = stmtDetail.executeUpdate();
                ResultSet resultDetail = stmt.getGeneratedKeys();
                if (resultDetail.next()) {
                    id = resultDetail.getInt(1);
                    r.setRepde_id(id);
                }
            }

        } catch (SQLException ex) {
            System.out.println("Database Error");
        }
        db.close();
        return id;
    }

    @Override
    public ArrayList<Receipt> getAll() {
        ArrayList list = new ArrayList<>();
        Connection conn = null;
        Database db = Database.getInstance();
        conn = db.getConnection();
        try {

            String sql = "SELECT rep_id,date,emp_id,emp.Name as empName,cus_id,c.Name as cus_name ,r.total,r.cash,r.change FROM Receipt r ,Customer c, Employee emp WHERE r.cus_id = c.CustomerId AND r.emp_id = emp.EmployeeId ORDER BY date DESC;";
            Statement stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery(sql);
            while (result.next()) {
                int repid = result.getInt("rep_id");
                Date date = new SimpleDateFormat("dd-MM-yyyy").parse(result.getString("date"));//date can fix
                int emp_id = result.getInt("emp_id");
                String empName = result.getString("empName");
                int cusId = result.getInt("cus_id");
                String cusName = result.getString("cus_Name");
                double total = result.getDouble("total");
                double cash = result.getDouble("cash");
                double change = result.getDouble("change");

                Receipt receipt = new Receipt(repid, new Employee(emp_id, empName, "", "", "", "", "", "", 0.0), date, new Customer(cusId, cusName, "", ""), total, cash, change);
                list.add(receipt);

            }

        } catch (SQLException ex) {
            System.out.println("Error: Unable to select all receipt!!");
        } catch (ParseException ex) {
            Logger.getLogger(DaoReceipt.class.getName()).log(Level.SEVERE, null, ex);
        }
        db.close();
        return list;
    }

    @Override
    public Receipt get(int id) {
        ArrayList list = new ArrayList<>();
        Connection conn = null;
        Database db = Database.getInstance();
        conn = db.getConnection();
        try {

            String sql = "SELECT rep_id,date,emp_id,emp.Name as empName,cus_id,c.Name as cus_name ,total,cash,change FROM Receipt r ,Customer c, Employee emp WHERE r.cus_id = c.CustomerId AND r.emp_id = emp.EmployeeId AND rep_id = ? ORDER BY date DESC;";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);

            ResultSet result = stmt.executeQuery();

            if (result.next()) {

                int repid = result.getInt("rep_id");

                Date date = new SimpleDateFormat("dd-MM-yyyy").parse(result.getString("date"));//date can fix
                int emp_id = result.getInt("emp_id");
                String empName = result.getString("empName");
                int cusId = result.getInt("cus_id");
                String cusName = result.getString("cus_Name");
                double total = result.getDouble("total");
                double cash = result.getDouble("cash");
                double change = result.getDouble("change");

                Receipt receipt = new Receipt(id, new Employee(emp_id, empName, "", "", "", "", "", "", 0.0), date, new Customer(cusId, cusName, "", ""), total, cash, change);

                getReceiptDetail(conn, id, receipt);

                return receipt;
            }
        } catch (SQLException ex) {
            System.out.println("Error: Unable to select all receipt!!");
        } catch (ParseException ex) {
            Logger.getLogger(DaoReceipt.class.getName()).log(Level.SEVERE, null, ex);
        }
        db.close();
        return null;
    }

    private void getReceiptDetail(Connection conn, int id, Receipt receipt) throws SQLException {
        String sqlDetail = "SELECT repde_id,\n"
                + "       rep_id,\n"
                + "       prod_id,\n"
                + "       p.ProductName as pd_name,\n"
                + "       p.Price as pd_price,\n"
                + "       rd.total as price,\n"
                + "       amount,\n"
                + "       total\n"
                + "  FROM Receiptdetail rd, Product p\n"
                + "  WHERE rep_id = ? AND rd.prod_id = p.ProductId;";
        PreparedStatement stmtDetail = conn.prepareStatement(sqlDetail);
        stmtDetail.setInt(1, id);
        ResultSet resultDetail = stmtDetail.executeQuery();

        while (resultDetail.next()) {

            int receiveId = resultDetail.getInt("repde_id");
            int productId = resultDetail.getInt("prod_id");
            String productName = resultDetail.getString("pd_name");
            double productPrice = resultDetail.getDouble("pd_price");

            double price = resultDetail.getDouble("price");
            int amount = resultDetail.getInt("amount");

            Product product = new Product(productId, productName, "", productPrice);
            receipt.addReceiptDetail(receiveId, product, amount, price);

        }
    }

    @Override
    public int delete(int id) {
        Connection conn = null;
        Database db = Database.getInstance();
        conn = db.getConnection();
        int row = 0;
        try {
            String sql = "DELETE FROM receipt WHERE ID = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            row = stmt.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Error: Unable to delete receipt!!");
        }

        db.close();
        return row;
    }

    @Override
    public int update(Receipt object) {
        return 0;
    }

    public static void main(String[] args) {
//        Product p1 = new Product(1, "Greentea", "Tea", 30);;
//        Product p2 = new Product(3, "TeaGreen", "Tae", 34);
//        Employee emp = new Employee(50, "Z", "123", "123", "11-02-2020", "NEE", "MAle", "Manager", 150000);
//        Customer cus = new Customer(50, "BOI", "12342143", "11-02-2020");
//        Receipt receipt = new Receipt(emp, cus);
//        receipt.addReceiptDetail(p1, 1);
//        receipt.addReceiptDetail(p2, 3);
//        DaoReceipt dao = new DaoReceipt();
//        System.out.println("id = " + dao.add(receipt));
//        System.out.println("Receipt after add" + receipt);
        //      System.out.println("Get all" + dao.getAll());
////
// System.out.println(receipt);

//        DaoReceipt dao = new DaoReceipt();
//        System.out.println(dao.get(1));
//        System.out.println(receipt.getReceiptDetail().get(0).toString());
//        System.out.println(receipt.getReceiptDetail().get(1).toString());
    }
}
