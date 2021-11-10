/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author ROG
 */
public class CheckInOut {
    private int checkID;
    private Employee employee;
    private String Type;
    private Date date;

    public CheckInOut(int checkID, Employee employee, String Type, Date date) {
        this.checkID = checkID;
        this.employee = employee;
        this.Type = Type;
        this.date = date;
    }

    public int getCheckID() {
        return checkID;
    }

    public void setCheckID(int checkID) {
        this.checkID = checkID;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "CheckInOut{" + "checkID=" + checkID + ", employee=" + employee + ", Type=" + Type + ", date=" + date + '}';
    }
    
    
}
