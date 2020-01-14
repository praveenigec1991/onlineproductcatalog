package com.ecom.onlineproductcatalog.services;

import com.ecom.onlineproductcatalog.core.entity.Inventory;

import java.util.List;

public interface IInventoryService {
    Inventory createInventory(Inventory inventory);
    Inventory getInventory(Integer id);
    List<Inventory> getAllInventories();
}
