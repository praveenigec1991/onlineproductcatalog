package com.ecom.onlineproductcatalog.das;

import com.ecom.onlineproductcatalog.core.entity.Inventory;

import java.util.List;

public interface IInventoryDao {
    Inventory createInventory(Inventory inventory);
    Inventory getInventory(Integer id);
    List<Inventory> getAllInventories();
}
