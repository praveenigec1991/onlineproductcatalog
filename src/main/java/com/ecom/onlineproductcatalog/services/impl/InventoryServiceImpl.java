package com.ecom.onlineproductcatalog.services.impl;

import com.ecom.onlineproductcatalog.core.entity.Inventory;
import com.ecom.onlineproductcatalog.das.IInventoryDao;
import com.ecom.onlineproductcatalog.services.IInventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class InventoryServiceImpl  implements IInventoryService {

    @Autowired
    private IInventoryDao dao;

    @Override
    public Inventory createInventory(Inventory inventory) {
        inventory.setCreated(new Date());
        inventory.setUpdated(new Date());
        return dao.createInventory(inventory);
    }

    @Override
    public Inventory getInventory(Integer id) {
        return dao.getInventory(id);
    }

    @Override
    public List<Inventory> getAllInventories() {
        return dao.getAllInventories();
    }
}
