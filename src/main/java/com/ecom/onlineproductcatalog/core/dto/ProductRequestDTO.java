package com.ecom.onlineproductcatalog.core.dto;

public class ProductRequestDTO {
    private String brand;
    private String color;
    private String size;
    private String categoryId;
    private String inventoryId ;
    private Double price;
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(String inventoryId) {
        this.inventoryId = inventoryId;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ProductRequestDTO{" + "brand='" + brand + '\'' + ", color='" + color + '\'' + ", size='" + size + '\'' + ", categoryId='" + categoryId + '\'' + ", inventoryId='"
                + inventoryId + '\'' + ", price=" + price + '}';
    }
}
