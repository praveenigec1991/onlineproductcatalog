package com.ecom.onlineproductcatalog.controller;

import com.ecom.onlineproductcatalog.core.Utilities;
import com.ecom.onlineproductcatalog.core.dto.RequestDTO;
import com.ecom.onlineproductcatalog.core.dto.ResponseDTO;
import com.ecom.onlineproductcatalog.core.entity.Category;
import com.ecom.onlineproductcatalog.core.entity.Inventory;
import com.ecom.onlineproductcatalog.services.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping(value = "category")
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;

    @RequestMapping(value = "create",method = RequestMethod.POST)
    public ResponseDTO createCategory(@RequestBody Category category)
    {
        ResponseDTO dto = new ResponseDTO();
        Category ct = categoryService.createCategory(category);
        if(ct != null)
        {
            dto.setCode(HttpStatus.OK.toString());
            dto.setComment("Category create");
            Map<String,Object> m = Utilities.getResponseFieldMap("category_id", ct.getId()+"");
            dto.setResponseData(m);
        }
        else
        {
            dto.setCode(HttpStatus.NOT_ACCEPTABLE.toString());
            dto.setComment("Category not created ");

        }
        return dto;
    }
    public ResponseDTO getInventory(@RequestBody RequestDTO requestDTO)
    {
        Integer id = null;
        ResponseDTO dto = new ResponseDTO();
        try{
            id = Integer.parseInt(requestDTO.getId());
        }
        catch (NumberFormatException e)
        {
            dto.setCode("NOT_OKAY");
            dto.setComment("Invalid inventory id");
            return dto;
        }
        Category category = categoryService.getCategory(id);
        Map<String,Object> fm = Utilities.getResponseFieldMap("category", category);
        dto.setCode("OK");
        dto.setResponseData(fm);
        return dto;
    }


}
