package com.ecom.onlineproductcatalog.controller;

import com.ecom.onlineproductcatalog.core.Utilities;
import com.ecom.onlineproductcatalog.core.dto.ProductRequestDTO;
import com.ecom.onlineproductcatalog.core.dto.ProductResponseDTO;
import com.ecom.onlineproductcatalog.core.dto.ResponseDTO;
import com.ecom.onlineproductcatalog.core.entity.Product;
import com.ecom.onlineproductcatalog.services.IProductCatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/product")
public class ProductCatalogController {

    @Autowired
    private IProductCatalogService catalogService ;

    @RequestMapping(value = "/getProductBySku/{sku}")
    public ResponseDTO getProductBySku(@PathVariable String sku) {
        ResponseDTO dto = new ResponseDTO();
        ProductResponseDTO responseDTO = catalogService.getProductBySku(sku);
        if (responseDTO != null) {
        Map<String, Object> fm = Utilities.getResponseFieldMap("product", responseDTO);
        dto.setCode("OK");
        dto.setResponseData(fm);
        }
        else {
            dto.setCode("NOT_FOUND");
            dto.setComment("Product is not exist with this sku "+sku);
        }
        return dto;
    }
    @RequestMapping("/create")
    public ResponseDTO createProductCatalog(@RequestBody ProductRequestDTO productRequestDTO)
    {
        Map<String,Object> error = new HashMap<>();
        ResponseDTO dto = new ResponseDTO();
        boolean isValid = catalogService.validateProductDto(error, productRequestDTO);
        if (isValid)
        {
            dto.setCode("OK");
            Product product = catalogService.createProduct(productRequestDTO);
            Map<String, Object> m = Utilities.getResponseFieldMap("Product Successfully created Id", product.getId() + "");
            dto.setResponseData(m);
        }
        else{
            dto.setCode("NOT_OK");
            dto.setResponseData(error);
        }
        return dto;
    }
    @RequestMapping(value = "groupByBrand/{brand}")
    ResponseDTO getAllProductsByBrand(@PathVariable String brand)
    {
        List<ProductResponseDTO> responseDTOS= catalogService.getAllProductsByBrand(brand);
        ResponseDTO responseDTO = new ResponseDTO();
        if (! responseDTOS.isEmpty())
        {
            responseDTO.setCode("OK");
            Map<String, Object> map = Utilities.getResponseFieldMap("All Product", responseDTOS);
            responseDTO.setResponseData(map);
        }
        else{
            responseDTO.setCode("NOT_FOUND");
            responseDTO.setComment("No Product found ");
        }
        return  responseDTO;
    }
    @RequestMapping(value = "getByPriceRang/min/{min}/max/{max}")
    ResponseDTO getAllProductsByPrice(@PathVariable Double min,@PathVariable  Double max)
    {
        List<ProductResponseDTO> responseDTOS= catalogService.getAllProductsByPrice(min, max);
        ResponseDTO responseDTO = new ResponseDTO();
        if (! responseDTOS.isEmpty())
        {
            responseDTO.setCode("OK");
            Map<String, Object> map = Utilities.getResponseFieldMap("All Product", responseDTOS);
            responseDTO.setResponseData(map);
        }
        else{
            responseDTO.setCode("NOT_FOUND");
            responseDTO.setComment("No Product found ");
        }
        return  responseDTO;
    }
    @RequestMapping(value = "groupByColor/{color}")
    ResponseDTO getAllProductsByColor(@PathVariable String color)
    {
        List<ProductResponseDTO> responseDTOS= catalogService.getAllProductsByColor(color);
        ResponseDTO responseDTO = new ResponseDTO();
        if (! responseDTOS.isEmpty())
        {
            responseDTO.setCode("OK");
            Map<String, Object> map = Utilities.getResponseFieldMap("All Product", responseDTOS);
            responseDTO.setResponseData(map);
        }
        else{
            responseDTO.setCode("NOT_FOUND");
            responseDTO.setComment("No Product found ");
        }
        return  responseDTO;
    }
    @RequestMapping(value = "groupBySize/{size}")
    ResponseDTO getAllProductsBySize(@PathVariable String size)
    {
        List<ProductResponseDTO> responseDTOS= catalogService.getAllProductsBySize(size);
        ResponseDTO responseDTO = new ResponseDTO();
        if (! responseDTOS.isEmpty())
        {
            responseDTO.setCode("OK");
            Map<String, Object> map = Utilities.getResponseFieldMap("All Product", responseDTOS);
            responseDTO.setResponseData(map);
        }
        else{
            responseDTO.setCode("NOT_FOUND");
            responseDTO.setComment("No Product found ");
        }
        return  responseDTO;
    }
}
