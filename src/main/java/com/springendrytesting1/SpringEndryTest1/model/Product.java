package com.springendrytesting1.SpringEndryTest1.model;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class Product {

    private Long id;

    private String productName;

    private String description;

    private double price;

    private int quantity;

    private byte[] photo;

    public Product(){

    }

    public Product(String productName, String description, double price, int quantity, byte[] photo) {
        this.productName = productName;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.photo = photo;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name="prod_name")
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Column(name="description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "price")
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Column(name = "QUANTITY")
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Lob
    @Column(name = "photo")
    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }
}
