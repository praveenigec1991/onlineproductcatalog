package com.ecom.onlineproductcatalog.core.entity;

import com.ecom.onlineproductcatalog.core.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "inventory")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Inventory extends BaseEntity {
    private List<Product> inventory;

    @Column(name = "inventory_stock")
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "sku")
    public List<Product> getInventory() {
        return inventory;
    }

    public void setInventory(List<Product> inventory) {
        this.inventory = inventory;
    }
}
