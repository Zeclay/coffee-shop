/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author AuyouknoW
 */
public class Employee {

    private int EmployeeId;
    private String Name;
    private String PID;
    private String Phone;
    private String BirthDay;
    private String Address;
    private String Gender;
    private String Type;
    private double salary;

    public Employee(int EmployeeId, String Name, String PID, String Phone, String BirthDay, String Address, String Gender, String Type, double salary) {
        this.EmployeeId = EmployeeId;
        this.Name = Name;
        this.PID = PID;
        this.Phone = Phone;
        this.BirthDay = BirthDay;
        this.Address = Address;
        this.Gender = Gender;
        this.Type = Type;
        this.salary = salary;
    }

    public int getEmployeeId() {
        return EmployeeId;
    }

    public void setEmployeeId(int EmployeeId) {
        this.EmployeeId = EmployeeId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getPID() {
        return PID;
    }

    public void setPID(String PID) {
        this.PID = PID;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public String getBirthDay() {
        return BirthDay;
    }

    public void setBirthDay(String BirthDay) {
        this.BirthDay = BirthDay;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" + "EmployeeId=" + EmployeeId + ", Name=" + Name
                + ", PID=" + PID + ", Phone=" + Phone + ", BirthDay=" + BirthDay
                + ", Address=" + Address + ", Gender=" + Gender + ", Type=" + Type
                + ", salary=" + salary + '}';
    }

}
