package com.ecom.onlineproductcatalog.services.impl;

import com.ecom.onlineproductcatalog.core.Utilities;
import com.ecom.onlineproductcatalog.core.dto.CategoryResponseDTO;
import com.ecom.onlineproductcatalog.core.dto.ProductRequestDTO;
import com.ecom.onlineproductcatalog.core.dto.ProductResponseDTO;
import com.ecom.onlineproductcatalog.core.entity.Category;
import com.ecom.onlineproductcatalog.core.entity.Inventory;
import com.ecom.onlineproductcatalog.core.entity.Product;
import com.ecom.onlineproductcatalog.das.IProductCatalogDao;
import com.ecom.onlineproductcatalog.services.ICategoryService;
import com.ecom.onlineproductcatalog.services.IInventoryService;
import com.ecom.onlineproductcatalog.services.IProductCatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class ProductCatalogServiceImpl implements IProductCatalogService {
    private List<String> sizes = new ArrayList(){
        {
            add("S");
            add("M");
            add("L");
            add("XL");
            add("XXL");
        }
    };



    @Autowired
    private IProductCatalogDao catalogDao;
    @Autowired
    protected ICategoryService categoryService;
    @Autowired
    private IInventoryService inventoryService ;


    @Override
    public Product createProduct(ProductRequestDTO product) {
        return catalogDao.createProduct(enrichProduct(product));
    }

    private Product enrichProduct(ProductRequestDTO dto)
    {
        Product product = new Product();
        product.setBrand(dto.getBrand());
        Category category= categoryService.getCategory(Integer.parseInt(dto.getCategoryId()));
        product.setCategory(category);
        product.setColor(dto.getColor());
        product.setPrice(dto.getPrice());
        product.setSku(Utilities.getSku());
        product.setSize(dto.getSize());
        product.setCreated(new Date());
        product.setUpdated(new Date());
        return product;
    }

    public ProductResponseDTO enrichProductResponseDTO(Product product)
    {
        ProductResponseDTO dto = new ProductResponseDTO();
        if ( product != null) {
            dto.setSize(product.getSize());
            dto.setBrand(product.getBrand());
            dto.setColor(product.getColor());
            dto.setPrice(product.getPrice());
            CategoryResponseDTO categoryResponseDTO = new CategoryResponseDTO();
            categoryResponseDTO.setId(product.getCategory().getId());
            categoryResponseDTO.setName(product.getCategory().getCategoryName());
            dto.setCategory(categoryResponseDTO);
        }
        return dto;
    }
    private List<ProductResponseDTO> erichProductsToDTO(List<Product> products)
    {
        List<ProductResponseDTO> dtos = new ArrayList<>();
        if (products != null){
        for (Product product : products) {
            ProductResponseDTO dto = enrichProductResponseDTO(product);
            dtos.add(dto);
        }
    }
        return dtos;
    }
    @Override
    public ProductResponseDTO getProductBySku(String sku) {
        ProductResponseDTO responseDTO =  enrichProductResponseDTO(catalogDao.getProductBySku(sku));
        return responseDTO;
    }

    @Override
    public List<ProductResponseDTO> getAllProductsByBrand(String brand) {
        return erichProductsToDTO(catalogDao.getAllProductsByBrand(brand));
    }

    @Override
    public List<ProductResponseDTO> getAllProductsByPrice(Double min, Double max) {

        return erichProductsToDTO(catalogDao.getAllProductsByPrice(min, max));
    }

    @Override
    public List<ProductResponseDTO> getAllProductsByColor(String color) {

        return erichProductsToDTO(catalogDao.getAllProductsByColor(color));
    }

    @Override
    public List<ProductResponseDTO> getAllProductsBySize(String size) {
        return erichProductsToDTO(catalogDao.getAllProductsBySize(size));
    }

    @Override
    public boolean validateProductDto(Map<String,Object> error , ProductRequestDTO productRequestDTO) {
        boolean isValid = true ;
        String size = productRequestDTO.getSize();

        if (! sizes.contains(size))
        {
            Utilities.putResponseFieldMap(error, "Invalid size select from ", sizes.toString());
            isValid = false ;
        }
        String categoryId = productRequestDTO.getCategoryId();
        try{
            Integer cid = Integer.parseInt(categoryId);
            Category category = categoryService.getCategory(cid);
            if (category == null)
            {
                Utilities.putResponseFieldMap(error, "Invalid category Id  or Category not exist", categoryId);
                isValid = false ;
            }
        }
        catch (NumberFormatException e)
        {
            Utilities.putResponseFieldMap(error, "Invalid category Id ", categoryId);
            isValid = false ;
        }
        String inId = productRequestDTO.getInventoryId();
        try{
            Integer iid = Integer.parseInt(categoryId);
            Inventory inventory = inventoryService.getInventory(iid);
            if (inventory == null)
            {
                Utilities.putResponseFieldMap(error, "Invalid inventory or exist ", inId);
                isValid = false ;
            }
        }
        catch (NumberFormatException e)
        {
            Utilities.putResponseFieldMap(error, "Invalid inventory Id ", categoryId);
            isValid = false ;
        }
        return isValid;
    }
}
