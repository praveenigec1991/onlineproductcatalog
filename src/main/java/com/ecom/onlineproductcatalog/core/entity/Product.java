package com.ecom.onlineproductcatalog.core.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "product")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Product extends BaseEntity{
    private String brand;
    private String color;
    private String size;
    private Category category;
    private Double price ;
    private String sku ;
   // private Inventory inventory;

    @Column(name = "brand")
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Column(name = "color")
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Column(name = "size",length = 4)
    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    //@Column(name = "category")
    @OneToOne
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Column(name = "price",nullable = false)
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Column(name = "sku",nullable = false,unique = true)
    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }


/*
   // public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }*/

    @Override
    public String toString() {
        return "Product{" + "brand='" + brand + '\'' + ", color=" + color + ", size=" + size + ", category=" + category + ", price=" + price + ", sku='" + sku + '\'' + '}';
    }
}
