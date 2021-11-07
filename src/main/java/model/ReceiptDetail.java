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
    private Receipt receipt;
    private Product product;
    private int amount;
    private double price;

    @Override
    public String toString() {
        return "ReceiptDetail{" + "repde_id=" + repde_id + ", prod_id=" + product + ", amount=" + amount + ", total=" + this.getTotal() + "}";
    }

    public int getRepde_id() {
        return repde_id;
    }

    public void addAmount(int amount) {
        this.amount += amount;
    }

    public ReceiptDetail(Receipt receipt, Product product, int amount, double price) {
        this(-1, receipt, product, amount, price);
    }

    public void setRepde_id(int repde_id) {
        this.repde_id = repde_id;
    }

    public Receipt getReceipt() {
        return receipt;
    }

    public void setRep_id(Receipt rep_id) {
        this.receipt = rep_id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProd_id(Product prod_id) {
        this.product = prod_id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getTotal() {
        return amount * product.getPrice();
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public ReceiptDetail(int repde_id, Receipt rep_id, Product prod_id, int amount, double total) {
        this.repde_id = repde_id;
        this.receipt = rep_id;
        this.product = prod_id;
        this.amount = amount;
        this.price = total;
    }

    public double getPrice() {
        return price;
    }
}
