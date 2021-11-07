/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projectteaminthanin.database;
// Singleton pattern

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author werapan
 */
public class Database {

    private static Database instance = new Database();
    private Connection conn;

    private Database() {
    }

    public static Database getInstance() {

        String dbPath = "./db/store.db";
        try {
            if (instance.conn == null || instance.conn.isClosed()) {
                Class.forName("org.sqlite.JDBC");
                instance.conn = DriverManager.getConnection("jdbc:sqlite:" + dbPath);
                System.out.println("Database connection");
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("Error: JDBC is not exist");
        } catch (SQLException ex) {
            System.out.println("Error: Database cannot connection");
        }

        return instance;
    }

    public static void close() {
        try {
            if (instance.conn != null && !instance.conn.isClosed()) {
                instance.conn.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        instance.conn = null;
    }

    public Connection getConnection() {
        return instance.conn;
    }
}
