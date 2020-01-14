package com.ecom.onlineproductcatalog.controller;

import com.ecom.onlineproductcatalog.core.Utilities;
import com.ecom.onlineproductcatalog.core.dto.RequestDTO;
import com.ecom.onlineproductcatalog.core.dto.ResponseDTO;
import com.ecom.onlineproductcatalog.core.entity.Inventory;
import com.ecom.onlineproductcatalog.services.IInventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping(value = "inventory")
public class InventoryController {

    @Autowired
    private IInventoryService inventoryService;

    @RequestMapping(value = "create",method = RequestMethod.POST)
    public ResponseDTO createInventory(@RequestBody  Inventory inventory)
    {
        ResponseDTO dto = new ResponseDTO();
        Inventory inv = inventoryService.createInventory(inventory) ;
        if(inv != null)
        {
            dto.setCode(HttpStatus.OK.toString());
            dto.setComment("Inventory create");
            Map<String,Object> m = Utilities.getResponseFieldMap("inventory_id", inv.getId()+"");
            dto.setResponseData(m);
        }
        else
        {
            dto.setCode(HttpStatus.NOT_ACCEPTABLE.toString());
            dto.setComment("Inventory not created create");

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
        Inventory inventory = inventoryService.getInventory(id);
        Map<String,Object> fm = Utilities.getResponseFieldMap("inventory", inventory);
        dto.setCode("OK");
        dto.setResponseData(fm);
        return dto;
    }

}
