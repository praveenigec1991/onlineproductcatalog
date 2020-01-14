package com.ecom.onlineproductcatalog.core.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "color")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Color extends BaseEntity {
    private String color;

    @Column(name = "color")
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Color{" + "color='" + color + '\'' + '}';
    }
}
