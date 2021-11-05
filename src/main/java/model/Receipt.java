/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author ROG
 */
public class Receipt {

    private int rep_id;
    private Employee employee;
    private Date date;
    private Customer customer;
    private double total;
    private double cash;
    private double change;
    private ArrayList<ReceiptDetail> receiptDetail;

    public Receipt(int rep_id, Employee emp_id, Date date, Customer cus_id, double total, double cash, double change) {
        this.rep_id = rep_id;
        this.employee = emp_id;
        this.date = date;
        this.customer = cus_id;
        this.total = total;
        this.cash = cash;
        this.change = change;
        receiptDetail = new ArrayList<>();
    }

    public Receipt(Employee seller, Customer customer) {
        this(-1, seller, null, customer, 0, 0, 0);
    }

    public void addReceiptDetail(int id, Product product, int amount, double price) {
        for (int row = 0; row < receiptDetail.size(); row++) {
            ReceiptDetail r = receiptDetail.get(row);
            if (r.getProduct().getProductId() == product.getProductId()) {
                r.addAmount(amount);
                return;
            }

        }
        receiptDetail.add(new ReceiptDetail(id, this, product, amount, total));
    }

    public void addReceiptDetail(Product product, int amount) {
        addReceiptDetail(-1, product, amount, product.getPrice());
    }

    public ArrayList<ReceiptDetail> getReceiptDetail() {
        return receiptDetail;
    }

    public double getAllTotal() {
        double total = 0;
        for (ReceiptDetail r : receiptDetail) {
            total += r.getTotal();
        }
        return total;
    }

    public int getRep_id() {
        return rep_id;
    }

    public void setRep_id(int rep_id) {
        this.rep_id = rep_id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee emp_id) {
        this.employee = emp_id;
    }
    public void setEmpID(int id){
        employee.setEmployeeId(id);
    }
    public int getEmpID(){
        return employee.getEmployeeId();
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer cus_id) {
        this.customer = cus_id;
    }
    public int getCusID(){
        return customer.getCustomerId();
    }
    
    public void setCusID(int id){
        customer.setCustomerId(id);
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getCash() {
        return cash;
    }

    public void setCash(double cash) {
        this.cash = cash;
    }

    public double getChange() {
        return change;
    }

    public void setChange(double change) {
        this.change = change;
    }

    @Override
    public String toString() {
        for (ReceiptDetail r : receiptDetail) {
            total += r.getTotal();
        }
        String str = "Receipt{" + "rep_id=" + rep_id + ", emp_id=" + employee + ", date=" + date + ", cus_id=" + customer + ", total=" + this.getAllTotal() + ", cash=" + cash + ", change=" + change + "}\n";
        for (ReceiptDetail r : receiptDetail) {
            str += r.toString() + "\n";
        }
        //str+= this.getReceiptDetail().get(0);
        return str;
    }

}
