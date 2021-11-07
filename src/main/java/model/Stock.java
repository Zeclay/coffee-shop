/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author NITRO 5
 */
public class Stock {

    int stock_id;
    String stockprod_name;
    int amount;
    double price;

    @Override
    public String toString() {
        return "Stock{" + "stock_id=" + stock_id + ", stockprod_name=" + stockprod_name + ", amount=" + amount + ", price=" + price + '}';
    }

    public int getStock_id() {
        return stock_id;
    }

    public void setStock_id(int stock_id) {
        this.stock_id = stock_id;
    }

    public String getStockprod_name() {
        return stockprod_name;
    }

    public void setStockprod_name(String stockprod_name) {
        this.stockprod_name = stockprod_name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Stock(int stock_id, String stockprod_name, int amount, double price) {
        this.stock_id = stock_id;
        this.stockprod_name = stockprod_name;
        this.amount = amount;
        this.price = price;
    }

}
