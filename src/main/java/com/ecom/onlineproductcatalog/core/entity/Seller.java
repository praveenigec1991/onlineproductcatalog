package com.ecom.onlineproductcatalog.core.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "seller")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Seller extends BaseEntity {
    private Inventory inventory;


    @JoinColumn(name = "inventory")
    @OneToOne
    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    @Override
    public String toString() {
        return "Seller{" + "inventory=" + inventory + '}';
    }
}
