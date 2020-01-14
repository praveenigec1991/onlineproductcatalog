package com.ecom.onlineproductcatalog.services;

import com.ecom.onlineproductcatalog.core.dto.ProductRequestDTO;
import com.ecom.onlineproductcatalog.core.dto.ProductResponseDTO;
import com.ecom.onlineproductcatalog.core.entity.Product;

import java.util.List;
import java.util.Map;

public interface IProductCatalogService {
    Product createProduct(ProductRequestDTO product);
    ProductResponseDTO getProductBySku(String sku);
    List<ProductResponseDTO> getAllProductsByBrand(String brand);
    List<ProductResponseDTO> getAllProductsByPrice(Double min,Double max);
    List<ProductResponseDTO> getAllProductsByColor(String color);
    List<ProductResponseDTO> getAllProductsBySize(String size);
    boolean validateProductDto(Map<String,Object> error , ProductRequestDTO productRequestDTO);
    ProductResponseDTO enrichProductResponseDTO(Product product);
}
