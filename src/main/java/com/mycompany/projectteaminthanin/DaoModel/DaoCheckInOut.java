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
import model.CheckInOut;
import model.Employee;

/**
 *
 * @author ROG
 */
public class DaoCheckInOut implements DaoInterface<CheckInOut> {

    @Override
    public int add(CheckInOut object) {
        Connection conn = null;
        Database db = Database.getInstance();
        conn = db.getConnection();
        int id = -1;

        try {
            String sql = "INSERT INTO CheckInOut (EMP_ID,Type)VALUES (?,?);";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, object.getEmployee().getEmployeeId());
            stmt.setString(2, object.getType());
            int row = stmt.executeUpdate();
            ResultSet result = stmt.getGeneratedKeys();
            if (result.next()) {
                id = result.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoCheckInOut.class.getName()).log(Level.SEVERE, null, ex);
        }
        db.close();
        return id;
    }

    @Override
    public ArrayList<CheckInOut> getAll() {
         ArrayList list = new ArrayList();
        Connection conn = null;
        Database db = Database.getInstance();
        conn = db.getConnection();
        
        
        try {
            String sql = "SELECT ID,EMP_ID,Type,datetime(Date, 'localtime') as ldate FROM CheckInOut ORDER BY date DESC;";
            Statement stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery(sql);
            while (result.next()) {
                int id = result.getInt("ID");
                int empId = result.getInt("EMP_ID");
                String Type = result.getString("Type");
                Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(result.getString("ldate"));
                CheckInOut cio = new CheckInOut(id,new Employee(empId,"","","","","","","",0.0),Type,date);
                list.add(cio);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoCheckInOut.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(DaoCheckInOut.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public void deleteAll(){
        Connection conn = null;
        Database db = Database.getInstance();
        conn = db.getConnection();
         int row = 0;
         
        try {
            String sql = "DELETE FROM CheckInOut;";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.executeUpdate();
            String sql2 = "UPDATE SQLITE_SEQUENCE SET SEQ=0 WHERE NAME=\"CheckInOut\"";
            PreparedStatement stmt2 = conn.prepareStatement(sql2);
            stmt2.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DaoCheckInOut.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public CheckInOut get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int update(CheckInOut object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
