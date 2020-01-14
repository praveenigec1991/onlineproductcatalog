package com.ecom.onlineproductcatalog.das;

import com.ecom.onlineproductcatalog.core.entity.Product;

import java.util.List;

public interface IProductCatalogDao {
    Product createProduct(Product product);
    Product getProductBySku(String sku);
    List<Product> getAllProductsByBrand(String brand);
    List<Product> getAllProductsByPrice(Double min, Double max);
    List<Product> getAllProductsByColor(String color);
    List<Product> getAllProductsBySize(String color);

}
