/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Mesaya
 */
public class Customer {

    private int CustomerId;
    private String Name;
    private String Phone;
    private String BirthDay;

    public Customer(int CustomerId, String Name, String Phone, String BirthDay) {
        this.CustomerId = CustomerId;
        this.Name = Name;
        this.Phone = Phone;
        this.BirthDay = BirthDay;
    }

    public Customer(String Name, String Phone, String BirthDay) {
        this(-1, Name, Phone, BirthDay);
    }

    public int getCustomerId() {
        return CustomerId;
    }

    public void setCustomerId(int CustomerId) {
        this.CustomerId = CustomerId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
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

    @Override
    public String toString() {
        return "Customer{" + "CustomerId=" + CustomerId + ", Name=" + Name + ", Phone=" + Phone + ", BirthDay=" + BirthDay + '}';
    }
}
