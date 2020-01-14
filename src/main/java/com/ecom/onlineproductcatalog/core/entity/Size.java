package com.ecom.onlineproductcatalog.core.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "size")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Size extends BaseEntity {
    private String size ;

    @Column(name = "size")
    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Size{" + "size='" + size + '\'' + '}';
    }
}
