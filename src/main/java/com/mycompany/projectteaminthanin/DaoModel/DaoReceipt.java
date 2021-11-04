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
import java.util.ArrayList;
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
public class DaoReceipt implements DaoInterface<Receipt>{

    @Override
    public int add(Receipt object) {
              Connection conn = null;
        Database db = Database.getInstance();
        conn = db.getConnection();
        int id = -1;
        try {
            String sql = "INSERT INTO Receipt (emp_id,date,cus_id,total,cash,change)VALUES (?,?,?,?,?,?);";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, object.getEmp_id().getEmployeeId());
            stmt.setString(2, object.getDate());
            stmt.setInt(3, object.getCus_id().getCustomerId());
            stmt.setDouble(4, object.getAllTotal());
            stmt.setDouble(5, object.getCash());
            stmt.setDouble(6, object.getChange());

            int row = stmt.executeUpdate();

            ResultSet result = stmt.getGeneratedKeys();
             if (result.next()) {
                id = result.getInt(1);
                object.setRep_id(id);
            }
              for (ReceiptDetail r : object.getReceiptDetail()) {
                  String sqlDetail = "INSERT INTO Receiptdetail (rep_id,prod_id,amount,total) VALUES (?,?,?,?);";
                  PreparedStatement stmtDetail = conn.prepareStatement(sqlDetail);
                  stmtDetail.setInt(1, r.getRep_id().getRep_id());
                stmtDetail.setInt(2, r.getProd_id().getProductId());
                stmtDetail.setInt(3,r.getAmount());
                stmtDetail.setDouble(4, r.getPrice());
                int rowDetail = stmtDetail.executeUpdate();
                ResultSet resultDetail = stmt.getGeneratedKeys();
                if (resultDetail.next()) {
                    id = resultDetail.getInt(1);
                    r.setRepde_id(id);
                }
              }
            

    }   catch (SQLException ex) {
            System.out.println("Database Error");
        }
        db.close();
        return id;
    }


    @Override
    public ArrayList<Receipt> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Receipt get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int update(Receipt object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public static void main(String[] args) {
        Product p1 = new Product(50,"Greentea","Tea",30);
        Product p2 = new Product(51,"TeaGreen","Tae",34);
        Employee emp = new Employee(50,"Z","123","123","11-02-2020","NEE","MAle","Manager",150000);
        Customer cus = new Customer(50,"BOI","12342143","11-02-2020");
        Receipt receipt = new Receipt(emp,cus,"20-01-2000");
        receipt.addReceiptDetail(p1, 1);
        receipt.addReceiptDetail(p2, 1);
        System.out.println(receipt.getReceiptDetail().get(0).toString());
        System.out.println(receipt.getReceiptDetail().get(1).toString());
        System.out.println(receipt);
    }
}
