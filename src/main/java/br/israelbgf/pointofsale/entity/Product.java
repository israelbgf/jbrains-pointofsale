package br.israelbgf.pointofsale.entity;

public class Product {
    public final String barcode;
    public final double price;

    public Product(String barcode, double price) {
        this.barcode = barcode;
        this.price = price;
    }
}
