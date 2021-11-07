/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author ADMIN
 */
public class User {

    private int user_id;
    private Employee employee;
    private String username, password;

    public User(int user_id, Employee emp_id, String username, String password) {
        this.user_id = user_id;
        this.employee = emp_id;
        this.username = username;
        this.password = password;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(int emp_id) {
        employee.setEmployeeId(emp_id);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getEmpID() {
        return employee.getEmployeeId();
    }

    @Override
    public String toString() {
        return "User{" + "user_id=" + user_id + ", emp_id=" + employee + ", username=" + username + ", password=" + password + '}';
    }

}
