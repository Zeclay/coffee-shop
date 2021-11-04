/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author ROG
 */
public class ReceiptDetail {

    private int repde_id;
    private Receipt rep_id;
    private Product prod_id;
    private int amount;
    private double price;

    @Override
    public String toString() {
        return "ReceiptDetail{" + "repde_id=" + repde_id + ", rep_id=" + rep_id + ", prod_id=" + prod_id + ", amount=" + amount + ", total=" + this.getTotal() + "}";
    }

    public int getRepde_id() {
        return repde_id;
    }

    public void addAmount(int amount) {
        this.amount += amount;
    }
    public ReceiptDetail( Receipt receipt,Product product, int amount, double price) {
        this(-1,receipt,product,amount,price);
    }

    public void setRepde_id(int repde_id) {
        this.repde_id = repde_id;
    }

    public Receipt getRep_id() {
        return rep_id;
    }

    public void setRep_id(Receipt rep_id) {
        this.rep_id = rep_id;
    }

    public Product getProd_id() {
        return prod_id;
    }

    public void setProd_id(Product prod_id) {
        this.prod_id = prod_id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getTotal() {
        return amount*price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public ReceiptDetail(int repde_id, Receipt rep_id, Product prod_id, int amount, double total) {
        this.repde_id = repde_id;
        this.rep_id = rep_id;
        this.prod_id = prod_id;
        this.amount = amount;
        this.price = total;
    }

    public double getPrice() {
        return price;
    }
}
