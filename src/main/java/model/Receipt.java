/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author ROG
 */
public class Receipt {

    private int rep_id;
    private Employee emp_id;
    private String date;
    private Customer cus_id;
    private double total;
    private double cash;
    private double change;
    private ArrayList<ReceiptDetail> receiptDetail;

    public Receipt(int rep_id, Employee emp_id, String date, Customer cus_id, double total, double cash, double change) {
        this.rep_id = rep_id;
        this.emp_id = emp_id;
        this.date = date;
        this.cus_id = cus_id;
        this.total = total;
        this.cash = cash;
        this.change = change;
        receiptDetail = new ArrayList<>();
    }

    public Receipt(Employee seller, Customer customer, String date) {
        this(-1, seller, date, customer, 0, 0, 0);
    }

    public void addReceiptDetail(int id, Product product, int amount, double price) {
        for (int row = 0; row < receiptDetail.size(); row++) {
            ReceiptDetail r = receiptDetail.get(row);
            if (r.getProd_id().getProductId() == product.getProductId()) {
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

    public Employee getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(Employee emp_id) {
        this.emp_id = emp_id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Customer getCus_id() {
        return cus_id;
    }

    public void setCus_id(Customer cus_id) {
        this.cus_id = cus_id;
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
        String str = "Receipt{" + "rep_id=" + rep_id + ", emp_id=" + emp_id + ", date=" + date + ", cus_id=" + cus_id + ", total=" + this.getAllTotal() + ", cash=" + cash + ", change=" + change + "}\n";
        for (ReceiptDetail r : receiptDetail) {
            str += r.toString() + "\n";
        }
        //str+= this.getReceiptDetail().get(0);
        return str;
    }

}
